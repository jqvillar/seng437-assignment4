package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Test;

public class RangeCombineTest {

    private static final int DEFAULT_TIMEOUT = 2000;
    private static final double DEFAULT_EPSILON = 0.000000001d;
    private Range range1;
    private Range range2;
    private Range expectedRange;
    private Range actualRange;

    public RangeCombineTest() {
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void bothRangeNull() {
        range1 = null;
        range2 = null;
        expectedRange = null;
        actualRange = Range.combine(range1, range2);
        assertEquals("Two null ranges not combined to null range", expectedRange, actualRange);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void sameRanges() {
        range1 = new Range(-1, 1);
        range2 = new Range(-1, 1);
        expectedRange = new Range(-1, 1);
        actualRange = Range.combine(range1, range2);
        assertEquals("Same ranges, lower bound not expected", 
                     expectedRange.getLowerBound(), 
                     actualRange.getLowerBound(), 
                     DEFAULT_EPSILON);
        assertEquals("Same ranges, upper bound not expected", 
                     expectedRange.getUpperBound(), 
                     actualRange.getUpperBound(), 
                     DEFAULT_EPSILON);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void rangesIntersectingButNotInclusive(){
        range1 = new Range(-1, 1);
        range2 = new Range(0, 2);
        expectedRange = new Range(-1, 2);
        actualRange = Range.combine(range1, range2);
        assertEquals("Ranges overlapping, lower bound not expected", 
                     expectedRange.getLowerBound(), 
                     actualRange.getLowerBound(), 
                     DEFAULT_EPSILON);
        assertEquals("Ranges overlapping, upper bound not expected", 
                     actualRange.getUpperBound(), 
                     expectedRange.getUpperBound(), 
                     DEFAULT_EPSILON);

        range1 = new Range(0, 2);
        range2 = new Range(-1, 1);
        expectedRange = new Range(-1, 2);
        actualRange = Range.combine(range1, range2);
        assertEquals("Ranges overlapping, lower bound not expected", 
                     expectedRange.getLowerBound(), 
                     actualRange.getLowerBound(), 
                     DEFAULT_EPSILON);
        assertEquals("Ranges overlapping, upper bound not expected", 
                     expectedRange.getUpperBound(), 
                     actualRange.getUpperBound(), 
                     DEFAULT_EPSILON);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void rangesNotOverlapping(){
        range1 = new Range(-2, -1);
        range2 = new Range(1, 2);
        expectedRange = new Range(-2, 2);
        actualRange = Range.combine(range1, range2);
        assertEquals("Ranges not overlapping, lower bound not expected", 
                     expectedRange.getLowerBound(), 
                     actualRange.getLowerBound(), 
                     DEFAULT_EPSILON);
        assertEquals("Ranges not overlapping, upper bound not expected", 
                     expectedRange.getUpperBound(), 
                     actualRange.getUpperBound(), 
                     DEFAULT_EPSILON);

        range1 = new Range(1, 2);
        range2 = new Range(-2, -1);
        expectedRange = new Range(-2, 2);
        actualRange = Range.combine(range1, range2);
        assertEquals("Ranges overlapping, lower bound not expected", 
                     expectedRange.getLowerBound(), 
                     actualRange.getLowerBound(), 
                     DEFAULT_EPSILON);
        assertEquals("Ranges overlapping, upper bound not expected", 
                     expectedRange.getUpperBound(), 
                     actualRange.getUpperBound(), 
                     DEFAULT_EPSILON);
    }

    @Test(timeout = DEFAULT_TIMEOUT)
    public void rangesEnclosing() {
        range1 = new Range(-2, 2);
        range2 = new Range(-1, 1);
        expectedRange = new Range(-2, 2);
        actualRange = Range.combine(range1, range2);
        assertEquals("Ranges enclosing, lower bound not expected", 
                     expectedRange.getLowerBound(), 
                     actualRange.getLowerBound(), 
                     DEFAULT_EPSILON);
        assertEquals("Ranges enclosing, upper bound not expected", 
                     expectedRange.getUpperBound(), 
                     actualRange.getUpperBound(), 
                     DEFAULT_EPSILON);

        range1 = new Range(-1, 1);
        range2 = new Range(-2, 2);
        expectedRange = new Range(-2, 2);
        actualRange = Range.combine(range1, range2);
        assertEquals("Ranges enclosing, lower bound not expected", 
                     expectedRange.getLowerBound(), 
                     actualRange.getLowerBound(), 
                     DEFAULT_EPSILON);
        assertEquals("Ranges enclosing, upper bound not expected", 
                     expectedRange.getUpperBound(), 
                     actualRange.getUpperBound(), 
                     DEFAULT_EPSILON);
    }
}
