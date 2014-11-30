package view;

import java.util.EventObject;

public class StringEvent extends EventObject
{
	private String text;
	public StringEvent(Object source, String text) 
	{
		super(source);
		this.text = text;
		// TODO Auto-generated constructor stub
	}
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String getText() {
	return text;
}
	public void setText(String text) 
	{
		this.text = text;
	}
	@Override
	public String toString() {
		return "StringEvent [text=" + text + "]";
	}
	
}
