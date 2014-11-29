package main;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.Timer;

import file.MyPluginAdapter;
import file.PluginFinder;
import Model.CurrentPlugins;
import Model.Model;
import View.WindowsView;
import timer.TimerListing;


public class Main {
	private static final int FREC = 1000 ;

	private static PluginFinder finder;
	public static void main(String[] args) 
	{
		String directoryPlugins = "dropins/plugins";
		File file = new File(directoryPlugins);
		Model model = new Model();
		CurrentPlugins currentPlugins = new CurrentPlugins();
		MyPluginAdapter pluginAdapter = new MyPluginAdapter(currentPlugins);
		
		WindowsView wv = new WindowsView(model, currentPlugins);
		JFrame f = new JFrame("Plugins For Text");
		f.getContentPane().add(wv);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.pack();
		finder = new PluginFinder(file);
		finder.addPluginFinderListener(pluginAdapter);
		finder.addPluginFinderListener(wv);
		new Timer(FREC , new TimerListing(finder)).start();
	}
}
