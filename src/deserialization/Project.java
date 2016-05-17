package deserialization;

import java.io.*;
import java.util.*;
import org.jdom2.*;
import org.jdom2.input.SAXBuilder;

public class Project {
	
	public static void main(String args[]){
		Project project = new Project();
		File file = new File("Pipeline.grip");
		project.parse(file);
	}

	public void parse(File inputFile){
		SAXBuilder saxBuilder = new SAXBuilder();
		try {
			Document document = saxBuilder.build(inputFile);
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
				System.out.println("step= " + output.getAttributeValue("step"));
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
}
