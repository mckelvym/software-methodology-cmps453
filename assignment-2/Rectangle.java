// Class    : CMPS 453
// Section  : 001
// Problem  : Programming Assignment #2
// Name     : McKelvy, James Markus
// CLID     : jmm0468

//  --* Certification of Authenticity *--
//  I certify that this assignment is entirely my own work.

// This is the child class of Parallelogram
// This is the parent class of Square
public class Rectangle extends Parallelogram {

    // This parameterized constructor takes two parameters which
    // describe the length of the base and the length of the height.
    // This constructor utilizes its parent's constructor, which
    // in turn utilizes its parent's constructor, basically
    // making a call to the Quadrilateral constructor.
    Rectangle(float base, float height) {
        super(base, height, height);
    }

    // If you call this class' getPerimeter() method, the parent's
    // method is called and utilized.

    // If you call this class' getArea() method, the parent's
    // method is called and utilized.
}
