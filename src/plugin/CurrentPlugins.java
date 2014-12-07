package plugin;

import java.util.HashMap;
import java.util.Map;

/**
 * class CurrentPlugins
 * Map<String, Plugin> = Map<name, Plugin>
 *
 */
public class CurrentPlugins {
	private Map<String, Plugin> plugins;
	
	/**
	 * Constructor
	 */
	public CurrentPlugins() {
		plugins = new HashMap<String,Plugin>();
	}
	
	/**
	 * get map of currents plugins with name in key
	 * @return map of plugins
	 */
	public Map<String, Plugin> getPlugins() {
		return plugins;
	}
	
	/**
	 * get a specific plugin
	 * @param name
	 * @return Plugin
	 */
	public Plugin getPlugin(String name) {
		return plugins.get(name);
	}
	
	/**
	 * add a plugin in the currents plugins
	 * @param name
	 * @param plugin
	 */
	public void addPlugin(String name, Plugin plugin) {
		if(! plugins.containsKey(name))
			plugins.put(name, plugin);
	}
	
	/**
	 * remove a plugin of the current plugins
	 * @param name
	 */
	public void removePlugin(String name) {
		if(plugins.containsKey(name))
			plugins.remove(name);
	}

	@Override
	public String toString() {
		return "CurrentPlugins [plugins=" + plugins + "]";
	}
	
}
