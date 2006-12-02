//Class    : CMPS 453
//Section  : 001
//Problem  : Programming Assignment #2
//Name     : McKelvy, James Markus
//CLID     : jmm0468

//--* Certification of Authenticity *--
//I certify that this assignment is entirely my own work.

//this class is meant to test the Rectangle Class's methods

import junit.framework.TestCase;

public class RectangleTest extends TestCase {

    private Rectangle r;

    // here we want to test whether the rectangle
    // constructor makes the correct rectangle with
    // values of 0
    public void setUp() {
        r = new Rectangle(0, 0);
        assertEquals(0.0, r.getArea(), Math.pow(10, -20));
        assertEquals(0.0, r.getPerimeter(), Math.pow(10, -20));
        r = new Rectangle(3, 4);
    }

    // here we want to test whether we get the area
    // expected from the rectangle's method.
    // It should return the value of the first parameter
    // multiplied by the second, since it is assumed
    // to be base times the height.
    public void testGetArea() {
        assertEquals(12.0, r.getArea(), Math.pow(10, -20));
    }

    // here we want to test whether we get the perimeter
    // expected from the rectangle's method.
    // It should return the value of the first parameter
    // multiplied by two, plus the second parameter multiplied
    // by two, since it is a rectangle with opposite sides
    // being equal
    public void testGetPerimeter() {
        assertEquals(14.0, r.getPerimeter(), Math.pow(10, -20));
    }
}
