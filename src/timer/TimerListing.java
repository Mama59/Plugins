package timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import plugin.Plugin;
import file.*;

public class TimerListing implements ActionListener {
	
	private HashMap<String, Plugin> listClass = new HashMap<String, Plugin>();
	
	private PluginFinder finder;
	
	public TimerListing(PluginFinder finder) {
		listClass = new HashMap<String, Plugin>();
		this.finder = finder; 
	}

	public void actionPerformed(ActionEvent event) 
	{
		System.out.println("action Performed");
		Set<String> listClassActual = finder.getContentClass();		
		Map<String, Plugin> newPlugins = new HashMap<String, Plugin>();
		Map<String, Plugin> oldPlugins = new HashMap<String, Plugin>();
		for(String st : listClassActual)
		{
			if(! listClass.containsKey(st))
			{
				Plugin p = finder.getPlugin(st);
				if(p != null)
				{
					System.out.println("add " + st);
					newPlugins.put(st,p);
					listClass.put(st,p);
				}
				else
				{
					System.out.println("Desole, plug n'est pas un plugin correct :\n");
				}
			}
		}
		for(String st : listClass.keySet())
		{
			if(! listClassActual.contains(st))
			{
				System.out.println("remove " + st);
				oldPlugins.put(st, listClass.get(st));
			}
		}
		finder.addPlugin(newPlugins);
		finder.removePlugin(oldPlugins);
	}
}
