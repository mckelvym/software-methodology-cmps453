// Class    : CMPS 453
// Section  : 001
// Problem  : Template Method Programming Assignment
// Name     : McKelvy, James Markus
// CLID     : jmm0468

//  --* Certification of Authenticity *--
//  I certify that this assignment is entirely my own work,
//  with the exception of the files provided for the project
//  from the teacher.

/**
 * Runs the SimpleSpellChecker and the SohphisticatedSpellChecker
 */
public class Driver {
    public static void main(String[] args) {
        SpellChecker okay = new SimpleSpellChecker();
        SpellChecker good = new SophisticatedSpellChecker();

        System.out.println("********** Simple Spell Check **********");
        okay.doIt();

        System.out.println("********** Sophisticated Spell Check **********");
        good.doIt();
    }
}
