package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

public class RangeEqualsTest {

    private static final int DEFAULT_TIMEOUT = 2000;
    private static final double DEFAULT_EPSILON = 0.000000001d;
    private Range sampleRange;
    private Range rangeObj;
    private final double lowerBound;
    private final double upperBound;

    public RangeEqualsTest() {
        lowerBound = -1;
        upperBound = 1;
    }

    @Before
    public void setup() {
        sampleRange = new Range(lowerBound, upperBound);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void objNull() {
        Object obj = null;
        assertFalse("Parameter is null", sampleRange.equals(obj));
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void objNotRange() {
        String obj = "fail";
        assertFalse("Parameter is not Range", sampleRange.equals(obj));
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void objIsSelf() {
        assertTrue("Object is self", sampleRange.equals(sampleRange));
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void rangeIsEqual() {
        rangeObj = new Range(-1, 1);
        assertTrue("Range is equal", sampleRange.equals(rangeObj));
    }    
    
}
