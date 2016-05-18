package GRIP;

public class Connection {
	protected Input input;
	protected Output output;
	
	public Connection(Input input, Output output){
		this.input = input;
		this.output = output;
	}
	public String getId(){
		return output.varName();
	}
	
}
