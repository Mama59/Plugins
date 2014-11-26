package Model;

import java.io.Serializable;
import java.util.Observable;

public class Model extends Observable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String myString;
	
	public Model() 
	{
		myString = ""; 
	}
	public String getMyString() {
		return myString;
	}
	public void setMyString(String myString) 
	{
		this.myString = myString;
	}
}
