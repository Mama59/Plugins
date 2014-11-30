package Test.filter;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import filter.FilterPluginFiles;

public class TestFilterPluginFiles
{
	FilterPluginFiles filter;
	File file;
	@Before
	public void init()
	{
		filter = new FilterPluginFiles();
		file = new File("dropinsTest/plugins");
	}
	
	@Test
	public void testAcceptFalseDotCLassNotPLugins()
	{
		assertFalse(filter.accept(file,"truc.class"));
	}
	@Test
	public void testAcceptFalseNotDotCLass()
	{
		assertFalse(filter.accept(file,"truclass"));
	}
	@Test
	public void testAcceptTrue()
	{
		assertTrue(filter.accept(file, "ToLowerCase.class"));
	}
	
}
