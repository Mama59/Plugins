package timer;

import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import plugin.Plugin;
import plugin.listener.PluginFinder;

/**
 * class TimerListingMyAdapter *
 */
public class TimerListingMyAdapter extends  TimerListingAdapter {
	
	private HashMap<String, Plugin> mapPlugins;	
	private PluginFinder finder;
	
	/**
	 * Constructor
	 * @param finder
	 */
	public TimerListingMyAdapter(PluginFinder finder) {
		mapPlugins = new HashMap<String, Plugin>();
		this.finder = finder; 
	}

	
	/**
	 * get list of classes 
	 * @return HashMap<String, Plugin>
	 */
	public HashMap<String, Plugin> getMapPlugin() {
		return mapPlugins;
	}

	/**
	 * get finder
	 * @return PluginFinder
	 */
	public PluginFinder getFinder() {
		return finder;
	}

	
	/**
	 * 
	 */
	public void actionPerformed(ActionEvent event) 
	{
		System.out.println(event);
		Set<String> listClassActual = finder.getContentClass();	
		Set<Plugin> newPlugins = new HashSet<Plugin>();
		Set<Plugin> oldPlugins = new HashSet<Plugin>();
		Set<String> old = new HashSet<String>();
		for(String st : listClassActual)
		{
			if(! mapPlugins.containsKey(st))
			{
				Plugin p = finder.getPlugin(st);
				if(p != null)
				{
					newPlugins.add(p);
					mapPlugins.put(st,p);
				}
				else
				{
					System.out.println("Desole, plug n'est pas un plugin correct :\n");
				}
			}
		}
		Set<String> keySetListClass = mapPlugins.keySet();
		for(String st :  keySetListClass)
		{
			if(! listClassActual.contains(st))
			{
				oldPlugins.add(mapPlugins.get(st));
				old.add(st);
			}
		}
		for(String s : old)
		{
			mapPlugins.remove(s);
		}
		if(! newPlugins.isEmpty())
		{
			finder.addPlugins(newPlugins);
		}	
		if(! oldPlugins.isEmpty())
		{
			finder.removePlugins(oldPlugins);
		}
	}
}
