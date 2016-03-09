package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Test;

public class RangeCentralValueTest {

	private static final int DEFAULT_TIMEOUT = 2000;
	private static final double DEFAULT_EPSILON = 0.000000001d;
	private Range normalRange;
	private Range zeroRange;
	private Range nonZeroRange;
	private Range negativeInfinityToZeroRange;
	private Range zeroToInfinityRange;
	private Range infinityRange;
	private Range nullRange;

	public RangeCentralValueTest() {
		normalRange = new Range(-1, 1);
		zeroRange = new Range(0, 0); 
		nonZeroRange = new Range(1, 1); 
		negativeInfinityToZeroRange = new Range(Double.NEGATIVE_INFINITY, 0);
		zeroToInfinityRange = new Range(0, Double.POSITIVE_INFINITY);
		infinityRange = new Range(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
	}

	@Test(timeout = DEFAULT_TIMEOUT)
	public void centralValueSuccess() {
		assertEquals("Test Range(-1, 1) central value 0", 0d, normalRange.getCentralValue(), DEFAULT_EPSILON);
		assertEquals("Test Range(1, 1) central value 1", 1d, nonZeroRange.getCentralValue(), DEFAULT_EPSILON);
	}

	@Test(timeout = DEFAULT_TIMEOUT)
	public void boundsZero() {
		assertEquals("Test Range(0, 0) central value 0", 0d, zeroRange.getCentralValue(), DEFAULT_EPSILON);
	}

	@Test(timeout = DEFAULT_TIMEOUT)
	public void infinityTest() {
		assertEquals("Test Range(neg_inf, 0) central value neg_inf", Double.NEGATIVE_INFINITY,	negativeInfinityToZeroRange.getCentralValue(), DEFAULT_EPSILON);
		assertEquals("Test Range(0, inf) central value inf", Double.POSITIVE_INFINITY, zeroToInfinityRange.getCentralValue(), DEFAULT_EPSILON);
		assertEquals("Test Range(neg_inf, inf) central value NaN", Double.NaN, infinityRange.getCentralValue(), DEFAULT_EPSILON);
	}

	@Test(timeout = DEFAULT_TIMEOUT, expected = NullPointerException.class)
	public void boundsNull() {
		Double nullVal = null;
		nullRange = new Range(nullVal, nullVal);
		assertEquals("Test Range(null, null) expect exception", nullVal, nullRange.getCentralValue(), DEFAULT_EPSILON);
	}

}
