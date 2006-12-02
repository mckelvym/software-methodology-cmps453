//Class    : CMPS 453
//Section  : 001
//Problem  : Programming Assignment #2
//Name     : McKelvy, James Markus
//CLID     : jmm0468

//--* Certification of Authenticity *--
//I certify that this assignment is entirely my own work.

//this class is meant to test the Square Class's methods

import junit.framework.TestCase;

public class SquareTest extends TestCase {

    private Square s;

    // here we want to test whether the square
    // constructor makes the correct square with
    // a value of 0
    public void testSquare() {
        s = new Square(0);
        assertEquals(0.0, s.getArea(), Math.pow(10, -20));
        assertEquals(0.0, s.getPerimeter(), Math.pow(10, -20));
    }

    // here we want to test whether we get the area
    // expected from the square's method.
    // It should return the value of the first parameter
    // multiplied by four, since it is assumed
    // to be a square with all sides equal.
    public void testGetArea() {
        s = new Square(5);
        assertEquals(25.0, s.getArea(), Math.pow(10, -20));
    }

    // here we want to test whether we get the perimeter
    // expected from the square's method.
    // It should return the value of the first parameter
    // multiplied by four since it is a square with
    // all sides being equal
    public void testGetPerimeter() {
        s = new Square(4);
        assertEquals(16.0, s.getPerimeter(), Math.pow(10, -20));
    }
}
