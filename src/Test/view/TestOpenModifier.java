package Test.view;

import static org.junit.Assert.*;

import model.Model;
import model.ModelModifier;

import org.junit.Before;
import org.junit.Test;

import view.OpenAdapterView;
import view.OpenModifier;
import view.OpenView;

/**
 * Test of open Modifier
 * */
public class TestOpenModifier {
	private OpenModifier modifier;
	private Model mod;
	private ModelModifier modelModif;
	private OpenView openView;
	@Before
	public void init()
	{
		mod = new Model();
		modelModif  = new ModelModifier();
		openView = new OpenView(mod, modelModif);
		modifier = new OpenModifier();
	}
	@Test
	public void testAddListener()
	{
		OpenAdapterView l1 = new OpenAdapterView(openView);
		modifier.addListener(l1);
		assertTrue(modifier.getOpenListeners().size() == 1);
	}
	@Test
	public void testRemoveListener()
	{
		OpenAdapterView l1 = new OpenAdapterView(openView);
		modifier.addListener(l1);
		modifier.removeListener(l1);
		assertTrue(modifier.getOpenListeners().size() == 0);
	}
	
}
