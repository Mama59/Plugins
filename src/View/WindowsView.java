package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Model.Model;

public class WindowsView extends JPanel implements Observer {
	private static final long serialVersionUID = 1L;

	private static Model model;

	protected JMenuBar menuBar = new JMenuBar();
	protected JMenu file = new JMenu("File");
	protected JMenu tool = new JMenu("Tool");
	protected JMenu help = new JMenu("Help");
	protected Set<JMenuItem> fileItem;
	protected Set<JMenuItem> toolItem;
	protected Set<JMenuItem> helpItem;
	protected JTextArea text;
	//protected JMenuItem save = new JMenuItem("Sauvegarde        ���S",
	//		new ImageIcon("src/Image/sauvegarde.png"));
	public WindowsView() {
		model = new Model();
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		fileItem = new HashSet<JMenuItem>();
		toolItem = new HashSet<JMenuItem>();
		helpItem = new HashSet<JMenuItem>();
		
		setPreferredSize(new Dimension(800, 800));
		text = new JTextArea(this.getHeight(), this.getWidth());
		setLayout(new BorderLayout());
		menuBar.add(file);
		menuBar.add(tool);
		menuBar.add(help);
		for(JMenuItem jmi : fileItem)
		{
			file.add(jmi);
		}
		for(JMenuItem jmi : toolItem)
		{
			tool.add(jmi);
		}
		for(JMenuItem jmi : helpItem)
		{
			help.add(jmi);
		}
		
		model.addObserver(this);
		this.setVisible(true);
		text.setText("test");
		
		this.setBackground(Color.white);
		this.setLayout(new BorderLayout());
		add(menuBar,"North");
		add(text,"Center");
	}


	public static Model getModel() {
		return model;
	}

	
	public static void setModel(Model model) {
		WindowsView.model = model;
	}

	@Override
	public void update(Observable obs, Object arg) {
		model = (Model) obs;
		repaint();
		System.out.println(model);
	}

}
