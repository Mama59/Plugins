package filter;

import java.io.File;
import java.io.FilenameFilter;

import plugin.Plugin;


/**
 * 
 * Filter plugin files
 * Accept files where corresponding to a plugin 
 *
 */
public class FilterPluginFiles implements FilenameFilter {

	private static String pluginPackage = "plugins";
	private static FilterClassFiles f = new FilterClassFiles();
	/**
	 * accept if files is a plugin
	 * false if not a plugin
	 * */
	@Override
	public boolean accept(File directory, String name) {
		
		if(f.accept(directory, name))
		{
			ClassLoader loader = Plugin.class.getClassLoader();
			name = pluginPackage + "/" + name;
			return (loader.getResource(name) != null);
		}
		return false;
	}
}