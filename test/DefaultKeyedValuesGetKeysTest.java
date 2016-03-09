package org.jfree.data.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.jfree.data.DefaultKeyedValues;
import org.junit.Before;
import org.junit.Test;

public class DefaultKeyedValuesGetKeysTest {

	private static final int DEFAULT_TIMEOUT = 2000;
	private DefaultKeyedValues dkv;
	private static final double KEY1 = 1.0;
	private static final double KEY2 = 3.0;
	private static final double VALUE1 = 2.0;
	private static final double VALUE2 = 4.0;

	@Before
	public void setUp() throws Exception {
		dkv = new DefaultKeyedValues();
	}
	
	@Test(timeout = DEFAULT_TIMEOUT)
	public void testEmptyCollection() {
		List<?> actual = dkv.getKeys();
		List<?> expected = Arrays.asList();
		assertEquals("Empty collection", expected, actual);
	}
	
	@Test(timeout = DEFAULT_TIMEOUT)
	public void testCollectionWithOneItem() {
		dkv.setValue((Comparable<?>) KEY1, new Double(VALUE1));
		List<?> actual = dkv.getKeys();
		List<Double> expected = Arrays.asList(KEY1);
		assertEquals("Collection with one item", expected, actual);
	}
	
	@Test(timeout = DEFAULT_TIMEOUT)
	public void testCollectionWithMoreThanOneItem() {
		dkv.setValue((Comparable<?>) KEY1, new Double(VALUE1));
		dkv.setValue((Comparable<?>) KEY2, new Double(VALUE2));
		List<?> actual = dkv.getKeys();
		List<Double> expected = Arrays.asList(KEY1,KEY2);
		assertEquals("Collection with two items", expected, actual);
	}
}
