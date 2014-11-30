package main;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.Timer;

import model.Model;
import plugin.CurrentPlugins;
import plugin.listener.MyPluginAdapter;
import filter.PluginFinder;
import timer.TimerListingListener;
import view.WindowsView;


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
		new Timer(FREC , new TimerListingListener(finder)).start();
		JFrame f = new JFrame("Plugins For Text");
		f.getContentPane().add(wv);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.pack();
	}
}
