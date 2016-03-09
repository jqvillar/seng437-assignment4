package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Test;

public class RangeExpandTest {

    private static final int DEFAULT_TIMEOUT = 2000;
    private static final double DEFAULT_EPSILON = 0.000000001d;
    private final double lowerBound = -1;
    private final double upperBound = 1;
    private Range sampleRange;
    private Range expectedRange;
    private Range actualRange;


    public RangeExpandTest() {
        sampleRange = new Range(lowerBound, upperBound);
    }

    @Test(timeout = DEFAULT_TIMEOUT, expected = IllegalArgumentException.class)
    public void testRangeNull() {
        Range nullRange = (Range) null;
        Range.expand(nullRange, -10, 10); // -10, 10 are garbage values
    }

}
