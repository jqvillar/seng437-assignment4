package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

public class CalculateRowTotalTest extends DataUtilities {

	private static final int DEFAULT_TIMEOUT = 2000;
	private Mockery mockingContext;
	
	@Before
	public void setUp() throws Exception {
		mockingContext = new Mockery();
	}

	//Equivalence Classes
	/**
	 * Input arguments consisting of a valid 3x2 Values2D array and a 
	 * row specification between 0 and the number of columns.
	 */
	@Test(timeout = DEFAULT_TIMEOUT)
	public void validRowAndDataTest(){
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations(){
			{
				allowing(values).getRowCount();
				will(returnValue(3));
				allowing(values).getColumnCount();
				will(returnValue(2));
				allowing(values).getValue(1, 0);
				will(returnValue(4));
				allowing(values).getValue(1, 1);
				will(returnValue(5));
			}
		});
		double result = DataUtilities.calculateRowTotal(values, 1);
		assertEquals("Calculating row total with valid values", 9.0, result, .000000001d);
	}
		
	//Edge Cases
	/**
	 * Column input of zero
	 */
	@Test(timeout = DEFAULT_TIMEOUT)
	public void zeroRowTest(){
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations(){
			{
				allowing(values).getRowCount();
				will(returnValue(2));
				allowing(values).getColumnCount();
				will(returnValue(2));
				allowing(values).getValue(0, 0);
				will(returnValue(2));
				allowing(values).getValue(0, 1);
				will(returnValue(3));
			}
		});
		double result = DataUtilities.calculateRowTotal(values, 0);
		assertEquals("Calculating total of the first row", 5.0, result, .000000001d);
	}
	
	/**
	 * Finding the sum of the last row within the Values2D argument
	 */
	@Test(timeout = DEFAULT_TIMEOUT)
	public void lastRowTest(){
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations(){
			{
				allowing(values).getRowCount();
				will(returnValue(2));
				allowing(values).getColumnCount();
				will(returnValue(2));
				allowing(values).getValue(1, 0);
				will(returnValue(2));
				allowing(values).getValue(1, 1);
				will(returnValue(3));
			}
		});
		double result = DataUtilities.calculateRowTotal(values, 1);
		assertEquals("Calculating total for the last row", 5.0, result, .000000001d);
	}
	
	/**
	 * Inputting a Values2D argument with only one element.
	 */
	@Test(timeout = DEFAULT_TIMEOUT)
	public void oneElementInDataTest(){
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations(){
			{
				allowing(values).getRowCount();
				will(returnValue(1));
				allowing(values).getColumnCount();
				will(returnValue(1));
				allowing(values).getValue(0, 0);
				will(returnValue(2));
			}
		});
		double result = DataUtilities.calculateRowTotal(values, 0);
		assertEquals("Calculating row total for when only one element is present", 2.0, result, .000000001d);
	}
	
	/**
	 * Inputting a Values2D argument with only no elements.
	 */
	@Test(timeout = DEFAULT_TIMEOUT)
	public void noElementTest(){
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations(){
			{
				allowing(values).getRowCount();
				will(returnValue(0));
				allowing(values).getColumnCount();
				will(returnValue(0));
			}
		});
		double result = DataUtilities.calculateRowTotal(values, 0);
		assertEquals("Calculating row total with no elements in Values2D", 0, result, .000000001d);
	}
}
