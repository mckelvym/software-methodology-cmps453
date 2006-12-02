// Class    : CMPS 453
// Section  : 001
// Problem  : Template Method Programming Assignment
// Name     : McKelvy, James Markus
// CLID     : jmm0468

//  --* Certification of Authenticity *--
//  I certify that this assignment is entirely my own work,
//  with the exception of the files provided for the project
//  from the teacher.

// implements a spell checker, methods common to all spell checkers
// are implemented here, and specialized methods for special spell checkers
// are implemented in child classes. This spell checker should not be used,
// but rather a more specific kind (a child of this one) should be used.
public class SpellChecker {

    // handles the spell checking task
    public void doIt() {
        removeControlCodes();
        convertToLowerCase();
        tokenizeInput();
        SortTheInput();
        collapseDuplicateEntries();
        diffWithDictionary();
        proposeCorrectSpellings();
    }

    // common function, moved to this class to eliminate redundancy
    private void removeControlCodes() {
        System.out.println("removeControlCodes:");
    }

    // common function, moved to this class to eliminate redundancy
    private void convertToLowerCase() {
        System.out.println("convertToLowerCase:");
    }

    // common function, moved to this class to eliminate redundancy
    private void tokenizeInput() {
        System.out.println("tokenizeInput:");
    }

    // common function, moved to this class to eliminate redundancy
    private void collapseDuplicateEntries() {
        System.out.println("collapseDuplicateEntries:");
    }

    // placeholder for child class
    protected void SortTheInput() {
        // leave this for the child classes to implement
    }

    // placeholder for child class
    protected void diffWithDictionary() {
        // leave this for the child classes to implement
    }

    // placeholder for child class
    protected void proposeCorrectSpellings() {
        // leave this for the child classes to implement
    }

}
