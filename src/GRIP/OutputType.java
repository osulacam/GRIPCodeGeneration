package GRIP;

public enum OutputType {
	STEP,SOURCE;
	public String toString(){
		switch(this){
			case STEP: return "Step";
			case SOURCE: return "Source";
			default: return "UnknownType";
		}
		
	}
}
