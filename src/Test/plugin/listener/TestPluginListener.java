package Test.plugin.listener;

import org.junit.Before;
import org.junit.Test;
/**
 * interface test plugin listener
 * */
public interface TestPluginListener {
	/**
	 * instantiate
	 * */
	@Before
	public void init();
	/**
	 * test plugin added
	 * */
	@Test
	public void testPluginAdded();
	/**
	 * test removed plugin
	 * */
	@Test
	public void testPluginRemoved();
	/**
	 * test equals into plugins
	 * */
	@Test
	public void testEquals();
	/**
	 * test not equals into plugins
	 * */
	@Test
	void testNotEquals();
	/**
	 * test null not equals to a plugin
	 * */
	@Test
	void testNullNotEquals();
	/**
	 * test equals into similar plugin
	 * */
	@Test
	void testSimilarEquals();
}
