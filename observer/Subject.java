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
 * An object that contains a state.  The observers are
 * notified of any changes to state.
 */
public class Subject {
    private int subjectState;
    private int numOfObservers = 0;
    private int maxObservers = 10;
    private Observer observer[] = new Observer[maxObservers];

    // allows observers to attach themselves to this object
    // provided it has room for more observers
    public void attach(Observer o) {
        if (numOfObservers < maxObservers) {
            observer[numOfObservers++] = o;
        }
    }

    // this tells all the observers of the subject to update themselves
    public void notifyListeners() {
        for (int i = 0; i < numOfObservers; i++) {
            observer[i].update();
        }
    }

    // used by an observer, it requests the data it needs
    public int getState() {
        return subjectState;
    }

    // when this subject's state has changed, the observers need to
    // be notified that this has happened
    public void setState(int val) {
        subjectState = val;
        notifyListeners();
    }
}
