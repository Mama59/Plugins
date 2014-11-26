package Model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Observable;

import plugin.Plugin;

public class Model extends Observable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String myString;
	private HashMap<String, Plugin> mapPlugins;
	public Model() 
	{
		mapPlugins = new HashMap<String, Plugin>();
		myString = ""; 
	}
	public String getMyString() {
		return myString;
	}
	public void setMyString(String myString) 
	{
		this.myString = myString;
	}
	public HashMap<String, Plugin> getMapPlugins() 
	{
		return mapPlugins;
	}
	
	public void majMap(HashMap<String, Plugin> newMap)
	{
		System.out.println("maj");
		System.out.println("notify");
		for(String pl : newMap.keySet())
		{
			if(!mapPlugins.containsKey(pl))
			{
				HashMap<Boolean, Plugin> rep = new HashMap<>();
				rep.put(true, newMap.get(pl));
 				notifyObservers(rep);
			}
		}
		for(String pl : mapPlugins.keySet())
		{
			if(!newMap.containsKey(pl))
			{
				HashMap<Boolean, Plugin> rep = new HashMap<>();
				rep.put(false, mapPlugins.get(pl));
 				notifyObservers(rep);
			}
		}
		mapPlugins = newMap;
		
	}
}
