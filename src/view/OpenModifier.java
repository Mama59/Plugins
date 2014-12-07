package view;

import java.util.ArrayList;
import java.util.List;

/**
 * open modifier, list of openlisteners and call them when action performed
 * */

public class OpenModifier {
	private List<OpenListener> openListeners ;

	public OpenModifier() {
		this.openListeners = new ArrayList<OpenListener>();
	}
	public OpenModifier(List<OpenListener> openListeners) {
		this.openListeners = openListeners;
	}
	public void addListener(OpenListener listener)
	{
		if(! openListeners.contains(listener))
			openListeners.add(listener);
	}
	public void removeListener(OpenListener listener)
	{
		if(openListeners.contains(listener))
			openListeners.remove(listener);
	}
	private void fireOpen()
	{
		for(OpenListener ls : openListeners)
		{
			ls.open();
		}
	}
	public void opened()
	{
		fireOpen();
	}
	public List<OpenListener> getOpenListeners() {
		return openListeners;
	}
	
}
