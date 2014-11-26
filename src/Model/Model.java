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
		System.out.println(newMap);
		for(String pl : newMap.keySet())
		{
				HashMap<Boolean, Plugin> rep = new HashMap<>();
				rep.put(true, newMap.get(pl));
				System.out.println("notify");
 				notifyObservers(rep);
		}
		for(String pl : mapPlugins.keySet())
		{
				HashMap<Boolean, Plugin> rep = new HashMap<>();
				rep.put(false, mapPlugins.get(pl));
				System.out.println("notify");
 				notifyObservers(rep);
		}
		mapPlugins = newMap;
		
	}
}
