package Test.filter;

import static org.junit.Assert.*;
import model.Model;

import org.junit.*;

import filter.ModelAdapterChange;
import filter.ModelModifier;
import plugin.CurrentPlugins;
import view.WindowsView;

public class TestModelModifier {
	ModelModifier modelModif;
	WindowsView view;
	Model model;
	CurrentPlugins currentPlugins;
	@Before
	public void init()
	{
		modelModif = new ModelModifier();
		model = new Model();
		currentPlugins = new CurrentPlugins();
		view = new WindowsView(model, currentPlugins);
	}
	@Test
	public void testAdd()
	{
		ModelAdapterChange mac = new ModelAdapterChange(view);
		int sizeBefore = modelModif.getModelListeners().size();
		modelModif.addModelFinderListener(mac);
		assertTrue(modelModif.getModelListeners().size() == sizeBefore +1);
	}
	@Test
	public void testAddToo()
	{
		ModelAdapterChange mac = new ModelAdapterChange(view);
		
		modelModif.addModelFinderListener(mac);
		int sizeBefore = modelModif.getModelListeners().size();
		modelModif.addModelFinderListener(mac);
		assertTrue(modelModif.getModelListeners().size() == sizeBefore);
	}
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
