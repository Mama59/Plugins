package plugin;

import java.util.EventObject;

import plugin.listener.PluginFinder;


/**
 * Plugin Event 
 *
 */
public class PluginEvent extends EventObject {

 static final long serialVersionUID = 1L;
 private Plugin plugin;
	
 	/**
 	 * constructor of pluginEvent
 	 * @param source
 	 * @param p
 	 */
 	public PluginEvent(PluginFinder source, Plugin p) {
		super(source);
		this.plugin = p;
		// TODO Auto-generated constructor stub
	}

 	/**
 	 * get the plugin
 	 * @return Plugin
 	 */
	public Plugin getPlugin() {
		return plugin;
	}

	
	/**
	 * set the plugin
	 * @param plugin
	 */
	public void setPlugin(Plugin plugin) {
		this.plugin = plugin;
	}

	
	/**
	 * get the name of the pluginEvent
	 * @return string
	 */
	public String getName() {
		return plugin.getLabel();
	}


	@Override
	public String toString() {
		return "PluginEvent [plugin=" + plugin + "]";
	}
	
}
