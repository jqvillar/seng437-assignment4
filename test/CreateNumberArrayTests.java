package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.junit.Test;

public class CreateNumberArrayTests extends DataUtilities {

	private static final int DEFAULT_TIMEOUT = 2000;
	private double[] data;

	//Equivalence Classes
	
	/**
	 * testing valid array of double primitives.
	 */
	@Test(timeout = DEFAULT_TIMEOUT)
	public void testValidInputArray() {
		data = new double[3];
		data[0] = 0.0;
		data[1] = 1.1;
		data[2] = 2.2;
		
		Number[] expected = new Number[]{0.0, 1.1, 2.2};
		Number[] actual = createNumberArray(data);
		assertArrayEquals("passing valid array", expected, actual);
	}
	
	//Edge cases
	
	/**
	 * testing input array containing positive and negative infinity
	 */
	@Test(timeout = DEFAULT_TIMEOUT)
	public void testInputArrayContainingInfinity() {
		data = new double[3];
		data[0] = Double.POSITIVE_INFINITY;
		data[1] = 1.1;
		data[2] = Double.NEGATIVE_INFINITY;
		
		Number[] actual = createNumberArray(data);
		Number[] expected = new Number[]{Double.POSITIVE_INFINITY, 1.1, Double.NEGATIVE_INFINITY};
		assertArrayEquals("passing array with infinity values", expected, actual);
	}
	
	/**
	 * testing input array of length zero
	 */
	@Test(timeout = DEFAULT_TIMEOUT)
	public void testInputArrayofLengthZero() {
		data = new double[0];
		
		Number[] actual = createNumberArray(data);
		Number[] expected = new Number[0];
		assertArrayEquals("passing array of length 0", expected, actual);
	}
	
	/**
	 * testing input array containing one element
	 */
	@Test(timeout = DEFAULT_TIMEOUT)
	public void testInputArrayWithOneElement() {
		data = new double[1];
		data[0] = 1.1;
		
		Number[] actual = createNumberArray(data);
		Number[] expected = new Number[]{1.1};
		assertArrayEquals("passing array with one element", expected, actual);
	}

}
