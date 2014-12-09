package save;

import java.awt.event.ActionEvent;
import java.io.File;

import open.OpenView;

public class OpenSaveMyAdapter extends OpenSaveAdapter {
	private SaveView saveView;
	private OpenView openView;
	protected File selectedFile;
	
	public OpenSaveMyAdapter(SaveView saveView, OpenView openView) {
		this.saveView = saveView;
		this.openView = openView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand() == "Save")
		{
			save();
		}
		else if(e.getActionCommand() == "Open")
		{
			open();
		}
	}

	@Override
	public void save() 
	{
		selectedFile = saveView.doSave(selectedFile);
	}

	@Override
	public void open() 
	{
		selectedFile = openView.doOpen();
	}
}
