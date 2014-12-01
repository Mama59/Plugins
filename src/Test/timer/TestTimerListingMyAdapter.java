package Test.timer;

import java.io.File;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import plugin.Plugin;
import filter.PluginFinder;
import timer.TimerListingMyAdapter;

public class TestTimerListingMyAdapter extends TestTimerListingAdapter {

	TimerListingMyAdapter timerMyAdapter;
	PluginFinder finder;
	File file;
	@Before
	public void init()
	{
		file = new File("dropinsTest/plugins");
		finder = new PluginFinder(file);
		timerMyAdapter = new TimerListingMyAdapter(finder);
	}
	@Test
	public void testActionPerformed()
	{
		HashMap<String, Plugin> listClassBefore = timerMyAdapter.getListClass();
		System.out.println(listClassBefore);
		timerMyAdapter.actionPerformed(null);
		
	}
}
