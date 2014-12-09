package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import open.OpenAdapterView;
import open.OpenView;
import menu.MenuAdapterHelp;
import menu.MenuAdapterTool;
import model.KeyModelAdapter;
import model.Model;
import model.ModelAdapterChange;
import model.ModelModifier;
import plugin.CurrentPlugins;
import plugin.PluginEvent;
import plugin.listener.PluginListener;
import quit.ExitMyAdapter;
import save.SaveAdapterView;
import save.SaveView;
import view.listener.KeyAdapterOpenSave;

/**
 * class WindowsView
 *
 */
public class WindowsView extends JPanel implements PluginListener{
	private static final long serialVersionUID = 1L;

	private Map<String, JMenuItem> hashItemTool;

	protected Map<String, JMenuItem> hashItemHelp;
	
	protected static Model model;
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
	protected OpenAdapterView openListener;
	protected SaveAdapterView saveListener;
	protected OpenView openView;
	protected SaveView saveView;
	protected KeyModelAdapter keyListener;
	protected ExitMyAdapter exitListener;
	protected KeyAdapterOpenSave textAreaListener;
	protected JFrame frame;
	protected KeyAdapterOpenSave listenerOpenSave;
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
		saveView = new SaveView(model);
		openListener = new OpenAdapterView(openView);
		saveListener = new SaveAdapterView(saveView);
		
		mac = new ModelAdapterChange(this);
		modelModifier.addModelFinderListener(mac);
		
		setPreferredSize(new Dimension(800, 800));
		
		text = new JTextArea(this.getHeight(), this.getWidth());
		textAreaListener = new KeyAdapterOpenSave(openView, saveView);
		keyListener = new KeyModelAdapter(model, text);

		text.addKeyListener(keyListener);
		text.addKeyListener(textAreaListener);
		
		JMenuItem openItem =  new JMenuItem("Open");
		JMenuItem saveItem =  new JMenuItem("Save");
		
		saveItem.addActionListener(saveListener);
		openItem.addActionListener(openListener);
		
		file.add(openItem);
		file.add(saveItem);
		
		menuBar.add(file);
		menuBar.add(tool);
		menuBar.add(help);
		
		setLayout(new BorderLayout());
		this.setBackground(Color.white);
		this.setLayout(new BorderLayout());
		add(menuBar,"North");
		add(text,"Center");
		this.setVisible(true);
		listenerOpenSave = new KeyAdapterOpenSave(openView, saveView);
		this.addKeyListener(listenerOpenSave);
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
	/**
	 * Set Frame
	 * */
	public void setFrame(JFrame frame) {
		this.frame = frame;
		JMenuItem exitItem = new JMenuItem("Exit");
		exitListener = new ExitMyAdapter(frame);
		exitItem.addActionListener(exitListener);
		file.add(exitItem);
	}
}
