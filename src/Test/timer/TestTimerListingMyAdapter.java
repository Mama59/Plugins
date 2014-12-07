package Test.timer;

import static org.junit.Assert.*;

import java.io.File;
import java.util.HashMap;

import javax.swing.Timer;

import org.junit.Before;
import org.junit.Test;

import plugin.Plugin;
import plugin.listener.PluginFinder;
import timer.TimerListingMyAdapter;
/**
 * test for timer listing my adapter extends test timer listint adapter 
 * */

public class TestTimerListingMyAdapter extends TestTimerListingAdapter {

	TimerListingMyAdapter timerMyAdapter;
	PluginFinder finder;
	File file;
	@Override
	@Before
	public void init()
	{
		file = new File("dropinsTest/plugins");
		finder = new PluginFinder(file);
		timerMyAdapter = new TimerListingMyAdapter(finder);
	}
	@Test
	@Override
	public void testActionPerformed() 
	{
		// TODO Auto-generated method stub
		timerMyAdapter = new TimerListingMyAdapter(finder);
		HashMap<String, Plugin> before = timerMyAdapter.getMapPlugin();
		Timer t = new Timer(1 , timerMyAdapter);
		t.start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(timerMyAdapter.getMapPlugin(), before);
		
		t.stop();
	}
	@Test
	@Override
	public void testGetFinder()
	{
		assertEquals(finder, timerMyAdapter.getFinder());
	}
	

}
