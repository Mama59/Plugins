package Test.plugin;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import plugin.CurrentPlugins;
import plugin.Plugin;
import plugin.listener.PluginFinder;
/**
 * Test current Plugins
 * */
public class TestCurrentPlugins {
	private CurrentPlugins currentPlugins;
	/**
	 * instantiate currentPlugins
	 * */
	@Before
	public void init()
	{
		currentPlugins = new CurrentPlugins();
	}
	/**
	 * test a void current plugin
	 * */
	@Test
	public void testVoidMapPlugins()
	{
		assertEquals(currentPlugins.getPlugins().size(), 0);
		
	}
	/**
	 * test to add a plugin
	 * */
	@Test
	public void testAddPlugin()
	{
		PluginFinder src = new PluginFinder(new File("dropinsTest/plugins"));
		Plugin p = src.getPlugin("ToLowerCase.class");
		currentPlugins.addPlugin(p.getLabel(), p);
		assertEquals(currentPlugins.getPlugins().size(), 1);
	}
	/**
	 * test to add a already inside plugin
	 * */
	@Test
	public void testReAddPlugin()
	{
		PluginFinder src = new PluginFinder(new File("dropinsTest/plugins"));
		Plugin p = src.getPlugin("ToLowerCase.class");
		currentPlugins.addPlugin(p.getLabel(), p);
		currentPlugins.addPlugin(p.getLabel(), p);
		assertEquals(currentPlugins.getPlugins().size(), 1);
	}
	/**
	 * test remove plugin
	 * */
	@Test
	public void testRemovePlugin()
	{
		PluginFinder src = new PluginFinder(new File("dropinsTest/plugins"));
		Plugin p = src.getPlugin("ToLowerCase.class");
		currentPlugins.addPlugin(p.getLabel(), p);
		currentPlugins.removePlugin(p.getLabel());
		testVoidMapPlugins();
	}
	/**
	 * test remove unknown plugin, not inside current plugins
	 * */
	@Test
	public void testRemoveUnknownPlugin()
	{
		PluginFinder src = new PluginFinder(new File("dropinsTest/plugins"));
		Plugin p = src.getPlugin("ToLowerCase.class");
		currentPlugins.addPlugin(p.getLabel(), p);
		currentPlugins.removePlugin("test");
		assertEquals(currentPlugins.getPlugins().size(), 1);
	}
	/**
	 * test to string
	 * */
	@Test
	public void testToString()
	{
		PluginFinder src = new PluginFinder(new File("dropinsTest/plugins"));
		Plugin p = src.getPlugin("ToLowerCase.class");
		currentPlugins.addPlugin(p.getLabel(), p);
		assertEquals(currentPlugins.toString(),"CurrentPlugins [plugins=" + currentPlugins.getPlugins() + "]");
	}
}
