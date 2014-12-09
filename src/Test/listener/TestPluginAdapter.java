package Test.listener;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Test.filter.TestPluginEvent;
import plugin.CurrentPlugins;
import plugin.PluginEvent;
import plugin.listener.PluginAdapter;
/**
 * Test plugin adapter implements testpluginlistener
 * */
public class TestPluginAdapter implements TestPluginListener{
	private PluginAdapter pluginAdapter;
	protected CurrentPlugins currentPlugins;

	@Before
	public void init()
	{
		currentPlugins = new CurrentPlugins();
		pluginAdapter = new PluginAdapter();
	}
	@Test
	@Override
	public void testPluginAdded() {
		TestPluginEvent testPEvent = new TestPluginEvent();
		testPEvent.init();
		PluginEvent pEvent = testPEvent.getPluginEvent();
		PluginAdapter pluginAdapter2 = new PluginAdapter();
		pluginAdapter.pluginAdded(pEvent);
		assertEquals(pluginAdapter, pluginAdapter2);
	}
	@Test
	@Override
	public void testPluginRemoved() {
		TestPluginEvent testPEvent = new TestPluginEvent();
		testPEvent.init();
		PluginEvent pEvent = testPEvent.getPluginEvent();
		PluginAdapter pluginAdapter2 = new PluginAdapter();
		pluginAdapter.pluginRemoved(pEvent);
		assertEquals(pluginAdapter, pluginAdapter2);
	}
	@Override
	public void testEquals() {
		// TODO Auto-generated method stub
		PluginAdapter pluginAdapter2 = new PluginAdapter();
		assertTrue(pluginAdapter2.equals(pluginAdapter));
		assertEquals(pluginAdapter2.hashCode(), pluginAdapter.hashCode());
	}
	@Test
	@Override
	public void testNullNotEquals() {
		assertFalse(pluginAdapter.equals(null));

	}
	@Override
	public void testNotEquals() {}
	@Override
	public void testSimilarEquals() {
		assertTrue(pluginAdapter.equals(pluginAdapter));
	}
	
	

}
