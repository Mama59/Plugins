package filter;

import view.WindowsView;

public class ModelAdapterChange extends ModelAdapter{
	WindowsView wv;
	
	public ModelAdapterChange(WindowsView wv) {
		this.wv = wv;
	}

	public void changeModel(String s) 
	{
		wv.setText(s);
	}
}
