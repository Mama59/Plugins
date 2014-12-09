package view.listener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
	private boolean ctrl;
	public KeyAdapterOpenSave(OpenView openView, SaveView saveView) 
	{
		this.openView = openView;
		this.saveView = saveView;
		this.ctrl = false;
	}

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
				saveView.doSave();
				break;
			case 'S':
				saveView.doSave();
				break;
			case 'o':
				openView.doOpen();
				break;
			case 'O':
				openView.doOpen();
				break;
			}
		}
	}
}