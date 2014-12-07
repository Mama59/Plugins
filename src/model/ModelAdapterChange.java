package model;

import view.WindowsView;

/**
 * model adapter to change model extends ModelAdapter
 *
 */
public class ModelAdapterChange extends ModelAdapter{
	WindowsView wv;
	
	
	/**
	 * constructor
	 * @param wv
	 */
	public ModelAdapterChange(WindowsView wv) {
		this.wv = wv;
	}

	/**
	 * change the text in the model
	 */
	public void changeModel(String s) 
	{
		wv.setText(s);
	}
}
