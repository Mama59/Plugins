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
		mapPlugins = newMap;
	}
}
