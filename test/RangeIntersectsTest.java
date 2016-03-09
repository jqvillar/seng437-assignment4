package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

public class RangeIntersectsTest {

    private static final int DEFAULT_TIMEOUT = 2000;
    private static final double DEFAULT_EPSILON = 0.000000001d;
    private Range sampleRange;
    private Range equalRange;
    private final double lowerBound;
    private final double upperBound;
    private final double equalBound;    
    private double testLower;
    private double testUpper;

    public RangeIntersectsTest() {
        lowerBound = -1;
        upperBound = 1;
        equalBound = 99;
    }

    @Before
    public void setup() {
        sampleRange = new Range(lowerBound, upperBound);
        equalRange = new Range(equalBound, equalBound);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void upperBetweenBoundsDoesIntersect() {
        testUpper = 0;

        testLower = lowerBound - 0.5;
        assertTrue("Lower < lowerBound, upper within bounds", sampleRange.intersects(testLower, testUpper));

        testLower = lowerBound;
        assertTrue("Lower = lowerBound, upper within bounds", sampleRange.intersects(testLower, testUpper));

        testLower = lowerBound + 0.5;
        assertTrue("Lower > lowerBound, upper within bounds", sampleRange.intersects(testLower, testUpper));
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void noIntersect() {
        testLower = lowerBound - 2;
        testUpper = lowerBound - 1;
        assertFalse("Test values less than range", sampleRange.intersects(testLower, testUpper));

        testLower = upperBound + 1;
        testUpper = upperBound + 2;
        assertFalse("Test values more than range", sampleRange.intersects(testLower, testUpper));
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void badUpperLower() {
        testLower = 0.5;
        testUpper = -0.5;
        assertFalse("Lower > upper", sampleRange.intersects(testLower, testUpper));
    }


}
