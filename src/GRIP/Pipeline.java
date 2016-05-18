package GRIP;

import java.util.ArrayList;
import java.util.List;

public class Pipeline {
	protected List<Source> sources;
	protected List<Step> steps;
	protected List<Connection> connections;
	
	public Pipeline(){
		this.sources = new ArrayList<Source>();
		this.steps = new ArrayList<Step>();
		this.connections = new ArrayList<Connection>();
	}
	
	public void addSource(Source source){
		this.sources.add(source);
	}
	
	public void addStep(Step step){
		this.steps.add(step);
	}
	
	public void addConnection(Connection connection){
		this.connections.add(connection);
	}

}
