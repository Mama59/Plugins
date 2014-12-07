package Test.filter;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import filter.FilterClassFiles;
/**
 * Test for FileterClassFiles
 * */
public class TestFilterClassFiles {

	private FilterClassFiles filter;
	/**
	 * test if accept return true
	 * */
	@Test
	public void testAcceptTrue()
	{
		filter = new FilterClassFiles();
		assertTrue(filter.accept(new File(""),"truc.class"));
	}
	/**
	 * test if accept return false
	 * */
	@Test
	public void testAcceptFalse()
	{
		filter = new FilterClassFiles();
		assertFalse(filter.accept(new File(""),"biduleclass"));
	}
}
