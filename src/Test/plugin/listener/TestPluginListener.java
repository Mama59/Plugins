package Test.plugin.listener;

import org.junit.Test;

public interface TestPluginListener {
	@Test
	public void testPluginAdded();
	@Test
	public void testPluginRemoved();
	@Test
	public void testEquals();
	@Test
	void testNotEquals();
	@Test
	void testNullNotEquals();
	@Test
	void testSimilarEquals();
}
