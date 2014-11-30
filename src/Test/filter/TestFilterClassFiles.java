package Test.filter;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import filter.FilterClassFiles;

public class TestFilterClassFiles {

	FilterClassFiles filter;
	@Test
	public void testAcceptTrue()
	{
		filter = new FilterClassFiles();
		assertTrue(filter.accept(new File(""),"truc.class"));
	}
	@Test
	public void testAcceptFalse()
	{
		filter = new FilterClassFiles();
		assertFalse(filter.accept(new File(""),"biduleclass"));
	}
}
