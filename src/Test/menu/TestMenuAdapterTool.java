package Test.menu;


import static org.junit.Assert.*;

import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.JMenuItem;

import menu.MenuAdapterTool;
import model.Model;

import org.junit.Before;
import org.junit.Test;

import filter.PluginEvent;
import filter.PluginFinder;
import plugin.CurrentPlugins;
import plugin.Plugin;
import view.WindowsView;

public class TestMenuAdapterTool extends TestMenuAdapter{
	WindowsView view;
	Model model;
	CurrentPlugins currentPlugins;
	String test ;
	PluginFinder src;
	Plugin p;
	PluginEvent pEvent;
	ActionEvent action;
	JMenuItem source;
	int id;
	
	@Before
	public void init()
	{
		source = new JMenuItem();
		id = 2000;
		model = new Model();
		currentPlugins = new CurrentPlugins();
		view = new WindowsView(model, currentPlugins);
		adapter = new MenuAdapterTool(view);
		test = "TEST";
		src = new PluginFinder(new File("dropinsTest/plugins"));
		p = src.getPlugin("ToLowerCase.class");
		currentPlugins.addPlugin(p.getLabel(), p);
		pEvent = new PluginEvent(src, p);
		view.pluginAdded(pEvent);
		view.changeModel(test);
		action = new ActionEvent(source, id, p.getLabel());
	}
	@Test
	public void testActionChangeText()
	{
		adapter.actionPerformed(action);
		assertNotEquals(test, view.getModelText());
	}
	@Test
	public void testActionChange()
	{
		adapter.actionPerformed(action);
		assertEquals(test.toLowerCase(), view.getModelText());
	}
}
