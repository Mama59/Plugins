package Test.menu;

import org.junit.Before;
import org.junit.Test;

import menu.MenuAdapter;
/**
 * Test for MenuAdapter implement TestMenuListener
 * */
public class TestMenuAdapter implements TestMenuListener {
	protected MenuAdapter adapter;
	/**
	 * init instantiate the menuAdapter
	 * */
	@Before
	public void init()
	{
		adapter = new MenuAdapter();
	}
	@Override
	@Test
	public void testOk() {
		// TODO Auto-generated method stub
		
	}
	@Override
	@Test
	public void testNotOk() {
		// TODO Auto-generated method stub
		
	}
	@Override
	@Test
	public void testActionChangeText() {
		// TODO Auto-generated method stub
		
	}
	@Test
	@Override
	public void testActionChange() {
		// TODO Auto-generated method stub
		
	}
	
}
