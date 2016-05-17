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
		String linebreak = "--------------------------------------------";
		SAXBuilder saxBuilder = new SAXBuilder();
		try {
			Document document = saxBuilder.build(inputFile);
			Element classElement = document.getRootElement();
			List<Element> pipeline = classElement.getChildren();
			if(pipeline.size()<3){
				System.err.println("bad file");
			}
			List<Element> sources = pipeline.get(0).getChildren();
			for(Element source: sources){
				System.out.println("Type = " + source.getName());
				for(Element property: source.getChildren()){
					System.out.println("Property " + property.getAttributeValue("name") + " = " +
				property.getAttributeValue("value"));
				}
			}
			System.out.println(linebreak);
			List<Element> steps = pipeline.get(1).getChildren();
			for(Element step : steps){
				System.out.println("Step " + step.getAttributeValue("name"));
				for(Element input: step.getChildren("Input")){
					System.out.print("Input for step " + input.getAttributeValue("step")+
							" in socket " + input.getAttributeValue("socket"));
					Element value = input.getChild("value");
					if(value != null){
						System.out.println(" is " + value.getValue());
					}
					else{
						System.out.println();;
					}
				}
			}
			System.out.println(linebreak);
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
