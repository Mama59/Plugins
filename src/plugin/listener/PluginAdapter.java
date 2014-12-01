package plugin.listener;

import plugin.CurrentPlugins;
import filter.PluginEvent;

public class PluginAdapter implements PluginListener {
	protected CurrentPlugins currentPlugins;
	public void pluginAdded(PluginEvent event) {}

	public void pluginRemoved(PluginEvent event) {}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((currentPlugins == null) ? 0 : currentPlugins.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PluginAdapter other = (PluginAdapter) obj;
		if (currentPlugins == null) {
			if (other.currentPlugins != null)
				return false;
		} else if (!currentPlugins.equals(other.currentPlugins))
			return false;
		return true;
	}
	
}
