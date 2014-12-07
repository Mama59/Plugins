package Test.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Model;
/**
 * Test for model
 * */
public class TestModel {
	private Model model;
	/**
	 * instantiate the model
	 * */
	@Before
	public void init()
	{
		model = new Model();
	}
	/**
	 * test of getString
	 * */
	@Test
	public void testGetString()
	{
		assertEquals(model.getMyString(), "");
	}
	/**
	 * test of setString
	 * */
	@Test
	public void testSetString()
	{
		String test = "essai";
		model.setMyString(test);
		assertEquals(model.getMyString(), test);
	}
}
