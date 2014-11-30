package filter;

import java.util.ArrayList;
import java.util.List;


public class ModelModifier {
	private List<ModelListener> modelListeners = new ArrayList<ModelListener>();
	
	public ModelModifier() {
		this.modelListeners = new ArrayList<ModelListener>();
	}

	public synchronized void addModelFinderListener(ModelListener l) {
		if (modelListeners.contains(l)) { return ; }
		modelListeners.add(l);
	}
	
	public synchronized void removeModelListener(ModelListener l){
		modelListeners.remove(l);
	}
	private void fireModelChange(String s)
	{
		for(ModelListener ls : modelListeners)
		{
			ls.changeModel(s);
		}
	}
	public void changeModel(String s)
	{
		fireModelChange(s);
	}

	public List<ModelListener> getModelListeners() {
		return modelListeners;
	}
	
}
