package file;

import java.io.File;
import java.io.FilenameFilter;

public class FilterClassFiles implements FilenameFilter {

	@Override
	public boolean accept(File dir, String name) {
		return name.endsWith(".class") ;
	}
}
