package file;

import java.io.File;
import java.io.FilenameFilter;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import plugin.Plugin;


public class PluginFinder {
	
	private static String pluginPackage = "plugins";
	private File file ;
	private URLClassLoader urlLoader;
	private List<PluginListener> pluginListeners = new ArrayList<PluginListener>();
	private FilterPluginFiles filter;
	
	public PluginFinder(File file) 
	{
		this.file = file;
		this.filter = new FilterPluginFiles();
	}
	public synchronized void addPluginFinderListener(PluginListener l) {
		if (pluginListeners.contains(l)) { return ; }
		pluginListeners.add(l);
	}
	
	public synchronized void removePluginListener(PluginListener l){
		pluginListeners.remove(l);
	}
	public Set<String> getContent(FilenameFilter filter) {
		return new HashSet<String>(Arrays.asList(this.file.list(filter)));
	}

	public Set<String> getContentClass() {
		// TODO Auto-generated method stub
		return new HashSet<String>(Arrays.asList(this.file.list(new FilterClassFiles())));
	}

	public Set<String> getContentPlugin() {
		// TODO Auto-generated method stub
		return new HashSet<String>(Arrays.asList(this.file.list(new FilterPluginFiles())));
	}

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
					Class<?> classP;
					try {
						classP = urlLoader.loadClass(name);
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
	
	private void firePluginAdded(Plugin p, String name)
	{
		ArrayList<PluginListener> pl =  new ArrayList<PluginListener>(pluginListeners) ; 
		if (pl.size() == 0) { return ; }
		PluginEvent event = new PluginEvent(this, p, name) ;
		for (PluginListener listener : pl) {
			listener.pluginAdded(event);
		}
	}
	
	private void firePluginRemoved(Plugin p, String name)
	{
		ArrayList<PluginListener> pl =  new ArrayList<PluginListener>(pluginListeners) ; 
		if (pl.size() == 0) { return ; }
		PluginEvent event = new PluginEvent(this, p, name) ;
		for (PluginListener listener : pl) {
			listener.pluginRemoved(event); 
		}
	}
	
	public void addPlugin(Map<String, Plugin> setPlugin) {
		for(String name : setPlugin.keySet())
			firePluginAdded(setPlugin.get(name), name); 
	}
	
	public void removePlugin(Map<String, Plugin> setPlugin) {
		for(String name : setPlugin.keySet())
			firePluginRemoved(setPlugin.get(name), name); 
	}
	
	public void addPlugin(Plugin p, String name) {
			firePluginAdded(p, name); 
	}
	
	public void removePlugin(Plugin p, String name) {
			firePluginRemoved(p, name); 
	}
}
