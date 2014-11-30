package Test.plugin;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import filter.PluginFinder;
import plugin.CurrentPlugins;
import plugin.Plugin;

public class TestCurrentPlugins {
	private CurrentPlugins currentPlugins;
	@Before
	public void init()
	{
		currentPlugins = new CurrentPlugins();
	}
	@Test
	public void testVoidMapPlugins()
	{
		assertEquals(currentPlugins.getPlugins().size(), 0);
		
	}
	@Test
	public void testAddPlugin()
	{
		PluginFinder src = new PluginFinder(new File("dropinsTest/plugins"));
		Plugin p = src.getPlugin("ToLowerCase.class");
		currentPlugins.addPlugin(p.getLabel(), p);
		assertEquals(currentPlugins.getPlugins().size(), 1);
	}
	@Test
	public void testReAddPlugin()
	{
		PluginFinder src = new PluginFinder(new File("dropinsTest/plugins"));
		Plugin p = src.getPlugin("ToLowerCase.class");
		currentPlugins.addPlugin(p.getLabel(), p);
		currentPlugins.addPlugin(p.getLabel(), p);
		assertEquals(currentPlugins.getPlugins().size(), 1);
	}
	@Test
	public void testRemovePlugin()
	{
		PluginFinder src = new PluginFinder(new File("dropinsTest/plugins"));
		Plugin p = src.getPlugin("ToLowerCase.class");
		currentPlugins.addPlugin(p.getLabel(), p);
		currentPlugins.removePlugin(p.getLabel());
		testVoidMapPlugins();
	}
	@Test
	public void testRemoveUnknownPlugin()
	{
		PluginFinder src = new PluginFinder(new File("dropinsTest/plugins"));
		Plugin p = src.getPlugin("ToLowerCase.class");
		currentPlugins.addPlugin(p.getLabel(), p);
		currentPlugins.removePlugin("test");
		assertEquals(currentPlugins.getPlugins().size(), 1);
	}
	@Test
	public void testToString()
	{
		PluginFinder src = new PluginFinder(new File("dropinsTest/plugins"));
		Plugin p = src.getPlugin("ToLowerCase.class");
		currentPlugins.addPlugin(p.getLabel(), p);
		assertEquals(currentPlugins.toString(),"CurrentPlugins [plugins=" + currentPlugins.getPlugins() + "]");
	}
}
