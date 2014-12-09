package model;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextArea;

/**
 * My adapter for key action to change model
 * */
public class KeyModelAdapter extends KeyAdapter{
	protected Model model;
	protected JTextArea textArea;
	public KeyModelAdapter(Model model, JTextArea text) {
		this.model = model;
		textArea = text;
		// TODO Auto-generated constructor stub
	}
	/**
	 * update model with textArea text
	 * */
	public void update()
	{
		model.setMyString(textArea.getText());
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		update();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		update();
	}

}
