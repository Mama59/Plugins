package file;

import java.io.File;
import java.io.FilenameFilter;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import plugin.Plugin;


public class PluginFinder {
	
	private static String pluginPackage = "plugins";
	private File file ;
	private URLClassLoader urlLoader;
	public PluginFinder(File file) 
	{
		this.file = file;
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
					System.out.println("class : " + classP);
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
		return null;
	}
}
