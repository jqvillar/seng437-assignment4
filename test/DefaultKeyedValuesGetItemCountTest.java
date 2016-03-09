package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DefaultKeyedValues;
import org.junit.Test;

public class DefaultKeyedValuesGetItemCountTest {

	private static final int DEFAULT_TIMEOUT = 2000;
	private static final double DEFAULT_EPSILON = 0.000000001d;
	private DefaultKeyedValues dkv;
	private static final double KEY1 = 1.0;
	private static final double KEY2 = 3.0;
	private static final double VALUE1 = 2.0;
	private static final double VALUE2 = 4.0;

	@Test(timeout = DEFAULT_TIMEOUT)
	public void emptyCollection() {
		dkv = new DefaultKeyedValues();
		int actual = dkv.getItemCount();
		int expected = 0;
		assertEquals("Empty collection", expected, actual, DEFAULT_EPSILON);
	}
	
	@Test(timeout = DEFAULT_TIMEOUT, expected = NullPointerException.class)
	public void nullCollection() {
		dkv = null;
		dkv.getItemCount();
	}
	
	@Test(timeout = DEFAULT_TIMEOUT)
	public void collectionWithOneItem() {
		dkv = new DefaultKeyedValues();
		dkv.setValue((Comparable<?>) KEY1, new Double(VALUE1));
		int actual = dkv.getItemCount();
		int expected = 1;
		assertEquals("Collection with one item", expected, actual, DEFAULT_EPSILON);
	}
	
	@Test(timeout = DEFAULT_TIMEOUT)
	public void collectionWithMoreThanOneItem() {
		dkv = new DefaultKeyedValues();
		dkv.setValue((Comparable<?>) KEY1, new Double(VALUE1));
		dkv.setValue((Comparable<?>) KEY2, new Double(VALUE2));
		int actual = dkv.getItemCount();
		int expected = 2;
		assertEquals("Collection with two items", expected, actual, DEFAULT_EPSILON);
	}
}
