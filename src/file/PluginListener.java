package file ;



public interface PluginListener extends java.util.EventListener {

	void pluginAdded(PluginEvent event);

	void pluginRemoved(PluginEvent event);


}
