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
 * Prints the state of the object being observered in octal format.
 */
public class OctObserver implements Observer {
    protected Subject subject;

    // attaches itself to its subject as an observer
    public OctObserver(Subject s) {
        subject = s;
        subject.attach(this);
    }

    public void update() {
        System.out.print("oct:  0" + Integer.toOctalString(subject.getState()) + '\n');
    }
}
