package file;

import plugin.Plugin;


public class PluginEvent extends java.util.EventObject {

 static final long serialVersionUID = 1L;
 private Plugin plugin;
 private String name;
	public PluginEvent(PluginFinder source, Plugin p, String name) {
		super(source);
		this.plugin = p;
		name = name.replace(".class", "");
		this.name = name;
		// TODO Auto-generated constructor stub
	}

	public Plugin getPlugin() {
		return plugin;
	}

	public void setPlugin(Plugin plugin) {
		this.plugin = plugin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "PluginEvent [plugin=" + plugin + "]";
	}
	
}
