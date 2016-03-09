package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Test;

public class RangeZeroCrossingShiftTest {

    private static final int DEFAULT_TIMEOUT = 2000;
    private static final double DEFAULT_EPSILON = 0.000000001d;
    private final double lowerBound = -1;
    private final double upperBound = 1;
    private Range baseRange;
    private Range expectedRange;
    private Range actualRange;

    public RangeZeroCrossingShiftTest() {
        baseRange = new Range(lowerBound, upperBound);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void allowZeroCrossing() {
        double delta = 3;
        expectedRange = new Range(lowerBound + delta, upperBound + delta);
        actualRange = Range.shift(baseRange, delta, true);
        assertEquals("Shift range allowing zero crossing, lower bound not expected",
                     expectedRange.getLowerBound(),
                     actualRange.getLowerBound(),
                     DEFAULT_EPSILON);
        assertEquals("Shift range allowing zero crossing, upper bound not expected",
                     expectedRange.getUpperBound(),
                     actualRange.getUpperBound(),
                     DEFAULT_EPSILON);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void disallowZeroCrossing() {
        double delta = 3;
        expectedRange = new Range(0, upperBound + delta);
        actualRange = Range.shift(baseRange, delta, false);
        assertEquals("Shift range disallowing zero crossing, lower bound not expected",
                     expectedRange.getLowerBound(),
                     actualRange.getLowerBound(),
                     DEFAULT_EPSILON);
        assertEquals("Shift range disallowing zero crossing, upper bound not expected",
                     expectedRange.getUpperBound(),
                     actualRange.getUpperBound(),
                     DEFAULT_EPSILON);
    }
}
