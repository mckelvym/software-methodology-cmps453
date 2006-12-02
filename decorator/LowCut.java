// Class    : CMPS 453
// Section  : 001
// Problem  : Decorator Programming Assignment
// Name     : McKelvy, James Markus
// CLID     : jmm0468

//  --* Certification of Authenticity *--
//  I certify that this assignment is entirely my own work,
//  with the exception of the files provided for the project
//  from the teacher.

/**
 * A function that returns a random number in the range [min, 29],
 * where min is specified in the constructor.
 */
public class LowCut extends Decorator {
    protected int minimum;

    /**
     * Creates this, with initial min.
     * Also initializes its core type to be used later
     */
    public LowCut(Expression expression, int min) {
        e = expression;
        minimum = min;
    }

    /**
     * Returns a random number in the range [min, 29] by delegating
     * to its core object
     */
    public int evaluate() {
        int result;

        result = e.evaluate();
        if (result < minimum)
            return minimum;

        return result;
    }
}
