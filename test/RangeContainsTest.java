package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Test;

public class RangeContainsTest {

	private static final int DEFAULT_TIMEOUT = 2000;
	private static final double DEFAULT_EPSILON = 0.000000001d;
	private Range normalRange;
	private Range zeroRange;
	private Range nonZeroRange;
	private Range negativeInfinityToZeroRange;
	private Range zeroToInfinityRange;
	private Range infinityRange;
	private Range nullRange;


	public RangeContainsTest() {
		normalRange = new Range(-1, 1);
		zeroRange = new Range(0, 0); 
		nonZeroRange = new Range(1, 1); 
		negativeInfinityToZeroRange = new Range(Double.NEGATIVE_INFINITY, 0);
		zeroToInfinityRange = new Range(0, Double.POSITIVE_INFINITY);
		infinityRange = new Range(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
	}

	@Test(timeout = DEFAULT_TIMEOUT)
	public void valueContainedInRange() {
		assertTrue("Test 1 in Range(-1, 1)", normalRange.contains(0d));
		assertTrue("Test 0.5 in Range(-1, 1)", normalRange.contains(0.5d));
		assertTrue("Test -0.5 in Range(-1, 1)", normalRange.contains(-0.5d));
		assertTrue("Test -1 in Range(neg_inf 0)", negativeInfinityToZeroRange.contains(-1d));
		assertTrue("Test 1 in Range(0, inf)", zeroToInfinityRange.contains(1d));
		assertTrue("Test 1 in Range(inf, inf)", infinityRange.contains(0d));
		assertTrue("Test 0.5 in Range(inf, inf)", infinityRange.contains(0.5d));
		assertTrue("Test -0.5 in Range(inf, inf)", infinityRange.contains(-0.5d));
	}

	@Test(timeout = DEFAULT_TIMEOUT)
	public void valueNotContainedInRange() {
		assertFalse("Test 2 not in Range(-1, 1)", normalRange.contains(2d));
		assertFalse("Test -2 not in Range(-1, 1)", normalRange.contains(-2d));
		assertFalse("Test 0.1 not in Range(0, 0)", zeroRange.contains(0.1d));
		assertFalse("Test -0.1 not in Range(0, 0)", zeroRange.contains(-0.1d));
		assertFalse("Test 0.9 not in Range(1, 1)", nonZeroRange.contains(0.9d));
		assertFalse("Test 1.1 not in Range(1, 1)", nonZeroRange.contains(1.1d));
		assertFalse("Test 0.1 not in Range(neg_inf, 0)", negativeInfinityToZeroRange.contains(0.1d));
		assertFalse("Test -0.1 not in Range(0, inf)", zeroToInfinityRange.contains(-0.1d));
	}

	@Test(timeout = DEFAULT_TIMEOUT)
	public void valueEqualToLowerAndOrUpper() {
		assertTrue("Test 1 in Range(-1, 1)", normalRange.contains(1d));
		assertTrue("Test -1 in Range(-1, 1)", normalRange.contains(-1d));
		assertTrue("Test 1 in Range(1, 1)", nonZeroRange.contains(1d));
		assertTrue("Test 0 in Range(neg_inf, 0)", negativeInfinityToZeroRange.contains(0d));
		assertTrue("Test 0 in Range(0, inf)", zeroToInfinityRange.contains(0d));
	}

	@Test(timeout = DEFAULT_TIMEOUT)
	public void boundsZero() {
		assertTrue("Test 0 in Range(0, 0)", zeroRange.contains(0));
	}

	@Test(timeout = DEFAULT_TIMEOUT)
	public void infinityTest() {
		assertTrue("Test neg_inf in Range(neg_inf, 0)", negativeInfinityToZeroRange.contains(Double.NEGATIVE_INFINITY));
		assertTrue("Test inf in Range(0, inf)", zeroToInfinityRange.contains(Double.POSITIVE_INFINITY));
		assertTrue("Test inf in Range(neg_inf, inf)", infinityRange.contains(Double.POSITIVE_INFINITY));
		assertTrue("Test neg_inf in Range(neg_inf, inf)", infinityRange.contains(Double.NEGATIVE_INFINITY));
	}

	@Test(timeout = DEFAULT_TIMEOUT, expected = NullPointerException.class)
	public void boundsNullArgumentNull() {
		Double nullVal = null;
		nullRange = new Range(nullVal, nullVal);
		assertFalse("double is a reference type and cannot have null values", nullRange.contains(nullVal));
	}

	@Test(timeout = DEFAULT_TIMEOUT, expected = NullPointerException.class)
	public void boundsNullArgumentValid() {
		Double nullVal = null;
		nullRange = new Range(nullVal, nullVal);
		assertFalse("double is a reference type and cannot have null values", nullRange.contains(5));
	}
}
