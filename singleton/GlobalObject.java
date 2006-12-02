// Class    : CMPS 453
// Section  : 001
// Problem  : Singleton Programming Assignment
// Name     : McKelvy, James Markus
// CLID     : jmm0468

//  --* Certification of Authenticity *--
//  I certify that this assignment is entirely my own work,
//  with the exception of the files provided for the project
//  from the teacher.

// allows only one instance of itself to be instanciated
public class GlobalObject {
    // the "one"
    private static GlobalObject globalObject = null;
    private int value;

    // this is private so it can only be called by this class
    private GlobalObject() {
        this.value = 0;
    }

    // if the private data member hasn't been instanciated, it does so
    // otherwise it returns the private data member
    public static GlobalObject getInstance() {
        if (globalObject == null) {
            globalObject = new GlobalObject();
        }
        return globalObject;
    }

    // get the value of the private data member
    public int getValue() {
        return globalObject.value;
    }

    // set the value of the private data member
    public void setValue(int val) {
        globalObject.value = val;
    }
}
