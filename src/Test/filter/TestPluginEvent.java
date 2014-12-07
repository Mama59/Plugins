package Test.filter;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import plugin.Plugin;
import plugin.PluginEvent;
import plugin.PluginForTry;
import plugin.listener.PluginFinder;
/**
 * Test for PluginEvent
 * */
public class TestPluginEvent {
	private PluginEvent event;
	private PluginFinder source;
	private File file;
	private Plugin p;
	/**
	 * init instantiate file, source, plugin and envent
	 * */
	@Before
	public void init()
	{
		file = new File("dropins/plugins");
		source = new PluginFinder(file);
		p = new PluginForTry("try");
		event = new PluginEvent(source, p);
	}
	/**
	 * test if p is equals to event.getPlugin
	 * */
	@Test
	public void testGetPlugin()
	{
		assertEquals(event.getPlugin(), p);
	}
	/**
	 * test if name is equals to event.getname
	 * */
	@Test
	public void testGetName()
	{
		assertEquals(event.getName(), "try");
	}
	/**
	 * test setting Plugin
	 * */
	@Test
	public void testSetPlugin()
	{
		Plugin p2 = new PluginForTry("try2");
		event.setPlugin(p2);
		assertNotEquals(p, event.getPlugin());
	}
	/**
	 * Test ToString
	 * */
	@Test
	public void testToString()
	{
		assertEquals(event.toString(), "PluginEvent [plugin=" + event.getPlugin() + "]");
	}
	/**
	 * necessary for test in other class
	 * return PluginEvent
	 * */
	public PluginEvent getPluginEvent()
	{
		return event;
	}
	/**
	 * necessary for test in other class
	 * returnPlugin
	 * */
	public Plugin getPlugin()
	{
		return p;
	}
}
