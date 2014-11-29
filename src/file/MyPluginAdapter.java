package file;

import Model.CurrentPlugins;


public class MyPluginAdapter extends file.PluginAdapter{

	private CurrentPlugins currentPlugins;

	public MyPluginAdapter(CurrentPlugins currentPlugins) {
		super();
		this.currentPlugins = currentPlugins;
	}

	public void pluginAdded(PluginEvent event) 
	{
		currentPlugins.addPlugin(event.getPlugin());
		System.out.println("added "+ event.toString());
	}

	public void pluginRemoved(PluginEvent event) 
	{
		currentPlugins.removePlugin(event.getPlugin());
		System.out.println("removed "  + event.toString());
	}

}
