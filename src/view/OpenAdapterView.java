package view;

import java.awt.event.ActionEvent;
/**
 * open adapter view extends open adapter 
 * */


public class OpenAdapterView extends OpenAdapter{
	OpenView openView;
	
	public OpenAdapterView(OpenView openView) {
		this.openView = openView;
	}

	@Override
	public void open() 
	{
		openView.doOpen();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		open();
	}

}
