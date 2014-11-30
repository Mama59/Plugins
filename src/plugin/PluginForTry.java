package plugin;

public class PluginForTry implements Plugin {
	String label;
	public PluginForTry(String name) {
		// TODO Auto-generated constructor stub
	label = name;	
	}

	@Override
	public String transform(String s) {
		// TODO Auto-generated method stub
		return s;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return label;
	}

	@Override
	public String helpMessage() {
		// TODO Auto-generated method stub
		return "it's just a try";
	}

}
