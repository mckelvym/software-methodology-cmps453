// Class    : CMPS 453
// Section  : 001
// Problem  : Template Method Programming Assignment
// Name     : McKelvy, James Markus
// CLID     : jmm0468

//  --* Certification of Authenticity *--
//  I certify that this assignment is entirely my own work,
//  with the exception of the files provided for the project
//  from the teacher.

// implements a simple spell checker, methods common to all spell checkers
// are implemented in parent SpellChecker class, and specialized methods
// to this type of spell checker are implemented here.
public class SimpleSpellChecker extends SpellChecker {
    protected void SortTheInput() {
        System.out.println("bubbleSortTheInput:");
    }

    protected void diffWithDictionary() {
        System.out.println("diffWithUnixDictionary:");
    }

    protected void proposeCorrectSpellings() {
        System.out.println("proposeCorrectSpellings:");
        System.out.println("   convert token to phonetic spelling");
        System.out.println("   generate all permutations");
        System.out.println("   use eenie-meenie to pick the best choices");
    }
}
