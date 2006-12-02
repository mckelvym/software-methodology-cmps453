// Class    : CMPS 453
// Section  : 001
// Problem  : Programming Assignment #3
// Name     : McKelvy, James Markus
// CLID     : jmm0468

//  --* Certification of Authenticity *--
//  I certify that this assignment is entirely my own work.

package shapes;

// This is the child class of Quadrilateral
// This is the parent class of Rectangle
public class Parallelogram extends Quadrilateral {

    // This classes uses its parent to describe the lengths
    // of its sides, but also has a height dimension which
    // is not available in its parent
    private float height;

    // This parameterized constructor takes three parameters which
    // describe the length of base and its parallel side, a leg
    // and its parallel side, as well as the height of the parallelogram.
    // This constructor utilizes its parent's constructor and sets its
    // height value.
    public Parallelogram(float base, float leg, float height) {
        super(base, leg, base, leg);
        this.height = height;
    }

    // This method is not implemented in the parent, so we implement it
    // here. It is assumed the s1 is the base of the parallelogram and that
    // the height is a line that is perpendicular to the base (s1).
    // Thus, the area is simply calculated by multiplying the base times
    // the height, similar to this class' child.
    public float getArea() {
        return getS1() * height;
    }

    // If you call this class' getPerimeter() method, the parent's
    // method is called and utilized.
}
