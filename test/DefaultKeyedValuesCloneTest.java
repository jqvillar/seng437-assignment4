package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DefaultKeyedValues;
import org.junit.Before;
import org.junit.Test;

public class DefaultKeyedValuesCloneTest {

	private static final int DEFAULT_TIMEOUT = 2000;
	private DefaultKeyedValues dkv;
	private static final double KEY1 = 1.0;
	private static final double VALUE1 = 2.0;

	@Before
	public void setUp() {
		dkv = new DefaultKeyedValues();
	}
	
	@Test(timeout = DEFAULT_TIMEOUT)
	public void emptyCollection() throws CloneNotSupportedException {
		Object actual = dkv.clone();
		Object expected = new DefaultKeyedValues();
		assertEquals("clone empty collection", expected, actual);
	}
	
	@Test(timeout = DEFAULT_TIMEOUT)
	public void nonEmptyCollection() throws CloneNotSupportedException{
		dkv.setValue((Comparable<?>) KEY1, new Double(VALUE1));
		Object actual = dkv.clone();
		DefaultKeyedValues expected = new DefaultKeyedValues();
		expected.setValue((Comparable<?>) KEY1, new Double(VALUE1));
		assertEquals("clone non-empty collection", expected, actual);
	}
}
