package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DefaultKeyedValues;
import org.junit.Before;
import org.junit.Test;

public class DefaultKeyedValuesEqualsTest {

	private static final int DEFAULT_TIMEOUT = 2000;
	private DefaultKeyedValues dkv1;
	private DefaultKeyedValues dkv2;
	private static final double KEY1 = 1.0;
	private static final double KEY2 = 2.0;
	private static final double VALUE1 = 2.0;
	private static final double VALUE2 = 4.0;

	@Before
	public void setUp() {
		dkv1 = new DefaultKeyedValues();
		dkv2 = new DefaultKeyedValues();
	}
	
	@Test(timeout = DEFAULT_TIMEOUT)
	public void emptyCollections() {
		boolean result = dkv1.equals(dkv2);
		assertTrue("two empty collections", result);
	}
	
	@Test(timeout = DEFAULT_TIMEOUT)
	public void compareNonNullToNullObject() {
		dkv2 = null;
		boolean result = dkv1.equals(dkv2);
		assertFalse("Null Object", result);
	}
	
	@Test(timeout = DEFAULT_TIMEOUT)
	public void compareToItself() {
		boolean result = dkv1.equals(dkv1);
		assertTrue("Object is itself", result);
	}
	
	@Test(timeout = DEFAULT_TIMEOUT)
	public void differentSizes() {
		dkv1.setValue((Comparable<?>) KEY1, new Double(VALUE1));
		boolean result = dkv1.equals(dkv2);
		assertFalse("Differing sizes", result);
	}
	
	@Test(timeout = DEFAULT_TIMEOUT)
	public void differentKeys() {
		dkv1.setValue((Comparable<?>) KEY1, new Double(VALUE1));
		dkv2.setValue((Comparable<?>) KEY2, new Double(VALUE1));
		boolean result = dkv1.equals(dkv2);
		assertFalse("Differing keys", result);
	}
	
	@Test(timeout = DEFAULT_TIMEOUT)
	public void differentValues() {
		dkv1.setValue((Comparable<?>) KEY1, new Double(VALUE1));
		dkv2.setValue((Comparable<?>) KEY1, new Double(VALUE2));
		boolean result = dkv1.equals(dkv2);
		assertFalse("Differing values", result);
	}
	
	@Test(timeout = DEFAULT_TIMEOUT)
	public void nullValueInThisAndNonNullValueInObj() {
		dkv1.setValue((Comparable<?>) KEY1, null);
		dkv2.setValue((Comparable<?>) KEY1, new Double(VALUE1));
		boolean result = dkv1.equals(dkv2);
		assertFalse("Differing values(null and non null)", result);
	}
}
