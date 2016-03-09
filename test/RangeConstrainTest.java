package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

public class RangeConstrainTest {

    private static final int DEFAULT_TIMEOUT = 2000;
    private static final double DEFAULT_EPSILON = 0.000000001d;
    private final double lowerBound;
    private final double upperBound;
    private double testValue;
    private Range sampleRange;
    private double expectedValue;
    private double actualValue;

    public RangeConstrainTest() {
        lowerBound = -1;
        upperBound = 1;
    }

    @Before
    public void setup() {
        sampleRange = new Range(lowerBound, upperBound);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void valueBelowLowerBound() {
        testValue = lowerBound - 1;
        expectedValue = lowerBound;
        actualValue = sampleRange.constrain(testValue);
        assertEquals("Value below lower bound", expectedValue, actualValue, DEFAULT_EPSILON);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void valueEqualLowerBound() {
        testValue = lowerBound;
        expectedValue = testValue;
        actualValue = sampleRange.constrain(testValue);
        assertEquals("Value same as lower bound", expectedValue, actualValue, DEFAULT_EPSILON);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void valueBetweenBounds() {
        testValue = 0;
        expectedValue = testValue;
        actualValue = sampleRange.constrain(testValue);
        assertEquals("Value between upper and lower bound", expectedValue, actualValue, DEFAULT_EPSILON);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void valueEqualUpperBound() {
        testValue = upperBound;
        expectedValue = testValue;
        actualValue = sampleRange.constrain(testValue);
        assertEquals("Value equal to upper bound", expectedValue, actualValue, DEFAULT_EPSILON);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void valueAboveUpperBound() {
        testValue = upperBound + 1;
        expectedValue = upperBound;
        actualValue = sampleRange.constrain(testValue);
        assertEquals("Value above upper bound", expectedValue, actualValue, DEFAULT_EPSILON);
    }
}
