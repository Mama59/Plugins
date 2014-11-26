package timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.Set;

import javax.swing.JOptionPane;

import plugin.Plugin;
import file.*;
import Model.Model;

public class TimerListing implements ActionListener {
	
	private HashMap<String, Plugin> listClass = new HashMap<String, Plugin>();
	private String directoryPlugins = "dropins/plugins";
	private File file = new File(directoryPlugins);
	private PluginFinder finder = new PluginFinder(file);
	private Model model;
	
	public TimerListing(Model model) {
		this.model = model;
		listClass = new HashMap<String, Plugin>();
		directoryPlugins = "dropins/plugins";
		file = new File(directoryPlugins);
		finder = new PluginFinder(file);
	}

	public void actionPerformed(ActionEvent event) 
	{
		Set<String> listClassActual = finder.getContentClass();		
		System.out.println(listClassActual);
		HashMap<String, Plugin> after = new HashMap<String, Plugin>();
		for(String st : listClassActual)
		{
			if(! listClass.containsKey(st))
			{
				Plugin p;
				Set<String> listPlugin = finder.getContentPlugin();
				for(String plug : listPlugin)
				{
					p = finder.getPlugin(plug);
					if(p != null)
					{
						after.put(plug, p);
					}
					else
					{
						JOptionPane.showMessageDialog(null, this,
								"Desole, plug n'est pas un plugin correct :\n", 0);
					}
				}
			}
			else
				after.put(st, listClass.get(st));
		}
		model.majMap(after);
		listClass = after;
	}
}
