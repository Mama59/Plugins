package plugin.listener ;

import java.util.EventListener;

import plugin.PluginEvent;
/**
 * 
 * Interface for plugins Listenet  extends EventListener
 * 
 * */
public interface PluginListener extends EventListener {
	/**
	 * added a plugin event
	 * */
	public void pluginAdded(PluginEvent event);
	/**
	 * removed a plugin event 
	 * */
	public void pluginRemoved(PluginEvent event);

}
