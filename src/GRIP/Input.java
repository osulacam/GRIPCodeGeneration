package GRIP;

import java.util.ArrayList;
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
			if(values.size() == 0){
				return "NoValue";
			}
			if(values.size() ==1){
				return values.get(0);
			}
			else{
				String result = values.get(0);
				for(int i=1; i<values.size();i++){
					result += "," + values.get(i);
				}
				return result;
			}
		}
		else{
			return "UnconnectedInputStep" + step + "Output" + socket;
		}
	}
	public List<String> varNameAsList(){
		String varName = varName();
		List<String> varNameList= new ArrayList<String>();
		while(varName.contains(",")){
			varNameList.add(varName.substring(0,varName.indexOf(',')));
			varName = varName.substring(varName.indexOf(',')+1);
		}
		varNameList.add(varName);
		return varNameList;
		
	}
	
	
}
