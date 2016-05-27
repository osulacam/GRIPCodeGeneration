package deserialization;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import javax.swing.JFileChooser;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

import GRIP.Pipeline;

public class Exporter {
	
	VelocityEngine ve = new VelocityEngine();
	
	public static void main(String args[]){
		Project project = new Project();
		Path path =  Paths.get("ResizeGreenCube.grip");
		InputStream file = project.cleanFile(path);
		project.parse(file);
		Pipeline pipeline = project.getPipeline();
		//System.out.println(pipeline);
		Exporter exporter = new Exporter();

		exporter.export(pipeline);
		
	}
	 
	/**
	 * This is the default constructor that just initializes velocity.
	 */
	public Exporter(){
		Velocity.init();
	}
	
	/**
	 * This prints out a generated Pipeline
	 * @param pipeline pipeline a class created by the project class that includes all the
	 * 		  information about the pipeline to be generated
	 */
	public void export(Pipeline pipeline){
		
		VelocityContext context = new VelocityContext();
		context.put( "pipeline", pipeline);
		String template = "/src/export/Pipeline.vm";

		StringWriter sw = new StringWriter();
		Velocity.mergeTemplate(template,context,sw);
		System.out.println(sw);
		PrintWriter writer;
		try {
			writer = new PrintWriter("PipelineTest.java", "UTF-8");
			writer.println(sw);
			writer.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		
	}
	

	
	
}
