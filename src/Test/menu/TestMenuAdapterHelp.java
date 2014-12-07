package Test.menu;

import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.JMenuItem;

import org.junit.Before;
import org.junit.Test;

import plugin.CurrentPlugins;
import plugin.Plugin;
import plugin.listener.PluginFinder;
import menu.MenuAdapterHelp;
/**
 * Test for MenuAdapterHelp, extends TestMenuAdapter
 * */
public class TestMenuAdapterHelp extends TestMenuAdapter{
	private MenuAdapterHelp adapter;
	private CurrentPlugins currentPlugins;
	private ActionEvent action;
	private JMenuItem source;
	private int id;
	private Plugin p;
	PluginFinder src;
	@Override
	@Before
	public void init()
	{
		source = new JMenuItem();
		id = 2000;
		currentPlugins = new CurrentPlugins();
		adapter = new MenuAdapterHelp(currentPlugins);
	 	src = new PluginFinder(new File("dropinsTest/plugins"));
	}
	@Override
	@Test
	public void testOk()
	{
		
		p = src.getPlugin("ToLowerCase.class");
		currentPlugins.addPlugin(p.getLabel(), p);
		action = new ActionEvent(source, id, p.getLabel());
		adapter.actionPerformed(action);
	}
	@Override
	@Test
	public void testNotOk()
	{
		action = new ActionEvent(source, id, "test.class");
		adapter.actionPerformed(action);
	}
}
