//Class    : CMPS 453
//Section  : 001
//Problem  : Programming Assignment #2
//Name     : McKelvy, James Markus
//CLID     : jmm0468

//--* Certification of Authenticity *--
//I certify that this assignment is entirely my own work.

//this class is meant to test the Quadrilateral Class's methods

import junit.framework.TestCase;

public class QuadrilateralTest extends TestCase {

    private Quadrilateral q;

    protected void setUp() throws Exception {
        q = new Quadrilateral(0, 0, 0, 0);
        assertEquals(0.0, q.getPerimeter(), Math.pow(10, -20));
        q = new Quadrilateral(4, 5, 2, 8);
    }

    // here we want to test whether we get the perimeter
    // expected from the Quadrilateral's method.
    // It should return the value of all the parameters summed
    // together since all sides aren't equal
    public void testGetPerimeter() {
        assertEquals(19.0, q.getPerimeter(), Math.pow(10, -20));
    }
}
