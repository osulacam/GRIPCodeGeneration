package deserialization;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import org.jdom2.*;
import org.jdom2.input.SAXBuilder;

public class Project {
	
	public static void main(String args[]){
		Project project = new Project();
		Path path =  Paths.get("PipelinewGrip.grip");
		InputStream file = project.cleanFile(path);
		
		project.parse(file);
	}

	public void parse(InputStream file){
		SAXBuilder saxBuilder = new SAXBuilder();
		try {
			Document document = saxBuilder.build(file);
			Element classElement = document.getRootElement();
			List<Element> pipeline = classElement.getChildren();
			if(pipeline.size()<3){
				System.out.println("bad file");
			}
			List<Element> sources = pipeline.get(0).getChildren();
			List<Element> steps = pipeline.get(1).getChildren();
			List<Element> connections = pipeline.get(2).getChildren();
			for(Element connection: connections){
	            System.out.println("\nCurrent Element :" 
	               + connection.getName());
				Element output = connection.getChild("Output");
				System.out.println("step= " + output.getAttribute("step"));
				System.out.println("socket= " + output.getAttributeValue("socket"));
				System.out.println("previewed= " + output.getAttributeValue("previewed"));
				
				Element input = connection.getChild("Input");
				System.out.println("step= " + input.getAttributeValue("step"));
				System.out.println("socket= " + input.getAttributeValue("socket"));
				
			}
			
			
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public InputStream cleanFile(Path file){
		
		final String EoL = System.getProperty("line.separator");
		List<String> lines;
		String content = "";
		try {
			lines = Files.readAllLines(file,
			        Charset.defaultCharset());
			StringBuilder sb = new StringBuilder();
			for (String line : lines) {
			    sb.append(line).append(EoL);
			}
			content = sb.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		content = content.replaceAll("grip:", "");
		//System.out.println(content);
		InputStream stream = new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8));
		return stream;

	}
}
