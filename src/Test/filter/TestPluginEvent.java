package Test.filter;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import plugin.Plugin;
import plugin.PluginForTry;
import filter.PluginEvent;
import filter.PluginFinder;

public class TestPluginEvent {
	private PluginEvent event;
	private PluginFinder source;
	private File file;
	private Plugin p;
	@Before
	public void init()
	{
		file = new File("dropins/plugins");
		source = new PluginFinder(file);
		p = new PluginForTry("try");
		event = new PluginEvent(source, p);
	}
	@Test
	public void testGetPlugin()
	{
		assertEquals(event.getPlugin(), p);
	}
	@Test
	public void testGetName()
	{
		assertEquals(event.getName(), "try");
	}
	@Test
	public void testSetPlugin()
	{
		Plugin p2 = new PluginForTry("try2");
		event.setPlugin(p2);
		assertNotEquals(p, event.getPlugin());
	}
	@Test
	public void testToString()
	{
		assertEquals(event.toString(), "PluginEvent [plugin=" + event.getPlugin() + "]");
	}
	public PluginEvent getPluginEvent()
	{
		return event;
	}
	public Plugin getPlugin()
	{
		return p;
	}
}
