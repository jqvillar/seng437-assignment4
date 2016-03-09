package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Test;

public class RangeHashCodeTest {

    private static final int DEFAULT_TIMEOUT = 2000;
    private final double lowerBound = -1;
    private final double upperBound = 1;

    public RangeHashCodeTest() {

    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void testSameHash() {
        Range range1 = new Range(lowerBound, upperBound);
        Range range2 = new Range(lowerBound, upperBound);
        int hash1 = range1.hashCode();
        int hash2 = range2.hashCode();
        assertEquals("Hashes should be equal with same ranges", hash1, hash2);
    }
}
