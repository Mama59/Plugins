package main;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.Timer;

import model.Model;
import plugin.CurrentPlugins;
import plugin.listener.MyPluginAdapter;
import plugin.listener.PluginFinder;
import timer.TimerListingMyAdapter;
import view.WindowsView;
/**
 * Main
 * Create all the necessary object to use our plugins software
 * */

public class Main {
	private static final int FREC = 1000 ;

	public static void main(String[] args) 
	{
		String directoryPlugins = "dropins/plugins";
		File file = new File(directoryPlugins);
		Model model = new Model();
		CurrentPlugins currentPlugins = new CurrentPlugins();
		MyPluginAdapter pluginAdapter = new MyPluginAdapter(currentPlugins);
		WindowsView wv = new WindowsView(model, currentPlugins);
		PluginFinder finder = new PluginFinder(file);
		finder.addPluginFinderListener(pluginAdapter);
		finder.addPluginFinderListener(wv);
		new Timer(FREC , new TimerListingMyAdapter(finder)).start();
		JFrame f = new JFrame("Plugins For Text");
		f.getContentPane().add(wv);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		wv.setFrame(f);
		f.setVisible(true);
		f.pack();
	}
}
