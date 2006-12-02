// Class    : CMPS 453
// Section  : 001
// Problem  : Programming Assignment #2
// Name     : McKelvy, James Markus
// CLID     : jmm0468

//  --* Certification of Authenticity *--
//  I certify that this assignment is entirely my own work.

// This is the child class of Rectangle
// Currently this class has no children
// (but that may change at any time ;)
public class Square extends Rectangle {

    // This parameterized constructor takes one parameter which
    // describes the length of a side of the square.
    // This constructor utilizes its parent's constructor, which
    // in turn utilizes its parent's constructor, which
    // in turn utilizes its parent's constructor, basically
    // making a call to the great grand daddy Quadrilateral constructor.
    Square(float side) {
        super(side, side);
    }

    // If you call this class' getPerimeter() method, the parent's
    // method is called and utilized.

    // If you call this class' getArea() method, the parent's
    // method is called and utilized.
}
