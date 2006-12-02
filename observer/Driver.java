// Class    : CMPS 453
// Section  : 001
// Problem  : Observer Programming Assignment
// Name     : McKelvy, James Markus
// CLID     : jmm0468

//  --* Certification of Authenticity *--
//  I certify that this assignment is entirely my own work,
//  with the exception of the files provided for the project
//  from the teacher.

import java.util.Scanner;

/**
 * Calls the Subject.setState method, which should trigger a
 * reaction from the observers.
 */
public class Driver {
    public static void main(String[] args) {
        // create a new subject
        Subject subj = new Subject();

        // create new observers that register themselves with the
        // subject by "attaching" themselves to it
        HexObserver hex = new HexObserver(subj);
        OctObserver oct = new OctObserver(subj);
        RomanObserver roman = new RomanObserver(subj);

        int value = 0;
        Scanner in = new Scanner(System.in);

        System.out.print("Input integer (-1 to exit): ");
        value = in.nextInt();
        while (value != -1) {
            subj.setState(value);
            System.out.print("\nInput integer (-1 to exit): ");
            value = in.nextInt();
        }
    }
}
