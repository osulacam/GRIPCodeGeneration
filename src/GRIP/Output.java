package GRIP;

public class Output {
	protected OutputType type;
	protected int value;
	protected int socket;
	protected String valueType;

	public Output(OutputType type, int value, int socket){
		this.type = type;
		this.value = value;
		this.socket = socket;
		this.valueType = "NoOutputTypeFound";
	}
	
	public boolean is(OutputType type, int value, int socket){
		return (this.type == type && this.value==value && this.socket==socket);
	}
	
	public boolean is(Output out){
		return is(out.type, out.value, out.socket);
	}
	
	public String varName(){
		if(type == OutputType.SOURCE){
			return "source"+value;
		}
		else{
			return type.toString()+value+"Output"+socket;
		}
	}
	
	public void setValueType(String valueType){
		this.valueType = valueType;
	}
	
	public String getValueType(){
		return this.valueType;
	}
	
	
}
