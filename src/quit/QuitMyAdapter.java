package quit;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class QuitMyAdapter extends QuitAdapter{
	private JFrame frame;
	
	public QuitMyAdapter(JFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
	}
}
