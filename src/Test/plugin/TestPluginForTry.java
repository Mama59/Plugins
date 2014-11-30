package Test.plugin;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import plugin.PluginForTry;

public class TestPluginForTry implements TestPlugin {

	PluginForTry plugin;
	String name;
	@Before
	public void init()
	{
		name = "test";
		plugin = new PluginForTry(name);
	}
	@Test
	@Override
	public void testGetLabel() {
		// TODO Auto-generated method stub
		
		assertEquals(plugin.getLabel(), name);
	}

	@Test
	@Override
	public void testHelpMessage() {
		// TODO Auto-generated method stub
		assertEquals("it's just a try", plugin.helpMessage());
	}

	@Test
	@Override
	public void testTransform() {
		// TODO Auto-generated method stub
		String test = "try";
		assertEquals(plugin.transform(test), test);
	}

}
