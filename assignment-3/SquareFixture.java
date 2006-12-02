// Class    : CMPS 453
// Section  : 001
// Problem  : Programming Assignment #3
// Name     : McKelvy, James Markus
// CLID     : jmm0468

//  --* Certification of Authenticity *--
//  I certify that this assignment is entirely my own work.

import shapes.Square;
import fit.ColumnFixture;

public class SquareFixture extends ColumnFixture {

    public float length;

    public float area() {
        Square s;

        s = new Square(length);

        return s.getArea();
    }

    public float perimeter() {
        Square s;

        s = new Square(length);

        return s.getPerimeter();
    }

}
