package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import file.PluginEvent;
import file.PluginListener;
import plugin.Plugin;
import Model.CurrentPlugins;
import Model.Model;

public class WindowsView extends JPanel implements PluginListener{
	private static final long serialVersionUID = 1L;

	private static Model model;
	protected JMenuBar menuBar = new JMenuBar();
	protected JMenu file = new JMenu("File");
	protected JMenu tool = new JMenu("Tool");
	protected JMenu help = new JMenu("Help");
	protected JTextArea text;
	protected CurrentPlugins currentPlugins;
	protected Map<String, JMenuItem> hashItem;
	//protected JMenuItem save = new JMenuItem("Sauvegarde    ",
	//		new ImageIcon("src/Image/sauvegarde.png"));
	public WindowsView(Model model, CurrentPlugins currentPlugins) {
		this.model = model;
		this.currentPlugins = currentPlugins;
		hashItem = new HashMap<String, JMenuItem>();
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		setPreferredSize(new Dimension(800, 800));
		text = new JTextArea(this.getHeight(), this.getWidth());
		setLayout(new BorderLayout());
		menuBar.add(file);
		menuBar.add(tool);
		menuBar.add(help);
		this.setVisible(true);
		text.setText("test");
		
		this.setBackground(Color.white);
		this.setLayout(new BorderLayout());
		add(menuBar,"North");
		add(text,"Center");
	}


	public static Model getModel() 
	{
		return model;
	}

	public static void setModel(Model model) 
	{
		WindowsView.model = model;
	}

	@Override
	public void pluginAdded(PluginEvent event) {
		// TODO Auto-generated method stub
		System.out.println("add");
		System.out.println(currentPlugins);
		System.out.println(event.getName());
		hashItem.put(event.getName(), new JMenuItem(event.getName()));
		tool.add(hashItem.get(event.getName()));
		help.add(hashItem.get(event.getName()));
		System.out.println(help.getMenuComponent(0).getName());
	}

	@Override
	public void pluginRemoved(PluginEvent event) {
		// TODO Auto-generated method stub
		System.out.println("remove");
		System.out.println(event.getName());
		if(hashItem.get(event.getName()) != null)
		{
			tool.remove(hashItem.get(event.getName()));
			help.remove(hashItem.get(event.getName()));
			hashItem.remove(event.getName());
		}
		
	}
}
