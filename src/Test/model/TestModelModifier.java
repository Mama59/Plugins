package Test.model;

import static org.junit.Assert.*;
import model.Model;
import model.ModelAdapterChange;
import model.ModelModifier;

import org.junit.*;

import plugin.CurrentPlugins;
import view.WindowsView;
/**
 * Test for model modifier
 * */
public class TestModelModifier {
	ModelModifier modelModif;
	WindowsView view;
	Model model;
	CurrentPlugins currentPlugins;
	/**
	 * 
	 * */
	@Before
	public void init()
	{
		modelModif = new ModelModifier();
		model = new Model();
		currentPlugins = new CurrentPlugins();
		view = new WindowsView(model, currentPlugins);
	}
	/**
	 * Test add listener
	 * */
	@Test
	public void testAdd()
	{
		ModelAdapterChange mac = new ModelAdapterChange(view);
		int sizeBefore = modelModif.getModelListeners().size();
		modelModif.addModelFinderListener(mac);
		assertTrue(modelModif.getModelListeners().size() == sizeBefore +1);
	}
	/**
	 * test add listener
	 * */
	@Test
	public void testAddAlreadyInside()
	{
		ModelAdapterChange mac = new ModelAdapterChange(view);
		modelModif.addModelFinderListener(mac);
		int sizeBefore = modelModif.getModelListeners().size();
		modelModif.addModelFinderListener(mac);
		assertTrue(modelModif.getModelListeners().size() == sizeBefore);
	}
	/**
	 * test remove listener
	 * */
	@Test
	public void testRemove()
	{
		ModelAdapterChange mac = new ModelAdapterChange(view);
		modelModif.addModelFinderListener(mac);
		int sizeBefore = modelModif.getModelListeners().size();
		modelModif.removeModelListener(mac);
		assertTrue(modelModif.getModelListeners().size() == sizeBefore -1);
	}
}
