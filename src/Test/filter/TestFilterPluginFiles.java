package Test.filter;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import filter.FilterPluginFiles;
/**
 * Test for FilterPluginFiles
 * */
public class TestFilterPluginFiles
{
	FilterPluginFiles filter;
	File file;
	/**
	 * init to instantiate filter and file
	 * */
	@Before
	public void init()
	{
		filter = new FilterPluginFiles();
		file = new File("dropinsTest/plugins");
	}
	/**
	 * Test no-accept when not a plugin
	 * */
	@Test
	public void testAcceptFalseDotCLassNotPLugins()
	{
		assertFalse(filter.accept(file,"truc.class"));
	}
	/**
	 * Test no-accept when not a .class
	 * */
	@Test
	public void testAcceptFalseNotDotCLass()
	{
		assertFalse(filter.accept(file,"truclass"));
	}
	/**
	 * Test no-accept when is a plugin
	 * */
	@Test
	public void testAcceptTrue()
	{
		assertTrue(filter.accept(file, "ToLowerCase.class"));
	}
	
}
