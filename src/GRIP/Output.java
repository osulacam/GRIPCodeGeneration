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
}
