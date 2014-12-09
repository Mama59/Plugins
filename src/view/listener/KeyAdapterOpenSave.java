package view.listener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

import open.OpenView;
import save.SaveView;
/**
 * Key listener adapter to open save
 * ctrl + s to save
 * ctrl + o to open
 * */
public class KeyAdapterOpenSave extends KeyAdapter{
	private OpenView openView;
	private SaveView saveView;
	protected File selectedFile;
	private boolean ctrl;
	public KeyAdapterOpenSave(OpenView openView, SaveView saveView) 
	{
		this.openView = openView;
		this.saveView = saveView;
		this.ctrl = false;
	}

	/**
	 * Check if ctrl is released
	 * */
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == 157) {
			ctrl = false;
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == 157) {
			ctrl = true;
		}
		if (ctrl) {
			switch (e.getKeyChar()) {
			case 's':
				selectedFile = saveView.doSave(selectedFile);
				ctrl = false;
				break;
			case 'S':
				selectedFile = saveView.doSaveChange();
				ctrl = false;
				break;
			case 'o':
				selectedFile = openView.doOpen();
				ctrl = false;
				break;
			case 'O':
				selectedFile = openView.doOpen();
				ctrl = false;
				break;
			}
			
		}
	}
}