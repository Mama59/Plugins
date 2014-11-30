package plugin.listener;

import plugin.CurrentPlugins;
import filter.PluginEvent;


public class MyPluginAdapter extends plugin.listener.PluginAdapter{

	private CurrentPlugins currentPlugins;

	public MyPluginAdapter(CurrentPlugins currentPlugins) {
		super();
		this.currentPlugins = currentPlugins;
	}

	public void pluginAdded(PluginEvent event) 
	{
		currentPlugins.addPlugin(event.getName(), event.getPlugin());
	}

	public void pluginRemoved(PluginEvent event) 
	{
		currentPlugins.removePlugin(event.getName());
	}
}
