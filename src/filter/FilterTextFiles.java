package filter;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 
 * Filter class
 * accept files endsWith .txt
 *
 */
public class FilterTextFiles implements FilenameFilter {
	/**
	 * accept if file is a .txt files
	 * */
	@Override
	public boolean accept(File dir, String name) {
		return name.endsWith(".txt") ;
	}
}
