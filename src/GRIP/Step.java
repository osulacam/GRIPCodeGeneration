package GRIP;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	
	public Optional<Input> getInput(Input input){
		for(Input inp : inputs){
			if(inp.is(input))
				return Optional.of(inp);
		}	
		return Optional.empty();
	}
	
	public Optional<Output> getOutput(Output output){
		for(Output out : outputs){
			if(out.is(output))
				return Optional.of(out);
		}	
		return Optional.empty();
	}
	
	public List<Input> getInputs(){
		return inputs;
	}
	
	public List<String>  getInputNames(){ 
			List<String> Lon = new ArrayList<String>();
			inputs.forEach(input -> Lon.add(input.varName()));
			return	Lon;
	}
	
	public static List<String> varNameAsList(String varName){
		List<String> varNameList= new ArrayList<String>();
		while(varName.contains(",")){
			varNameList.add(varName.substring(0,varName.indexOf(',')));
			varName = varName.substring(varName.indexOf(',')+1);
		}
		varNameList.add(varName);
		return varNameList;	
	}
	
	public List<Output> getOutputs(){
		return outputs;
	}
	
	public String toString(){
		String out = "Step: " + name + "\n";
		for(Output output: outputs){
			out += "	output: " + output.varName() + "\n";
		}
		for(Input input: inputs){
			out += "	input: " + input.varName() + "\n";
		}
		return out;
	}
	
	public String getName(){
		return name;
	}
}
