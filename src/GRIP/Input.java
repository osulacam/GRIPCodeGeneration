package GRIP;

import java.util.List;

public class Input {
	protected int step;
	protected int socket;
	protected List<String> values;
	protected Output connectedOutput;
	
	public Input(int step, int socket, List<String> values){
		this.step = step;
		this.socket = socket;
		this.values = values;
		this.connectedOutput = null;
	}
	
	public Input(int step, int socket){
		this.step = step;
		this.socket = socket;
		this.values = null;
		this.connectedOutput = null;
	}
	
	public boolean is(int step, int socket){
		return (this.step == step && this.socket==socket);
	}
	
	public boolean is(Input inp){
		return is(inp.step, inp.socket);
	}
	
	public void setConnectedOutput(Output output){
		this.connectedOutput = output;
	}
	
	public String varName(){
		if(connectedOutput!=null){
			return connectedOutput.varName();
		}
		else if(values!=null){
			String result = "Values [";
			for(String val : values){
				result += val+",";
			}
			result += "]";
			return result;
		}
		else{
			return "UnconnectedInputStep" + step + "Output" + socket;
		}
	}
}
