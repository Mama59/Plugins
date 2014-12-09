package save;

import java.awt.event.ActionEvent;
/**
 * open adapter view extends open adapter 
 * */


public class SaveAdapterView extends SaveAdapter{
	SaveView saveView;
	
	public SaveAdapterView(SaveView saveView) {
		this.saveView = saveView;
	}

	@Override
	public void save() 
	{
		saveView.doSave();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("save");
		save();
	}

}
