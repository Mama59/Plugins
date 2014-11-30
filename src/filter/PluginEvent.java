package filter;

import java.util.EventObject;

import plugin.Plugin;


public class PluginEvent extends EventObject {

 static final long serialVersionUID = 1L;
 private Plugin plugin;
	public PluginEvent(PluginFinder source, Plugin p) {
		super(source);
		this.plugin = p;
		// TODO Auto-generated constructor stub
	}

	public Plugin getPlugin() {
		return plugin;
	}

	public void setPlugin(Plugin plugin) {
		this.plugin = plugin;
	}

	public String getName() {
		return plugin.getLabel();
	}


	@Override
	public String toString() {
		return "PluginEvent [plugin=" + plugin + "]";
	}
	
}
