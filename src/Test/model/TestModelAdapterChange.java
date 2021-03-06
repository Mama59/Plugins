package Test.model;

import static org.junit.Assert.*;
import model.Model;
import model.ModelAdapterChange;

import org.junit.Before;
import org.junit.Test;

import plugin.CurrentPlugins;
import view.WindowsView;
/**
 * Test for model adapter change
 * */
public class TestModelAdapterChange extends TestModelAdapter {

	ModelAdapterChange modelAdapter;
	Model model ;
	CurrentPlugins currentPlugins;
	WindowsView wv;
	@Before
	public void init()
	{
		model = new Model();
		currentPlugins = new CurrentPlugins();
		wv = new WindowsView(model, currentPlugins);
		modelAdapter = new ModelAdapterChange(wv);
	}
	@Test
	public void modelAsChange() {
		modelAdapter.changeModel("test");
		assertEquals(wv.getModelText(), "test" );
	}
	@Test
	public void modelNoChange() {
		String before;
		before = wv.getModelText();
		modelAdapter.changeModel(wv.getModelText());
		assertEquals(before, wv.getModelText());
	}
}
