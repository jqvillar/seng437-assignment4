package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DefaultKeyedValues;
import org.junit.Before;
import org.junit.Test;

public class DefaultKeyedValuesGetValueTest {

	private static final int DEFAULT_TIMEOUT = 2000;
	private DefaultKeyedValues dkv;
	private static final double KEY1 = 1.0;
	private static final double KEY2 = 3.0;
	private static final double VALUE1 = 2.0;
	private static final double VALUE2 = 4.0;

	@Before
	public void setUp() throws Exception {
		dkv = new DefaultKeyedValues();
		dkv.setValue((Comparable<?>) KEY1, new Double(VALUE1));
		dkv.setValue((Comparable<?>) KEY2, new Double(VALUE2));
	}
	
	@Test(timeout = DEFAULT_TIMEOUT)
	public void firstValueInCollection() {
		Number actual = dkv.getValue(0);
		Number expected = new Double(VALUE1);
		assertEquals("Get first value in collection", expected, actual);
	}
	
	@Test(timeout = DEFAULT_TIMEOUT)
	public void lastValueinCollection() {
		Number actual = dkv.getValue(1);
		Number expected = new Double(VALUE2);
		assertEquals("Get last value in collection", expected, actual);
	}
	
	@Test(timeout = DEFAULT_TIMEOUT, expected = IndexOutOfBoundsException.class)
	public void itemOutOfBounds() {
		dkv.getValue(3);
	}
}
