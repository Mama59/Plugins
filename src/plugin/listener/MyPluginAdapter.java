package plugin.listener;

import plugin.CurrentPlugins;
import plugin.PluginEvent;

/**
 * class MyPluginAdapter
 *
 */
public class MyPluginAdapter extends plugin.listener.PluginAdapter{

	
	/**
	 * constructor
	 * @param currentPlugins
	 */
	public MyPluginAdapter(CurrentPlugins currentPlugins) 
	{
		super();
		this.currentPlugins = currentPlugins;
	}

	/**
	 * 
	 */
	public void pluginAdded(PluginEvent event) 
	{
		currentPlugins.addPlugin(event.getName(), event.getPlugin());
	}

	
	/**
	 * 
	 */
	public void pluginRemoved(PluginEvent event) 
	{
		currentPlugins.removePlugin(event.getName());
	}

	
	/**
	 * 
	 * @return CurrentPlugins
	 */
	public CurrentPlugins getCurrentPlugins() {
		return currentPlugins;
	}
	
}
