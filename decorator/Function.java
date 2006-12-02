// Class    : CMPS 453
// Section  : 001
// Problem  : Decorator Programming Assignment
// Name     : McKelvy, James Markus
// CLID     : jmm0468

//  --* Certification of Authenticity *--
//  I certify that this assignment is entirely my own work,
//  with the exception of the files provided for the project
//  from the teacher.

import java.util.Random;

/**
 * A function that returns a random number in the range [0, 29].
 */
// This is the core object
public class Function implements Expression {
    /**
     * Evaluates this function.
     */
    public int evaluate() {
        return new Random().nextInt(30);
    }
}
