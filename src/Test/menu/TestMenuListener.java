package Test.menu;

import org.junit.Test;
/**
 * interface to Test menuListener
 * */
public interface TestMenuListener {
	/**
	 * Test if ok
	 * */
	@Test
	public void testOk();
	/**
	 * Test if not ok
	 * */
	@Test
	public void testNotOk();
	/**
	 * test if change Text
	 * */
	@Test
	public void testActionChangeText();
	/**
	 * Test if action changes depending on the plugin
	 * */
	@Test
	public void testActionChange();
}
