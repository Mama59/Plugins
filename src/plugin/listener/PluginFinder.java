package plugin.listener;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import filter.FilterClassFiles;
import filter.FilterPluginFiles;
import plugin.Plugin;
import plugin.PluginEvent;

/**
 * 
 * Plugin finder 
 *
 */
public class PluginFinder extends PluginAdapter{
	
	private static String pluginPackage = "plugins";
	private File file ;
	private URLClassLoader urlLoader;
	private List<PluginListener> pluginListeners = new ArrayList<PluginListener>();
	private FilterPluginFiles filter;
	
	
	/**
	 * Constructor
	 * @param file
	 */
	public PluginFinder(File file) 
	{
		this.file = file;
		this.filter = new FilterPluginFiles();
	}
	
	/**
	 * add a plugin listener
	 * @param l
	 */
	public synchronized void addPluginFinderListener(PluginListener l) 
	{
		if (pluginListeners.contains(l)) 
			return;
		pluginListeners.add(l);
	}
	
	
	/**
	 * remove a pluginListener
	 * @param l
	 */
	public synchronized void removePluginFinderListener(PluginListener l){
		if(pluginListeners.contains(l))
			pluginListeners.remove(l);
	}
	
	public int getNumbersOfListeners() {
		return pluginListeners.size();
	}

	/**
	 * get the content of the class
	 * @return set of string
	 */
	public Set<String> getContentClass() {
		// TODO Auto-generated method stub
		return new HashSet<String>(Arrays.asList(this.file.list(new FilterClassFiles())));
	}

	/**
	 * get the content of the plugin
	 * @return set of string who content the content of the plugin
	 */
	public Set<String> getContentPlugin() {
		// TODO Auto-generated method stub
		return new HashSet<String>(Arrays.asList(this.file.list(new FilterPluginFiles())));
	}

	
	/**
	 * Get the plugin whose name is 'param'
	 * @param name
	 * @return Plugin
	 */
	public Plugin getPlugin(String name) {
		// TODO Auto-generated method stub
		if(filter.accept(file, name))
		{
			ClassLoader loader = Plugin.class.getClassLoader();
			name = pluginPackage + "/" + name;
			if(loader.getResource(name) != null)
			{
					URL url = loader.getResource(name);
					URL[] urls = { url };
					urlLoader = new URLClassLoader(urls);
					name = name.replace(".class","");
					name = name.replace("/",".");
					try {
						Class<?> classP = urlLoader.loadClass(name);
						return (Plugin) classP.newInstance();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}
		return null;
	}
	
	/**
	 * notify all listeners when added plugin
	 * @param p
	 */
	private void firePluginAdded(Plugin p)
	{
		ArrayList<PluginListener> pl =  new ArrayList<PluginListener>(pluginListeners) ; 
		if (pl.size() == 0) { return ; }
		PluginEvent event = new PluginEvent(this, p) ;
		for (PluginListener listener : pl) {
			listener.pluginAdded(event);
		}
	}
	
	/**
	 * notify all listeners when removed plugin
	 * @param p
	 */
	private void firePluginRemoved(Plugin p)
	{
		ArrayList<PluginListener> pl =  new ArrayList<PluginListener>(pluginListeners) ; 
		if (pl.size() == 0) { return ; }
		PluginEvent event = new PluginEvent(this, p) ;
		for (PluginListener listener : pl) {
			listener.pluginRemoved(event); 
		}
	}
	
	
	/**
	 * Add a set of plugin
	 * @param setPlugin
	 */
	public void addPlugins(Set<Plugin> setPlugin) {
		for(Plugin p : setPlugin)
			firePluginAdded(p); 
	}
	
	
	/**
	 * Set the plugin
	 * @param setPlugin
	 */
	public void removePlugins(Set<Plugin> setPlugin) {
		for(Plugin p : setPlugin)
			firePluginRemoved(p); 
	}
	
	/**
	 * Add a plugin
	 * @param p
	 */
	public void addPlugin(Plugin p) {
			firePluginAdded(p); 
	}
	
	
	/**
	 * Remove a plugin
	 * @param p
	 */
	public void removePlugin(Plugin p) {
			firePluginRemoved(p); 
	}
}
