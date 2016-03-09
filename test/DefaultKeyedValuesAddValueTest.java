package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DefaultKeyedValues;
import org.junit.Before;
import org.junit.Test;

public class DefaultKeyedValuesAddValueTest {

	private static final int DEFAULT_TIMEOUT = 2000;
	private DefaultKeyedValues dkv;
	private static final double KEY1 = 1.0;
	private static final double VALUE1 = 2.0;
	private static final double VALUE2 = 3.0;

	@Before
	public void setUp() {
		dkv = new DefaultKeyedValues();
	}
	
	@Test(timeout = DEFAULT_TIMEOUT)
	public void addNewValue_double() {
		dkv.addValue((Comparable<?>) KEY1, VALUE1);
		DefaultKeyedValues actual = dkv;
		DefaultKeyedValues expected = new DefaultKeyedValues();
		expected.setValue((Comparable<?>) KEY1, new Double(VALUE1));
		assertEquals("Adding new value to empty collection", expected, actual);
	}
	
	@Test(timeout = DEFAULT_TIMEOUT)
	public void updateExistingValue_double() {
		dkv.setValue((Comparable<?>) KEY1, new Double(VALUE1));
		dkv.addValue((Comparable<?>) KEY1, VALUE2);
		DefaultKeyedValues actual = dkv;
		DefaultKeyedValues expected = new DefaultKeyedValues();
		expected.setValue((Comparable<?>) KEY1, new Double(VALUE2));
		assertEquals("Updating existing value in collection", expected, actual);
	}
	
	@Test(timeout = DEFAULT_TIMEOUT)
	public void addNewValue_number() {
		dkv.addValue((Comparable<?>) KEY1, new Double(VALUE1));
		DefaultKeyedValues actual = dkv;
		DefaultKeyedValues expected = new DefaultKeyedValues();
		expected.setValue((Comparable<?>) KEY1, new Double(VALUE1));
		assertEquals("Adding new value to collection", expected, actual);
	}
	
	@Test(timeout = DEFAULT_TIMEOUT)
	public void updateExistingValue_number() {
		dkv.setValue((Comparable<?>) KEY1, new Double(VALUE1));
		dkv.addValue((Comparable<?>) KEY1, new Double(VALUE2));
		DefaultKeyedValues actual = dkv;
		DefaultKeyedValues expected = new DefaultKeyedValues();
		expected.setValue((Comparable<?>) KEY1, new Double(VALUE2));
		assertEquals("Updating existing value in collection", expected, actual);
	}
	
	
	@Test(timeout = DEFAULT_TIMEOUT)
	public void addValueEqualsNull_number() {
		dkv.addValue((Comparable<?>) VALUE1, null);
		DefaultKeyedValues actual = dkv;
		DefaultKeyedValues expected = new DefaultKeyedValues();
		expected.setValue((Comparable<?>) VALUE1, null);
		assertEquals("Adding null value in collection", expected, actual);
	}
}
