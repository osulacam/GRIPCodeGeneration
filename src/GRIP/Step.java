package GRIP;

import java.util.ArrayList;
import java.util.List;

public class Step {
	protected String name;
	protected List<Input> inputs;
	protected List<Output> outputs;
	
	public Step(String name){
		this.name = name;
		this.inputs = new ArrayList<Input>();
		this.outputs = new ArrayList<Output>();
	}
	
	public void addInput(Input input){
		inputs.add(input);
	}
	
	public void addOutput(Output output){
		outputs.add(output);
	}
	
}
