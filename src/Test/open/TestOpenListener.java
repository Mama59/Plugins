package Test.open;

import org.junit.Before;
import org.junit.Test;

/**
 * Test interface of open listener
 * */
public interface TestOpenListener {
	
	/**
	 * instantiate
	 * */
	@Before
	public void init();
	/**
	 * Test open
	 * */
	@Test
	public void testOpen();
	/**
	 * Test action Performed
	 * */
	@Test
	public void testActionPerformed();
}
