package menu;

import java.awt.event.ActionEvent;

import plugin.Plugin;
import view.WindowsView;

/**
 * Class MenuAdapterTool extends MenuAdapter
 * change the model text with pluginsSelected.transform
 *
 */
public class MenuAdapterTool extends MenuAdapter {
	private WindowsView view;
	public MenuAdapterTool(WindowsView view) {
		this.view = view;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		super.actionPerformed(e);
		Plugin p = view.getCurrentPlugins().getPlugin(e.getActionCommand());
		String modif = p.transform(view.getModelText());
		view.changeModel(modif);
	}
}
