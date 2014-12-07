package Test.model;

import org.junit.Test;
/**
 * interface Test for model listener
 * */
public interface TestModelListener {
	/**
	 * Test if model as change
	 * */
	@Test
	public void modelAsChange();
	/**
	 * Test if model no change
	 * */
	@Test
	public void modelNoChange();
}
