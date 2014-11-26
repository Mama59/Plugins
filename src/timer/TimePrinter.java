package timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class TimePrinter implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent event) {
		System.out.println(Calendar.getInstance().getTime()) ;
	}

}
