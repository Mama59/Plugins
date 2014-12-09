package view;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import open.OpenView;
import save.SaveView;

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
				System.out.println("save");
				saveView.doSave();
				break;
			case 'S':
				System.out.println("save");
				saveView.doSave();
				break;
			case 'o':
				System.out.println("open");
				openView.doOpen();
				break;
			case 'O':
				System.out.println("open");
				openView.doOpen();
				break;
			}
		}
	}
}