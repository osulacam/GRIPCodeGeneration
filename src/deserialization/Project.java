package deserialization;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import org.jdom2.*;
import org.jdom2.input.SAXBuilder;

import GRIP.Input;
import GRIP.Output;
import GRIP.OutputType;
import GRIP.Pipeline;
import GRIP.Step;

public class Project {
	
	protected final Pipeline pipeline = new Pipeline();
	
	public static final String linebreak = "--------------------------------------------";
	
	
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
				System.err.println("bad file");
			}
			List<Element> sources = pipeline.get(0).getChildren();
			addAllSources(sources);
			
			System.out.println(linebreak);
			List<Element> steps = pipeline.get(1).getChildren();
			addAllSteps(steps);

			System.out.println(linebreak);
			List<Element> connections = pipeline.get(2).getChildren();
			addAllConnections(connections);			
			
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void addAllSources(List<Element> sources) {
		//sources not implemented for this version
		/*for(Element source: sources){
			System.out.println("Type = " + source.getName());
			for(Element property: source.getChildren()){
				System.out.println("Property " + property.getAttributeValue("name") + " = " +
			property.getAttributeValue("value"));
			}
		}*/	
	}

	private void addAllSteps(List<Element> steps) {
		for(Element step : steps){
		
			String name = step.getAttributeValue("name");
			Step stepToAdd = new Step(name);
			for(Element input: step.getChildren("Input")){
				int stepNum = Integer.parseInt(input.getAttributeValue("step"));
				int socketNum = Integer.parseInt(input.getAttributeValue("socket"));
				Element value = input.getChild("value");
				stepToAdd.addInput(new Input(stepNum,socketNum,value));
				
			}
			for(Element output: step.getChildren("Output")){
				OutputType type;
				int value;
				if(!output.getAttributeValue("step").isEmpty()){
					type = OutputType.STEP;
					value = Integer.parseInt(output.getAttributeValue("step"));
				}
				else{
					type = OutputType.SOURCE;
					value = Integer.parseInt(output.getAttributeValue("step"));
				}
				
				int socketNum = Integer.parseInt(output.getAttributeValue("socket"));
				stepToAdd.addOutput(new Output(type, value, socketNum));
			}
			
			
			/*System.out.println("Step " + step.getAttributeValue("name"));
			for(Element input: step.getChildren("Input")){
				System.out.print("Input for step " + input.getAttributeValue("step")+
						" in socket " + input.getAttributeValue("socket"));
				Element value = input.getChild("value");
				if(value != null){
					System.out.println(" is " + value.getValue());
				}
				else{
					System.out.println();
				}
			}*/
		}
		
	}
	
	private void addAllConnections(List<Element> connections) {
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
