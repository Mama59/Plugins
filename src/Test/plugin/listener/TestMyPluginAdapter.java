package Test.plugin.listener;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import plugin.CurrentPlugins;
import plugin.listener.MyPluginAdapter;
import plugin.listener.PluginAdapter;
import Test.filter.TestPluginEvent;
import filter.PluginEvent;

public class TestMyPluginAdapter extends TestPluginAdapter {
	protected MyPluginAdapter pluginAdapter;
	@Before
	public void init()
	{
		currentPlugins = new CurrentPlugins();
		pluginAdapter = new MyPluginAdapter(currentPlugins);
	}
	@Test
	public void testPluginAdded()
	{
		TestPluginEvent testPEvent = new TestPluginEvent();
		testPEvent.init();
		PluginEvent pEvent = testPEvent.getPluginEvent();
		pluginAdapter.pluginAdded(pEvent);
		assertEquals(pluginAdapter.getCurrentPlugins().getPlugins().size(), 1);
		assertEquals(pluginAdapter.getCurrentPlugins().getPlugin(pEvent.getName()), pEvent.getPlugin());
	}
	@Test
	public void testPluginRemoved()
	{
		TestPluginEvent testPEvent = new TestPluginEvent();
		testPEvent.init();
		PluginEvent pEvent = testPEvent.getPluginEvent();
		pluginAdapter.pluginAdded(pEvent);
		int sizeBefore = pluginAdapter.getCurrentPlugins().getPlugins().size();
		pluginAdapter.pluginRemoved(pEvent);
		assertEquals(pluginAdapter.getCurrentPlugins().getPlugins().size(), sizeBefore -1);
		assertEquals(pluginAdapter.getCurrentPlugins().getPlugin(pEvent.getName()), null);

	}
	@Test
	@Override
	public void testEquals() {
		// TODO Auto-generated method stub
		MyPluginAdapter pluginAdapter2 = new MyPluginAdapter(currentPlugins);
		assertTrue(pluginAdapter2.equals(pluginAdapter));
		assertEquals(pluginAdapter2.hashCode(), pluginAdapter.hashCode());
	}
	@Test
	@Override
	public void testNotEquals() {
		// TODO Auto-generated method stub
		PluginAdapter pluginAdapter2 = new PluginAdapter();
		TestPluginEvent testPEvent = new TestPluginEvent();
		testPEvent.init();
		PluginEvent pEvent = testPEvent.getPluginEvent();
		pluginAdapter2.pluginAdded(pEvent);
		assertFalse(pluginAdapter2.equals(pluginAdapter));
		assertNotEquals(pluginAdapter2.hashCode(), pluginAdapter.hashCode());
	}
	@Test
	@Override
	public void testNullNotEquals() {
		// TODO Auto-generated method stub
		assertFalse(pluginAdapter.equals(null));
		MyPluginAdapter nullCurrent = new MyPluginAdapter(null);
		assertFalse(pluginAdapter.equals(nullCurrent));
		assertFalse(nullCurrent.equals(pluginAdapter));
		pluginAdapter = new MyPluginAdapter(null);
		assertTrue(pluginAdapter.equals(nullCurrent));
		
	}
	@Test
	@Override
	public void testSimilarEquals() {
		// TODO Auto-generated method stub
		assertTrue(pluginAdapter.equals(pluginAdapter));
	}
}
