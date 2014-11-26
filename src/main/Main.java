package main;
import javax.swing.JFrame;
import javax.swing.Timer;

import Model.Model;
import View.WindowsView;
import timer.TimerListing;


public class Main {
	private static final int FREC = 1000 ;
	public static void main(String[] args) {
		Model model = new Model();
		JFrame f = new JFrame("Plugins For Text");
		WindowsView wv = new WindowsView();
	
	 	f.getContentPane().add(wv);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.pack();
		new Timer(FREC , new TimerListing(model)).start();
		while(true);
	}
}
