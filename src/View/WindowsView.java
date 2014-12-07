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
import model.ModelAdapterChange;
import model.ModelModifier;
import plugin.CurrentPlugins;
import plugin.PluginEvent;
import plugin.listener.PluginListener;

/**
 * class WindowsView
 *
 */
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
	protected OpenModifier openModifier;
	protected OpenAdapterView openListener;
	protected OpenView openView;
	//protected JMenuItem save = new JMenuItem("Sauvegarde    ",
	//		new ImageIcon("src/Image/sauvegarde.png"));
	
	/**
	 * Constructor of the window
	 * @param model
	 * @param currentPlugins
	 */
	public WindowsView(Model model, CurrentPlugins currentPlugins) {
		WindowsView.model = model;
		this.currentPlugins = currentPlugins;
		
		init();
	}

	
	/**
	 * get the current plugin
	 * @return CurrentPlugins
	 */
	public CurrentPlugins getCurrentPlugins() {
		return currentPlugins;
	}

	
	/**
	 * get the model modifier
	 * @return ModelModifier
	 */
	public ModelModifier getModelModifier() {
		return modelModifier;
	}

	
	/**
	 * Init the view
	 */
	private void init() {
		// TODO Auto-generated method stub
		
		hashItemTool = new HashMap<String, JMenuItem>();
		hashItemHelp = new HashMap<String, JMenuItem>();
		modelModifier = new ModelModifier();
		controleurTool = new MenuAdapterTool(this);
		controleurHelp = new MenuAdapterHelp(currentPlugins);
		openView = new OpenView(model, modelModifier);
		openListener = new OpenAdapterView(openView);
		mac = new ModelAdapterChange(this);
		modelModifier.addModelFinderListener(mac);
		
		setPreferredSize(new Dimension(800, 800));
		text = new JTextArea(this.getHeight(), this.getWidth());
		setLayout(new BorderLayout());
		JMenuItem openItem =  new JMenuItem("Open");
		openItem.addActionListener(openListener);
		file.add(openItem);
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
	/**
	 * added a plugin 
	 * */
	
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
		currentPlugins.addPlugin(event.getName(), event.getPlugin());
	}
	/**
	 * removed a plugin 
	 * */
	
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
	
	/**
	 * get the content of the text
	 * @return the content of the text
	 */
	public String getModelText()
	{
		model.setMyString(text.getText());
		return model.getMyString();
	}
	
	/**
	 * change the model
	 * @param s
	 */
	public void changeModel(String s)
	{
		getModelModifier().changeModel(s);
	}
	
	/**
	 * set the text with the text in param 
	 * @param s
	 */
	public void setText(String s) 
	{
		model.setMyString(s);
		text.setText(s);
	}
	/**
	 * 
	 * open view to choose a file
	 * 
	 * */
	public void openFiles() 
	{
		openView.doOpen();
	}

}
