package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DefaultKeyedValues;
import org.junit.Before;
import org.junit.Test;

public class DefaultKeyedValuesHashCodeTest {

	private static final int DEFAULT_TIMEOUT = 2000;
	private DefaultKeyedValues dkv1;
	private DefaultKeyedValues dkv2;
	private final Comparable<?> KEY = 1.0;
	private final Double VALUE = new Double(2.0); 


	@Before
	public void setUp() {
		dkv1 = new DefaultKeyedValues();
		dkv1.setValue(KEY, VALUE);
		dkv2 = new DefaultKeyedValues();
		dkv2.setValue(KEY, VALUE);
	}
	
	@Test(timeout = DEFAULT_TIMEOUT)
	public void emptyCollections() {
		int hashCode1 = dkv1.hashCode();
		int hashCode2 = dkv2.hashCode();
		assertEquals("Same hashcodes", hashCode1, hashCode2);
	}
	
}
