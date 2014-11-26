package file;

import java.io.File;
import java.io.FilenameFilter;

import plugin.Plugin;

public class FilterPluginFiles implements FilenameFilter {

	private static FilterClassFiles filter  = new FilterClassFiles();
	private static String pluginPackage = "plugins";
	@Override
	public boolean accept(File directory, String name) {
		if(filter.accept(directory, name))
		{
			ClassLoader loader = Plugin.class.getClassLoader();
			name = pluginPackage + "/" + name;
			return (loader.getResource(name) != null);
		}
		return false;
	}
}