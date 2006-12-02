// Class    : CMPS 453
// Section  : 001
// Problem  : Programming Assignment #3
// Name     : McKelvy, James Markus
// CLID     : jmm0468

//  --* Certification of Authenticity *--
//  I certify that this assignment is entirely my own work.

import shapes.Rectangle;
import fit.ColumnFixture;

public class RectangleFixture extends ColumnFixture {

    public float length;
    public float width;

    public float area() {
        Rectangle r = new Rectangle(length, width);
        return r.getArea();
    }

    public float perimeter() {
        Rectangle r = new Rectangle(length, width);
        return r.getPerimeter();
    }

}
