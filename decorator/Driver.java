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
 * Tests the various Function subclasses.
 */
public class Driver {
    public static void main(String[] args) {
        // initialize this with the Function as its core
        LowCut lc = new LowCut(new Function(), 7);
        // initialize this with the Function as its core
        HighCut hc = new HighCut(new Function(), 23);
        // A composite object with one main core, Function
        Decorator mp = new LowCut(new HighCut(new Function(), 20), 10);
        int i;

        for (i = 0; i < 25; i++)
            System.out.print(lc.evaluate() + " ");
        System.out.println();

        for (i = 0; i < 25; i++)
            System.out.print(hc.evaluate() + " ");
        System.out.println();

        for (i = 0; i < 25; i++)
            System.out.print(mp.evaluate() + " ");
        System.out.println();
    }
}
