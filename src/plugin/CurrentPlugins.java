package plugin;

import java.util.HashMap;
import java.util.Map;

public class CurrentPlugins {
	private Map<String, Plugin> plugins;
	public CurrentPlugins() {
		plugins = new HashMap<String,Plugin>();
	}
	
	public Map<String, Plugin> getPlugins() {
		return plugins;
	}
	public Plugin getPlugin(String name) {
		return plugins.get(name);
	}
	public void addPlugin(String name, Plugin plugin) {
		if(! plugins.containsKey(name))
			plugins.put(name, plugin);
	}
	public void removePlugin(String name) {
		if(plugins.containsKey(name))
			plugins.remove(name);
	}

	@Override
	public String toString() {
		return "CurrentPlugins [plugins=" + plugins + "]";
	}
	
}
