package Test.view;


import static org.junit.Assert.*;

import java.io.File;

import model.Model;

import org.junit.Before;
import org.junit.Test;

import plugin.CurrentPlugins;
import plugin.PluginEvent;
import plugin.listener.PluginFinder;
import view.WindowsView;

/**
 *  Test Windows View (only not vuew functions)
 * */
public class TestWindowsView {

	WindowsView view;
	Model model;
	CurrentPlugins currentPlugins;
	PluginFinder finder;
	/**
	 * instantiate finder
	 * */
	@Before
	public void init()
	{
		model = new Model();
		currentPlugins = new CurrentPlugins();
		view = new WindowsView(model, currentPlugins);
		File file = new File("dropinsTest/plugins");
		finder = new PluginFinder(file);
	}
	/**
	 * Test added plugin
	 * */
	@Test
	public void testPluginAdded()
	{
		PluginEvent event = new PluginEvent(finder, finder.getPlugin("Rot13.class"));
		int before = view.getCurrentPlugins().getPlugins().size();
		view.pluginAdded(event);
		assertEquals(before + 1, view.getCurrentPlugins().getPlugins().size());
	}
	/**
	 * Test removed plugin
	 * */
	@Test
	public void testPluginRemoved()
	{
		PluginEvent event = new PluginEvent(finder, finder.getPlugin("Rot13.class"));
		int before = view.getCurrentPlugins().getPlugins().size();
		view.pluginAdded(event);
		view.pluginRemoved(event);
		assertEquals(before, view.getCurrentPlugins().getPlugins().size());
	}
}
