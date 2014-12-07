package filter;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 
 * Filter class
 * accept files endsWith .class
 *
 */
public class FilterClassFiles implements FilenameFilter {
/**
 * true if filter accept files endsWith .class
 * false if files not  endsWith .class
 * */
	@Override
	public boolean accept(File dir, String name) {
		return name.endsWith(".class") ;
	}
}
