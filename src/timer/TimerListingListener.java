package timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import plugin.Plugin;
import filter.*;

public class TimerListingListener implements ActionListener {
	
	private HashMap<String, Plugin> listClass = new HashMap<String, Plugin>();
	
	private PluginFinder finder;
	
	public TimerListingListener(PluginFinder finder) {
		listClass = new HashMap<String, Plugin>();
		this.finder = finder; 
	}

	public void actionPerformed(ActionEvent event) 
	{
		Set<String> listClassActual = finder.getContentClass();	
		Set<Plugin> newPlugins = new HashSet<Plugin>();
		Set<Plugin> oldPlugins = new HashSet<Plugin>();
		Set<String> old = new HashSet<String>();
		for(String st : listClassActual)
		{
			if(listClass.containsKey(st))
			{
				
			}
			else
			{
				Plugin p = finder.getPlugin(st);
				if(p != null)
				{
					newPlugins.add(p);
					listClass.put(st,p);
				}
				else
				{
					System.out.println("Desole, plug n'est pas un plugin correct :\n");
				}
			}
		}
		Set<String> keySetListClass = listClass.keySet();
		for(String st :  keySetListClass)
		{
			if(! listClassActual.contains(st))
			{
				oldPlugins.add(listClass.get(st));
				old.add(st);
			}
		}
		for(String s : old)
		{
			listClass.remove(s);
		}
		if(! newPlugins.isEmpty())
		{
			finder.addPlugin(newPlugins);
		}	
		if(! oldPlugins.isEmpty())
		{
			finder.removePlugin(oldPlugins);
		}
	}
}
