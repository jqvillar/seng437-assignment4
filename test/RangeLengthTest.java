package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Test;

public class RangeLengthTest {

	private static final int DEFAULT_TIMEOUT = 2000;
	private static final double DEFAULT_EPSILON = 0.000000001d;
	private Range normalRange;
	private Range zeroRange;
	private Range nonZeroRange;
	private Range negativeInfinityToZeroRange;
	private Range zeroToInfinityRange;
	private Range infinityRange;
	private Range nullRange;

	public RangeLengthTest() {
		normalRange = new Range(-1, 1);
		zeroRange = new Range(0, 0); 
		nonZeroRange = new Range(1, 1); 
		negativeInfinityToZeroRange = new Range(Double.NEGATIVE_INFINITY, 0);
		zeroToInfinityRange = new Range(0, Double.POSITIVE_INFINITY);
		infinityRange = new Range(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
	}


	@Test(timeout = DEFAULT_TIMEOUT)
	public void lengthSuccess() {
		assertEquals("Test Range(-1, 1) length 2", 2d, normalRange.getLength(), DEFAULT_EPSILON);
		assertEquals("Test Range(1, 1) length 0", 0d, nonZeroRange.getLength(), DEFAULT_EPSILON);
	}


	@Test(timeout = DEFAULT_TIMEOUT, expected = IllegalArgumentException.class)
	public void invalidBounds() {
		Range invalidRange = new Range(1, -1);
		assertEquals("Invalid: Lower bound entered is greater than the upper bound", invalidRange.getLength());
	}

	@Test(timeout = DEFAULT_TIMEOUT)
	public void boundsZero() {
		assertEquals("Test Range(0, 0) length 0", 0d, zeroRange.getLength(), DEFAULT_EPSILON);
	}

	@Test(timeout = DEFAULT_TIMEOUT)
	public void infinityTest() {
		assertEquals("Test Range(neg_inf, zero) length inf", Double.POSITIVE_INFINITY, negativeInfinityToZeroRange.getLength(), DEFAULT_EPSILON);
		assertEquals("Test Range(zero, inf) length inf", Double.POSITIVE_INFINITY, zeroToInfinityRange.getLength(), DEFAULT_EPSILON);
		assertEquals("Test Range(neg_inf, inf) length inf", Double.POSITIVE_INFINITY, infinityRange.getLength(), DEFAULT_EPSILON);
	}

	@Test(timeout = DEFAULT_TIMEOUT, expected = NullPointerException.class)
	public void boundsNull() {
		Double nullVal = null;
		nullRange = new Range(nullVal, nullVal);
		assertEquals("Test Range(null, null) expect exception", nullVal, nullRange.getLength(), DEFAULT_EPSILON);
	}
}
