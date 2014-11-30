package menu;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import plugin.CurrentPlugins;
import plugin.Plugin;

public class MenuAdapterHelp extends MenuAdapter {
	private CurrentPlugins plugins;
	public MenuAdapterHelp(CurrentPlugins plugins) {
		this.plugins = plugins;
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		super.actionPerformed(e);
		String name = e.getActionCommand();
		Plugin p = plugins.getPlugin(name);
		System.out.println(p);
		if(p != null)
		{
			JOptionPane.showMessageDialog(null,p.helpMessage());
		}
	}
}
