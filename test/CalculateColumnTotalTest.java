package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

public class CalculateColumnTotalTest extends DataUtilities {

	private static final int DEFAULT_TIMEOUT = 2000;
	private Mockery mockingContext;
	
	@Before
	public void setUp() throws Exception {
		mockingContext = new Mockery();
	}

	//Equivalence Classes
	/**
	 * Input arguments consisting of a valid Values2D array and a 
	 * column specification between 0 and the number of columns.
	 */
	@Test(timeout = DEFAULT_TIMEOUT)
	public void validColumnAndDataTest(){
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations(){
			{
				allowing(values).getRowCount();
				will(returnValue(2));
				allowing(values).getColumnCount();
				will(returnValue(3));
				allowing(values).getValue(0, 1);
				will(returnValue(4));
				allowing(values).getValue(1, 1);
				will(returnValue(5));
			}
		});
		double result = DataUtilities.calculateColumnTotal(values, 1);
		assertEquals("Calculating column total with valid values", 9.0, result, .000000001d);
	}
	
	
	/**
	 * Input with a negative column argument and a valid Values2D 
	 * array.
	 */
	@Test(timeout = DEFAULT_TIMEOUT)
	public void negativeColumnTest(){
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations(){
			{
				allowing(values).getRowCount();
				will(returnValue(1));
				allowing(values).getColumnCount();
				will(returnValue(2));
				//ignore the function call in the case where the method is working incorrectly
				ignoring(values).getValue(0, -1);
			}
		});
		double result = DataUtilities.calculateColumnTotal(values, -1);
		assertEquals("Calculating total with a negative column parameter", 0, result, .000000001d);
	}
	
	/**
	 * Column argument that is greater than or equal to the number 
	 * of columns in the Values2D argument.
	 */
	@Test(timeout = DEFAULT_TIMEOUT)
	public void outOfBoundsColumnTest(){
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations(){
			{
				allowing(values).getRowCount();
				will(returnValue(1));
				allowing(values).getColumnCount();
				will(returnValue(2));
				//ignore the function call in the case where the method is working incorrectly
				ignoring(values).getValue(0,2);
			}
		});
		double result = DataUtilities.calculateColumnTotal(values, 2);
		assertEquals("Calculating column total with an out of bounds parameter", 0, result, .000000001d);
	}
	
	//Edge Cases
	/**
	 * Column input of zero
	 */
	@Test(timeout = DEFAULT_TIMEOUT)
	public void zeroColumnTest(){
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations(){
			{
				allowing(values).getColumnCount();
				will(returnValue(1));
				allowing(values).getRowCount();
				will(returnValue(2));
				allowing(values).getValue(0, 0);
				will(returnValue(2));
				allowing(values).getValue(1, 0);
				will(returnValue(3));
			}
		});
		double result = DataUtilities.calculateColumnTotal(values, 0);
		assertEquals("Calculating column total with a column parameter of 0", 5.0, result, .000000001d);
	}
	
	/**
	 * Finding the sum of the last column within the Values2D argument
	 */
	@Test(timeout = DEFAULT_TIMEOUT)
	public void lastColumnTest(){
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations(){
			{
				allowing(values).getRowCount();
				will(returnValue(2));
				allowing(values).getColumnCount();
				will(returnValue(2));
				allowing(values).getValue(0, 1);
				will(returnValue(2));
				allowing(values).getValue(1, 1);
				will(returnValue(3));
			}
		});
		double result = DataUtilities.calculateColumnTotal(values, 1);
		assertEquals("Calculating total of the last column", 5.0, result, .000000001d);
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
		double result = DataUtilities.calculateColumnTotal(values, 0);
		assertEquals( "Calculating column total with only one element", 2.0, result, .000000001d);
	}
	/**
	 * Inputting a Values2D argument with no elements.
	 */
	@Test(timeout = DEFAULT_TIMEOUT)
	public void noElementsTest(){
		final Values2D values = mockingContext.mock(Values2D.class);
		mockingContext.checking(new Expectations(){
			{
				allowing(values).getRowCount();
				will(returnValue(0));
				allowing(values).getColumnCount();
				will(returnValue(0));
			}
		});
		double result = DataUtilities.calculateColumnTotal(values, 0);
		assertEquals("Calculating column total with no elements", 0, result, .000000001d);
	}
}
