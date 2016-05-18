package GRIP;

public class Output {
	protected OutputType type;
	protected int value;
	protected int socket;

	public Output(OutputType type, int value, int socket){
		this.type = type;
		this.value = value;
		this.socket = socket;
	}
	
	public boolean is(OutputType type, int value, int socket){
		return (this.type == type && this.value==value && this.socket==socket);
	}
	
	public boolean is(Output out){
		return is(out.type, out.value, out.socket);
	}
	
	public String varName(){
		return type.toString()+value+"Output"+socket;
	}
}
