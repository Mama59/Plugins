package Test.filter;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import plugin.Plugin;
import plugin.PluginForTry;
import filter.PluginFinder;

public class TestPluginFinder {
	PluginFinder finder;
	File file;
	@Before
	public void init()
	{
		file = new File("dropinsTest/plugins");
		finder = new PluginFinder(file);
	}
	@Test
	public void testValidGetPlugin()
	{
		assertEquals(finder.getPlugin("ToLowerCase.class").getLabel(), "to lower case"); 
	}
	@Test
	public void testInvalidClassGetPlugin()
	{
		assertEquals(finder.getPlugin("ToLowerCase.clas"), null); 
	}
	@Test
	public void testInvalidGetPlugin()
	{
		assertEquals(finder.getPlugin("ToLowerCe.class"), null); 
	}
	@Test
	public void testClass()
	{
		assertTrue(finder.getContentClass().size() <= finder.getContentPlugin().size()) ;
	}
	@Test
	public void testAddPlugin()
	{
		Plugin p = new PluginForTry("test");
		finder.addPlugin(p);
	}
}
