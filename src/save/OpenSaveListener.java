package save;

import java.awt.event.ActionListener;
/**
 * interface of OpenSavelistener extends actionlistener 
 * */

public interface OpenSaveListener extends ActionListener {
	/**
	 * do save 
	 * */
	public void save();
	
	/**
	 * do open 
	 * */
	public void open();
}
