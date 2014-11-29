package Model;

import java.util.HashSet;
import java.util.Set;

import plugin.Plugin;

public class CurrentPlugins {
	private Set<Plugin> plugins;

	public CurrentPlugins() {
		plugins = new HashSet<Plugin>();
	}
	
	public Set<Plugin> getPlugins() {
		return plugins;
	}

	public void addPlugin(Plugin plugin) {
		if(! plugins.contains(plugin))
			plugins.add(plugin);
	}
	public void removePlugin(Plugin plugin) {
		if(plugins.contains(plugin))
			plugins.remove(plugin);
	}
	
}
