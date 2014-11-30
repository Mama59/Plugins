package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import menu.MenuAdapterHelp;
import menu.MenuAdapterTool;
import model.Model;
import plugin.CurrentPlugins;
import plugin.listener.PluginListener;
import filter.ModelAdapterChange;
import filter.ModelModifier;
import filter.PluginEvent;

public class WindowsView extends JPanel implements PluginListener{
	private static final long serialVersionUID = 1L;

	private Map<String, JMenuItem> hashItemTool;

	private Map<String, JMenuItem> hashItemHelp;

	private static Model model;
	protected JMenuBar menuBar = new JMenuBar();
	protected JMenu file = new JMenu("File");
	protected JMenu tool = new JMenu("Tool");
	protected JMenu help = new JMenu("Help");
	protected JTextArea text;
	protected CurrentPlugins currentPlugins;
	protected MenuAdapterHelp controleurHelp;
	protected MenuAdapterTool controleurTool;
	protected ModelModifier modelModifier;
	protected ModelAdapterChange mac;
	//protected JMenuItem save = new JMenuItem("Sauvegarde    ",
	//		new ImageIcon("src/Image/sauvegarde.png"));
	public WindowsView(Model model, CurrentPlugins currentPlugins) {
		WindowsView.model = model;
		this.currentPlugins = currentPlugins;
		
		init();
	}

	public CurrentPlugins getCurrentPlugins() {
		return currentPlugins;
	}

	public ModelModifier getModelModifier() {
		return modelModifier;
	}

	private void init() {
		// TODO Auto-generated method stub
		hashItemTool = new HashMap<String, JMenuItem>();
		hashItemHelp = new HashMap<String, JMenuItem>();
		modelModifier = new ModelModifier();
		controleurTool = new MenuAdapterTool(this);
		controleurHelp = new MenuAdapterHelp(currentPlugins);
		mac = new ModelAdapterChange(this);
		modelModifier.addModelFinderListener(mac);
		setPreferredSize(new Dimension(800, 800));
		text = new JTextArea(this.getHeight(), this.getWidth());
		setLayout(new BorderLayout());
		menuBar.add(file);
		menuBar.add(tool);
		menuBar.add(help);
		
		this.setVisible(true);
		modelModifier.changeModel("test");
		
		this.setBackground(Color.white);
		this.setLayout(new BorderLayout());
		add(menuBar,"North");
		add(text,"Center");
	}

	@Override
	public void pluginAdded(PluginEvent event) 
	{
		// TODO Auto-generated method stub

		JMenuItem plugHelp = new JMenuItem(event.getName());
		JMenuItem plugTool = new JMenuItem(event.getName());
		
		plugHelp.addActionListener(controleurHelp);
		plugTool.addActionListener(controleurTool);
		hashItemTool.put(event.getName(), plugTool);
		hashItemHelp.put(event.getName(), plugHelp);
		help.add(plugHelp);
		tool.add(plugTool);
	}

	@Override
	public void pluginRemoved(PluginEvent event) 
	{
		// TODO Auto-generated method stub
		String name = event.getName();
		tool.remove(hashItemTool.get(name));
		hashItemTool.remove(name);
		help.remove(hashItemHelp.get(name));
		hashItemHelp.remove(name);
		currentPlugins.removePlugin(name);
	}
	public String getModelText()
	{
		model.setMyString(text.getText());
		return model.getMyString();
	}
	public void changeModel(String s)
	{
		getModelModifier().changeModel(s);
	}
	public void setText(String s) 
	{
		model.setMyString(s);
		text.setText(s);
	}
	
}
