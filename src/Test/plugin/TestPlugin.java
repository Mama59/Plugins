package Test.plugin;

import org.junit.Test;
/**
 * Test Plugin
 * */
public interface TestPlugin {
	/**
	 * testGetlabel
	 * */
	@Test
	public void testGetLabel();
	/**
	 * test helpmessage
	 * */
	@Test
	public void testHelpMessage();
	/**
	 * test transform
	 * */
	@Test
	public void testTransform();
}
