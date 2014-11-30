package plugin.listener ;

import java.util.EventListener;

import filter.PluginEvent;

public interface PluginListener extends EventListener {

	public void pluginAdded(PluginEvent event);

	public void pluginRemoved(PluginEvent event);

}
