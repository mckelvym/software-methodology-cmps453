// Class    : CMPS 453
// Section  : 001
// Problem  : Programming Assignment #3
// Name     : McKelvy, James Markus
// CLID     : jmm0468

//  --* Certification of Authenticity *--
//  I certify that this assignment is entirely my own work.

import shapes.Parallelogram;
import fit.ColumnFixture;

public class ParallelogramFixture extends ColumnFixture {

    public float length;
    public float width;
    public float perpendicular;

    public float area() {
        Parallelogram p = new Parallelogram(width, length, perpendicular);
        return p.getArea();
    }

    public float perimeter() {
        Parallelogram p = new Parallelogram(width, length, perpendicular);
        return p.getPerimeter();
    }

}
