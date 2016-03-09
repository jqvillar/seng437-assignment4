package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Test;

public class RangeUpperBoundTest {

	private static final int DEFAULT_TIMEOUT = 2000;
	private static final double DEFAULT_EPSILON = 0.000000001d;
	private Range normalRange;
	private Range zeroRange;
	private Range nonZeroRange;
	private Range negativeInfinityToZeroRange;
	private Range zeroToInfinityRange;
	private Range infinityRange;
	private Range nullRange;


	public RangeUpperBoundTest() {
		normalRange = new Range(-1, 1);
		zeroRange = new Range(0, 0); 
		nonZeroRange = new Range(1, 1); 
		negativeInfinityToZeroRange = new Range(Double.NEGATIVE_INFINITY, 0);
		zeroToInfinityRange = new Range(0, Double.POSITIVE_INFINITY);
		infinityRange = new Range(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
	}

	@Test(timeout = DEFAULT_TIMEOUT)
	public void boundZero() {
		assertEquals("Test Range(0, 0) upper bound is 0", 0d, zeroRange.getUpperBound(), DEFAULT_EPSILON);
	}

	@Test(timeout = DEFAULT_TIMEOUT)
	public void infinityTest() {
		assertEquals("Test Range(neg_inf, 0) upper bound 0", 0d, negativeInfinityToZeroRange.getUpperBound(), DEFAULT_EPSILON);
		assertEquals("Test Range(0, inf) upper bound inf", Double.POSITIVE_INFINITY, zeroToInfinityRange.getUpperBound(), DEFAULT_EPSILON);
		assertEquals("Test Range(neg_inf, inf) upper inf", Double.POSITIVE_INFINITY, infinityRange.getUpperBound(), DEFAULT_EPSILON);
	}

	@Test(timeout = DEFAULT_TIMEOUT, expected = NullPointerException.class)
	public void boundNull() {
		Double nullVal = null;
		nullRange = new Range(nullVal, nullVal);
		assertEquals("Test Range(null, null) expect exception", nullVal, nullRange.getUpperBound(), DEFAULT_EPSILON);
	}

}
