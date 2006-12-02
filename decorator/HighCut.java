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
 * A function that returns a random number in the range [0, max],
 * where max is specified in the constructor.
 */
public class HighCut extends Decorator {
    protected int maximum;

    /**
     * Creates this, with initial max.
     * Also initializes its core type to be used later
     */

    public HighCut(Expression expression, int max) {
        e = expression;
        maximum = max;
    }

    /**
     * Returns a number in the range [0, max] by delegating
     * to its core object
     */
    public int evaluate() {
        int result;

        result = e.evaluate();
        if (result > maximum)
            return maximum;

        return result;
    }
}
