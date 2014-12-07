package Test.timer;

import org.junit.Before;
import org.junit.Test;
/**
 * interface for test timer listing listener
 * */
public interface TestTimerListingListener {
	/**
	 * instantiate
	 * */
	@Before
	public void init();
	/**
	 * test action performed
	 * */
	@Test
	public void testActionPerformed();
	void testGetFinder();
}
