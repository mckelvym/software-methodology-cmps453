// Class    : CMPS 453
// Section  : 001
// Problem  : Programming Assignment #2
// Name     : McKelvy, James Markus
// CLID     : jmm0468

//  --* Certification of Authenticity *--
//  I certify that this assignment is entirely my own work.

// this class is meant to test the Parallelogram Class's methods

import junit.framework.TestCase;

public class ParallelogramTest extends TestCase {

    private Parallelogram p;

    // here we want to test whether the parallelogram
    // constructor makes the correct parallelogram with
    // values of 0
    public void testParallelogram() {
        p = new Parallelogram(0, 0, 0);
        assertEquals(0.0, p.getArea(), Math.pow(10, -20));
        assertEquals(0.0, p.getPerimeter(), Math.pow(10, -20));
    }

    // here we want to test whether we get the area
    // expected from the parallelogram's method.
    // It should return the value of the first parameter
    // multiplied by the third, since it is assumed
    // to be base times the height.
    public void testGetArea() {
        p = new Parallelogram(5, 4, 2);
        assertEquals(10.0, p.getArea(), Math.pow(10, -20));
    }

    // here we want to test whether we get the perimeter
    // expected from the parallelogram's method.
    // It should return the value of the first parameter
    // multiplied by two, plus the second parameter multiplied
    // by two, since it is assumed that opposite sides are
    // equal and parallel
    public void testGetPerimeter() {
        p = new Parallelogram(5, 4, 2);
        assertEquals(18.0, p.getPerimeter(), Math.pow(10, -20));
    }
}
