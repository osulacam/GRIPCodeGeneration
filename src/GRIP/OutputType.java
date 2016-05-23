package GRIP;

public enum OutputType {
	STEP,SOURCE;
	public String toString(){
		switch(this){
			case STEP: return "step";
			case SOURCE: return "source";
			default: return "unknownType";
		}
		
	}
}
