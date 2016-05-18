package GRIP;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
<<<<<<< HEAD
	}
	
	public void addStep(Step step){
		this.steps.add(step);
	}
	
	public void addConnection(Connection connection){
		this.connections.add(connection);
=======
>>>>>>> b14a64baf1d5be74da6ef3db707cb6984f4d55c0
	}

	public void addStep(Step step){
		this.steps.add(step);
	}
	public void makeConnection(Input inp, Output out){
		Input connInp = null;
		Output connOut = null;
		for(Step step : steps){
			Optional<Input> tempInp = step.getInput(inp);
			if(tempInp.isPresent()){
				connInp = tempInp.get();
				}
			Optional<Output> tempOut = step.getOutput(out);
			if(tempOut.isPresent()){
				connOut = tempOut.get();
			}
		}
		this.connections.add(new Connection(connInp, connOut));
	}
}
