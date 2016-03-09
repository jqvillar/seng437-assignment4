package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DefaultKeyedValues;
import org.junit.Before;
import org.junit.Test;

public class DefaultKeyedValuesRemoveValueTest {

	private static final int DEFAULT_TIMEOUT = 2000;
	private DefaultKeyedValues dkv;
	private static final double KEY1 = 1.0;
	private static final double KEY2 = 3.0;
	private static final double KEY_OUT_OF_BOUNDS = 7.0;
	private static final double VALUE1 = 2.0;
	private static final double VALUE2 = 4.0;

	@Before
	public void setUp() {
		dkv = new DefaultKeyedValues();
		dkv.setValue((Comparable<?>) KEY1, new Double(VALUE1));
		dkv.setValue((Comparable<?>) KEY2, new Double(VALUE2));
	}
	
	@Test(timeout = DEFAULT_TIMEOUT, expected = IndexOutOfBoundsException.class)
	public void removeIndexLessThanZero_index() {
		dkv.removeValue(-1);
	}
	
	@Test(timeout = DEFAULT_TIMEOUT)
	public void removeFirstItem_index() {
		dkv.removeValue(0);
		DefaultKeyedValues actual = dkv;
		DefaultKeyedValues expected = new DefaultKeyedValues();
		expected.setValue((Comparable<?>) KEY2, new Double(VALUE2));
		assertEquals("Remove first item in collection", expected, actual);
	}
	
	@Test(timeout = DEFAULT_TIMEOUT, expected = IndexOutOfBoundsException.class)
	public void removeIndexGreaterThanCollectionSize_index() {
		dkv.removeValue(2);
	}
	
	@Test(timeout = DEFAULT_TIMEOUT)
	public void removeKeyInCollection_key() {
		dkv.removeValue((Comparable<?>) KEY2);
		DefaultKeyedValues actual = dkv;
		DefaultKeyedValues expected = new DefaultKeyedValues();
		expected.setValue((Comparable<?>) KEY1, new Double(VALUE1));
		assertEquals("Remove key in collection", expected, actual);
	}
	
	@Test(timeout = DEFAULT_TIMEOUT)
	public void removeKeyNotInCollection_key() {
		dkv.removeValue((Comparable<?>) KEY_OUT_OF_BOUNDS);
		DefaultKeyedValues actual = dkv;
		DefaultKeyedValues expected = new DefaultKeyedValues();
		expected.setValue((Comparable<?>) KEY1, new Double(VALUE1));
		expected.setValue((Comparable<?>) KEY2, new Double(VALUE2));
		assertEquals("Remove key in collection", expected, actual);
	}
}
