package save;

import java.awt.event.ActionEvent;
import java.io.File;

import open.OpenView;
/**
 * Open save my adapter
 * have a saveView
 * and an openView
 * and a File to know the ending selectedFile
 * */
public class OpenSaveMyAdapter extends OpenSaveAdapter {
	private SaveView saveView;
	private OpenView openView;
	protected File selectedFile;
	
	public OpenSaveMyAdapter(SaveView saveView, OpenView openView) {
		this.saveView = saveView;
		this.openView = openView;
	}
	/**
	 * action save and open
	 * */
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
	/**
	 * save function call doSave of saveView
	 * */
	@Override
	public void save() 
	{
		selectedFile = saveView.doSave(selectedFile);
	}
	/**
	 * open function call doOpen of openView
	 * */
	@Override
	public void open() 
	{
		selectedFile = openView.doOpen();
	}
}
