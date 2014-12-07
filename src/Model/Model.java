package model;

/**
 * class Model
 * Contains the String 
 *
 */
public class Model {

	private String myString;
	
	
	/**
	 * Constructor
	 */
	public Model() 
	{
		myString = ""; 
	}
	
	/**
	 * Get the text
	 * @return text of the editor 
	 */
	public String getMyString() {
		return myString;
	}
	
	/**
	 * set the text
	 * @param myString
	 */
	public void setMyString(String myString) 
	{
		this.myString = myString;
	}
}
