package deserialization;

import java.io.InputStream;
import java.io.StringWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.context.Context;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;

import GRIP.Pipeline;

public class Exporter {
	
	VelocityEngine ve = new VelocityEngine();
	
	public static void main(String args[]){
		Project project = new Project();
		Path path =  Paths.get("PipelinewGrip.grip");
		InputStream file = project.cleanFile(path);
		project.parse(file);
		Pipeline pipeline = project.getPipeline();
		//System.out.println(pipeline);
		Exporter exporter = new Exporter();

		exporter.export(pipeline);
		
	}
	
	public Exporter(){
		Velocity.init();
	}
	
	public void export(Pipeline pipeline){
		
		VelocityContext context = new VelocityContext();
		context.put( "pipeline", pipeline);
		String template = "/src/export/Pipeline.vm";

		StringWriter sw = new StringWriter();
		Velocity.mergeTemplate(template,context,sw);
		System.out.println(sw);
		
	}
	

	
	
}
