package GRIP;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Pipeline {
	protected List<Source> sources;
	protected List<Step> steps;
	
	public Pipeline(){
		this.sources = new ArrayList<Source>();
		this.steps = new ArrayList<Step>();
	}
	
	public void addSource(Source source){
		this.sources.add(source);

	}
	
	public void addStep(Step step){
		this.steps.add(step);
	}
	
	
	public String toString(){
		String out = "Pipeline: \n";
		for(Step step: steps){
			out += step.toString() + "\n";
		}
		return out;
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
		connInp.setConnectedOutput(connOut);
	}
	
	public Step getStep(int stepNum){
		return steps.get(stepNum);
	}
}
