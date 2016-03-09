package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.junit.Test;

public class CreateNumberArray2DTests extends DataUtilities {

	private static final int DEFAULT_TIMEOUT = 2000;
	private double[][] data;

	//Equivalence Classes
	
	/**
	 * testing valid array of arrays of double primitives.
	 */
	@Test(timeout = DEFAULT_TIMEOUT)
	public void testValidInputArrayOfArrays() {
		data = new double[2][];
		data[0] = new double[]{0.0, 1.1};
		data[1] = new double[]{2.2, 3.3, 4.4};
		
		Number[][] expected = new Number[2][];
		expected[0] = new Number[]{0.0, 1.1};
		expected[1] = new Number[]{2.2, 3.3, 4.4};
		
		Number[][] actual = createNumberArray2D(data);
		assertArrayEquals("passing valid array", expected, actual);
	}
		
	//Edge cases
	
	/**
	 * testing input array of arrays containing positive and negative infinity
	 */
	@Test(timeout = DEFAULT_TIMEOUT)
	public void testInputArrayWithArraysContainingInfinity() {
		data = new double[2][];
		data[0] = new double[]{0.0, Double.NEGATIVE_INFINITY};
		data[1] = new double[]{2.2, Double.POSITIVE_INFINITY, 4.4};
		
		Number[][] expected = new Number[2][];
		expected[0] = new Number[]{0.0, Double.NEGATIVE_INFINITY};
		expected[1] = new Number[]{2.2, Double.POSITIVE_INFINITY, 4.4};
		
		Number[][] actual = createNumberArray2D(data);
		assertArrayEquals("passing array of arrays with infinity values", expected, actual);
	}
	
	/**
	 * testing input array of length zero
	 */
	@Test(timeout = DEFAULT_TIMEOUT)
	public void testInputArrayOfLengthZero() {
		data = new double[0][];
		
		Number[][] actual = createNumberArray2D(data);
		Number[][] expected = new Number[0][];
		assertArrayEquals("passing array of length 0", expected, actual);
	}
}
