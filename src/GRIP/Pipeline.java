package GRIP;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pipeline {
	private final List<Source> sources = new ArrayList<>();
	private final List<Step> steps = new ArrayList<>();
	private final Set<Connection> connections = new HashSet<>();
	private ProjectSettings settings = new ProjectSettings();
	

}
