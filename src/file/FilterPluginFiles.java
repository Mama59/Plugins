package file;

import java.io.File;
import java.io.FilenameFilter;
import java.net.URL;
import java.net.URLClassLoader;

import plugin.Plugin;


public class FilterPluginFiles implements FilenameFilter {

	private static FilterClassFiles filter  = new FilterClassFiles();
	private URLClassLoader urlLoader;
	private static String pluginPackage = "plugins";
	@Override
	public boolean accept(File directory, String name) {
		if(filter.accept(directory, name))
		{
			ClassLoader loader = Plugin.class.getClassLoader();
			name = pluginPackage + "/" + name;
			if(loader.getResource(name) != null)
			{
				try {
					URL url = loader.getResource(name);
					URL[] urls = { url };
					urlLoader = new URLClassLoader(urls);
					name = name.replace(".class","").replace("/",".");
					urlLoader.loadClass(name);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

				}
			}
		}
		return false;
	}
}