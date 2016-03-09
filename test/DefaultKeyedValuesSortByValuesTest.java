package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DefaultKeyedValues;
import org.jfree.util.SortOrder;
import org.junit.Before;
import org.junit.Test;

public class DefaultKeyedValuesSortByValuesTest {

	private static final int DEFAULT_TIMEOUT = 2000;
	private DefaultKeyedValues dkv;
	private static final double KEY1 = 1.0;
	private static final double KEY2 = 3.0;
	private static final double KEY3 = 5.0;
	private static final double VALUE1 = 2.0;
	private static final double VALUE2 = 4.0;
	private static final double VALUE3 = 6.0;

	@Before
	public void setUp() {
		dkv = new DefaultKeyedValues();
	}
	
	@Test(timeout = DEFAULT_TIMEOUT)
	public void emptyCollection() {
		dkv.sortByValues(SortOrder.ASCENDING);
		DefaultKeyedValues actual = dkv;
		DefaultKeyedValues expected = new DefaultKeyedValues();
		assertEquals("Ascending sort empty collection", expected, actual);
		
	}
	
	@Test(timeout = DEFAULT_TIMEOUT)
	public void oneItemCollection() {
		dkv.setValue((Comparable<?>) KEY1, new Double(VALUE1));
		dkv.sortByValues(SortOrder.ASCENDING);
		DefaultKeyedValues actual = dkv;
		DefaultKeyedValues expected = new DefaultKeyedValues();
		expected.setValue((Comparable<?>) KEY1, new Double(VALUE1));
		assertEquals("Ascending sort one item in collection", expected, actual);
	}
	
	@Test(timeout = DEFAULT_TIMEOUT)
	public void ascendingSort() {
		dkv.setValue((Comparable<?>) KEY3, new Double(VALUE3));
		dkv.setValue((Comparable<?>) KEY1, new Double(VALUE1));
		dkv.setValue((Comparable<?>) KEY2, new Double(VALUE2));
		dkv.sortByValues(SortOrder.ASCENDING);
		DefaultKeyedValues actual = dkv;
		DefaultKeyedValues expected = new DefaultKeyedValues();
		expected.setValue((Comparable<?>) KEY1, new Double(VALUE1));
		expected.setValue((Comparable<?>) KEY2, new Double(VALUE2));
		expected.setValue((Comparable<?>) KEY3, new Double(VALUE3));
		assertEquals("Ascending sort", expected, actual);
	}
	
	@Test(timeout = DEFAULT_TIMEOUT)
	public void descendingSort() {
		dkv.setValue((Comparable<?>) KEY3, new Double(VALUE3));
		dkv.setValue((Comparable<?>) KEY1, new Double(VALUE1));
		dkv.setValue((Comparable<?>) KEY2, new Double(VALUE2));
		dkv.sortByValues(SortOrder.DESCENDING);
		DefaultKeyedValues actual = dkv;
		DefaultKeyedValues expected = new DefaultKeyedValues();
		expected.setValue((Comparable<?>) KEY3, new Double(VALUE3));
		expected.setValue((Comparable<?>) KEY2, new Double(VALUE2));
		expected.setValue((Comparable<?>) KEY1, new Double(VALUE1));
		assertEquals("Descending sort", expected, actual);
	}
	
}
