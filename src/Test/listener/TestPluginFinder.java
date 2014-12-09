package Test.listener;

import static org.junit.Assert.*;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import plugin.CurrentPlugins;
import plugin.Plugin;
import plugin.PluginForTry;
import plugin.listener.MyPluginAdapter;
import plugin.listener.PluginFinder;
/**
 * Test plugin finder
 * */
public class TestPluginFinder {
	PluginFinder finder;
	File file;
	/**
	 * instantiate file and plugin finder
	 * */
	@Before
	public void init()
	{
		file = new File("dropinsTest/plugins");
		finder = new PluginFinder(file);
	}
	/**
	 * test valid plugin
	 * */
	@Test
	public void testValidGetPlugin()
	{
		assertEquals(finder.getPlugin("ToLowerCase.class").getLabel(), "to lower case"); 
	}
	/**
	 * test invalid plugin class
	 * */
	@Test
	public void testInvalidClassGetPlugin()
	{
		assertEquals(finder.getPlugin("ToLowerCase.clas"), null); 
	}
	/**
	 * test invalid plugin
	 * */
	@Test
	public void testInvalidGetPlugin()
	{
		assertEquals(finder.getPlugin("ToLowerCe.class"), null);
	}
	/**
	 * test class
	 * */
	@Test
	public void testClass()
	{
		assertTrue(finder.getContentClass().size() <= finder.getContentPlugin().size()) ;
	}
	/**
	 * test add plugin
	 * */
	@Test
	public void testAddPlugins()
	{
		Set<Plugin> plugins = new HashSet<Plugin>();
		finder.addPlugins(plugins);
	}
	/**
	 *Test removed Plugin with listener 
	 * */
	@Test
	public void testRemovePlugins()
	{
		MyPluginAdapter listener = new MyPluginAdapter(new CurrentPlugins());
		finder.addPluginFinderListener(listener);
		Set<Plugin> plugins = new HashSet<Plugin>();
		int before = finder.getContentPlugin().size();
		plugins.add(new PluginForTry("test"));
		plugins.add(new PluginForTry("test2"));
		plugins.add(new PluginForTry("test3"));
		finder.addPlugins(plugins);
		finder.removePlugins(plugins);
		assertEquals(before, finder.getContentPlugin().size());
	}
	/**
	 *Test removed Plugin without listener 
	 * */
	@Test
	public void testRemovePluginWithoutListener()
	{
		Plugin p = new PluginForTry("test");
		finder.addPlugin(p);
		finder.removePlugin(p);
	}
	/**
	 * test add listener 
	 * */
	@Test
	public void testAddListener()
	{
		MyPluginAdapter listener = new MyPluginAdapter(new CurrentPlugins());
		int before = finder.getNumbersOfListeners();
		finder.addPluginFinderListener(listener);
		assertEquals(before + 1, finder.getNumbersOfListeners());
		finder.addPluginFinderListener(listener);
		assertEquals(before + 1, finder.getNumbersOfListeners());
		
	}
	/**
	 * test remove listener 
	 * */
	@Test
	public void testRemoveListener()
	{
		MyPluginAdapter listener = new MyPluginAdapter(new CurrentPlugins());
		int before = finder.getNumbersOfListeners();
		finder.removePluginFinderListener(listener);
		assertEquals(before, finder.getNumbersOfListeners());
		finder.addPluginFinderListener(listener);
		assertEquals(before +1 , finder.getNumbersOfListeners());
		finder.removePluginFinderListener(listener);
		assertEquals(before, finder.getNumbersOfListeners());
	}
}
