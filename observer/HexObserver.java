// Class    : CMPS 453
// Section  : 001
// Problem  : Observer Programming Assignment
// Name     : McKelvy, James Markus
// CLID     : jmm0468

//  --* Certification of Authenticity *--
//  I certify that this assignment is entirely my own work,
//  with the exception of the files provided for the project
//  from the teacher.

/**
 * Prints the state of the object being observered in hex format.
 */
public class HexObserver implements Observer {
    protected Subject subject;

    // attaches itself to its subject as an observer
    public HexObserver(Subject s) {
        subject = s;
        subject.attach(this);
    }

    public void update() {
        System.out.print("hex: 0x" + Integer.toHexString(subject.getState()) + '\n');
    }
}
