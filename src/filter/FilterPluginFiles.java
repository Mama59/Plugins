package filter;

import java.io.File;
import java.io.FilenameFilter;

import plugin.Plugin;

public class FilterPluginFiles implements FilenameFilter {

	private static String pluginPackage = "plugins";
	private static FilterClassFiles f = new FilterClassFiles();
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