package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;
import java.util.Arrays;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.KeyedValues;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

public class GetCumulativePercentagesTests extends DataUtilities {

	private static final int DEFAULT_TIMEOUT = 2000;
	private Mockery mockingContext;

	private void assertValuesEquals(DefaultKeyedValues expectedCumulativePercentages, KeyedValues actualCumulativePercentages) {
		assertEquals("Getting first value result", expectedCumulativePercentages.getValue(0), actualCumulativePercentages.getValue(0));
		assertEquals("Getting second value result", expectedCumulativePercentages.getValue(1), actualCumulativePercentages.getValue(1));
		assertEquals("Getting third value result", expectedCumulativePercentages.getValue(2), actualCumulativePercentages.getValue(2));
	}
	
	@Before
	public void setUp() throws Exception {
		mockingContext = new Mockery();
	}

	//Equivalence classes
	
	/**
	 * testing 'data' containing positive and negative infinity
	 */
	@Test(timeout = DEFAULT_TIMEOUT)
	public void testInputDataContainingInfinities() {
		final KeyedValues data = mockingContext.mock(KeyedValues.class);
		mockingContext.checking(new Expectations() {
			{				
				allowing(data).getIndex(0); will(returnValue(0));
				allowing(data).getIndex(1); will(returnValue(1));
				allowing(data).getIndex(2); will(returnValue(2));
				allowing(data).getKey(0); will(returnValue(0));
				allowing(data).getKey(1); will(returnValue(1));
				allowing(data).getKey(2); will(returnValue(2));
				allowing(data).getKeys(); will(returnEnumeration(Arrays.asList(0,1,2)));
				allowing(data).getValue(0); will(returnValue(Double.POSITIVE_INFINITY));
				allowing(data).getValue(1); will(returnValue(Double.NEGATIVE_INFINITY));
				allowing(data).getValue(2); will(returnValue(7));
				allowing(data).getItemCount(); will(returnValue(3));
			}
			});
			
		KeyedValues actualCumulativePercentages = getCumulativePercentages(data);
		DefaultKeyedValues expectedCumulativePercentages = new DefaultKeyedValues();
		expectedCumulativePercentages.addValue((Comparable<?>)0, Double.NaN);
		expectedCumulativePercentages.addValue((Comparable<?>)1, Double.NaN);
		expectedCumulativePercentages.addValue((Comparable<?>)2, Double.NaN);
		
		assertValuesEquals(expectedCumulativePercentages, actualCumulativePercentages);
	}

	/**
	 * testing cumulative sum of values 'data' equal to zero
	 */
	@Test(timeout = DEFAULT_TIMEOUT)
	public void testInputDataValuesSummingToZero() {
		final KeyedValues data = mockingContext.mock(KeyedValues.class);
		mockingContext.checking(new Expectations() {
			{				
				allowing(data).getIndex(0); will(returnValue(0));
				allowing(data).getIndex(1); will(returnValue(1));
				allowing(data).getIndex(2); will(returnValue(2));
				allowing(data).getKey(0); will(returnValue(0));
				allowing(data).getKey(1); will(returnValue(1));
				allowing(data).getKey(2); will(returnValue(2));
				allowing(data).getKeys(); will(returnEnumeration(Arrays.asList(0,1,2)));
				allowing(data).getValue(0); will(returnValue(0));
				allowing(data).getValue(1); will(returnValue(0));
				allowing(data).getValue(2); will(returnValue(0));
				allowing(data).getItemCount(); will(returnValue(3));
			}
			});
			
		KeyedValues actualCumulativePercentages = getCumulativePercentages(data);
		DefaultKeyedValues expectedCumulativePercentages = new DefaultKeyedValues();
		expectedCumulativePercentages.addValue((Comparable<?>)0, Double.NaN);
		expectedCumulativePercentages.addValue((Comparable<?>)1, Double.NaN);
		expectedCumulativePercentages.addValue((Comparable<?>)2, Double.NaN);
		
		assertValuesEquals(expectedCumulativePercentages, actualCumulativePercentages);
	}

}
