// Class    : CMPS 453
// Section  : 001
// Problem  : Decorator Programming Assignment
// Name     : McKelvy, James Markus
// CLID     : jmm0468

//  --* Certification of Authenticity *--
//  I certify that this assignment is entirely my own work,
//  with the exception of the files provided for the project
//  from the teacher.

// Decorator is an intermediate class for various types of decorations.
// Its constructor initializes a private data member the core object that
// it is wrapping
// When it receives a call to evaluate, it passes it on to its Expression
// data member
public class Decorator implements Expression {
    protected Expression e;

    // initialize core object
    Decorator() {
        e = new Function();
    }

    // let the Expression do all the work
    public int evaluate() {
        return e.evaluate();
    }

}
