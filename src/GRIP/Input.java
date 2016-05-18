package GRIP;

import java.util.List;

public class Input {
	protected int step;
	protected int socket;
	protected List<Object> values;
	
	public Input(int step, int socket, List<Object> values){
		this.step = step;
		this.socket = socket;
		this.values = values;
	}
	public boolean is(int step, int socket){
		return (this.step == step && this.socket==socket);
	}
	
	public boolean is(Input inp){
		return is(inp.step, inp.socket);
	}
}
