package model;

import java.util.ArrayList;
import java.util.List;

/**
 * model modifier list of model listeners
 *
 */

public class ModelModifier {
	private List<ModelListener> modelListeners = new ArrayList<ModelListener>();
	
	/**
	 * constructor
	 */
	public ModelModifier() {
		this.modelListeners = new ArrayList<ModelListener>();
	}

	/**
	 * add listener l
	 * @param l
	 */
	public synchronized void addModelFinderListener(ModelListener l) {
		if (modelListeners.contains(l)) { return ; }
		modelListeners.add(l);
	}
	
	/**
	 * remove the model listener
	 * @param l
	 */
	public synchronized void removeModelListener(ModelListener l){
		modelListeners.remove(l);
	}
	
	
	/**
	 * notify all the liteners
	 * @param s
	 */
	private void fireModelChange(String s)
	{
		for(ModelListener ls : modelListeners)
		{
			ls.changeModel(s);
		}
	}
	
	/**
	 * change the model
	 * @param s
	 */
	public void changeModel(String s)
	{
		fireModelChange(s);
	}

	
	/**
	 *  get the model listenners
	 * @return list of modelListener
	 */
	public List<ModelListener> getModelListeners() {
		return modelListeners;
	}
	
}
