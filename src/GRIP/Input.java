package GRIP;

import java.util.List;

public class Input {
	protected int step;
	protected int socket;
	protected Object values;
	protected Output connectedOutput;
	
	public Input(int step, int socket, Object values){
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
}
