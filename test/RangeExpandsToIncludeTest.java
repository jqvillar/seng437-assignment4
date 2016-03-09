package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

public class RangeExpandsToIncludeTest {

    private static final int DEFAULT_TIMEOUT = 2000;
    private static final double DEFAULT_EPSILON = 0.000000001d;
    private Range sampleRange;
    private Range actualRange;
    private Range expectedRange;
    private final double lowerBound;
    private final double upperBound;
    private double testValue;

    public RangeExpandsToIncludeTest() {
        lowerBound = -1;
        upperBound = 1;
    }

    @Before
    public void setup() {
        sampleRange = new Range(lowerBound, upperBound);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void nullRange() {
        testValue = 1;
        actualRange = Range.expandToInclude(null, testValue);
        expectedRange = new Range(testValue, testValue);
        assertEquals("Range is null", 
                   expectedRange.getLowerBound(), 
                   actualRange.getLowerBound(), 
                   DEFAULT_EPSILON);
        assertEquals("Range is null", 
                   expectedRange.getUpperBound(), 
                   actualRange.getUpperBound(), 
                   DEFAULT_EPSILON);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void valueLessThanLowerBound() {
        testValue = lowerBound - 1;
        actualRange = Range.expandToInclude(sampleRange, testValue);
        expectedRange = new Range(testValue, upperBound);
        assertEquals("Test value less than lower bound", 
                   expectedRange.getLowerBound(), 
                   actualRange.getLowerBound(), 
                   DEFAULT_EPSILON);
        assertEquals("Test value less than lower bound", 
                   expectedRange.getUpperBound(), 
                   actualRange.getUpperBound(), 
                   DEFAULT_EPSILON);        
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void valueGreaterThanLowerBound() {
        testValue = upperBound + 1;
        actualRange = Range.expandToInclude(sampleRange, testValue);
        expectedRange = new Range(lowerBound, testValue);
        assertEquals("Test value greater than lower bound", 
                   expectedRange.getLowerBound(), 
                   actualRange.getLowerBound(), 
                   DEFAULT_EPSILON);
        assertEquals("Test value greater than lower bound", 
                   expectedRange.getUpperBound(), 
                   actualRange.getUpperBound(), 
                   DEFAULT_EPSILON);        
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void valueEqualToBounds() {
        testValue = lowerBound;
        actualRange = Range.expandToInclude(sampleRange, testValue);
        expectedRange = new Range(lowerBound, upperBound);
        assertEquals("Test value equal to lower bound", 
                   expectedRange.getLowerBound(), 
                   actualRange.getLowerBound(), 
                   DEFAULT_EPSILON);
        assertEquals("Test value equal to lower bound", 
                   expectedRange.getUpperBound(), 
                   actualRange.getUpperBound(), 
                   DEFAULT_EPSILON);        
        
        testValue = upperBound;
        actualRange = Range.expandToInclude(sampleRange, testValue);
        expectedRange = new Range(lowerBound, upperBound);
        assertEquals("Test value equal to upper bound", 
                   expectedRange.getLowerBound(), 
                   actualRange.getLowerBound(), 
                   DEFAULT_EPSILON);
        assertEquals("Test value equal to upper bound", 
                   expectedRange.getUpperBound(), 
                   actualRange.getUpperBound(), 
                   DEFAULT_EPSILON);       
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void valueBetweenBounds() {
        testValue = 0;
        actualRange = Range.expandToInclude(sampleRange, testValue);
        expectedRange = new Range(lowerBound, upperBound);
        assertEquals("Test value between bounds", 
                   expectedRange.getLowerBound(), 
                   actualRange.getLowerBound(), 
                   DEFAULT_EPSILON);
        assertEquals("Test value between bounds", 
                   expectedRange.getUpperBound(), 
                   actualRange.getUpperBound(), 
                   DEFAULT_EPSILON);        
    }
}
