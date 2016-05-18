package GRIP;



public class Source {
	
	protected String name;
	protected String value;
	protected int sourceNumber;
	public Source(String name, String value, int number){
		this.name = name;
		this.value = value;
		this.sourceNumber = number;
	}
	
	public boolean hasOutput(OutputType type, int value, int socket){
		return type==OutputType.SOURCE && value == this.sourceNumber;
	}

}
