package quit;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
/**
 * exit my adapter extends exit Adapter
 * have a JFrame to quit frame
 * */
public class ExitMyAdapter extends ExitAdapter{
	private JFrame frame;
	
	public ExitMyAdapter(JFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
	}
}
