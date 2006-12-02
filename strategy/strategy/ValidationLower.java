// Class    : CMPS 453
// Section  : 001
// Problem  : Strategy Programming Assignment
// Name     : McKelvy, James Markus
// CLID     : jmm0468

//  --* Certification of Authenticity *--
//  I certify that this assignment is entirely my own work,
//  with the exception of the files provided for the project
//  from the teacher.

package strategy;

//this is a child of the validation interface
//this specializes in determining if the string
//is valid by comparing it against lowercase letters.
//it's isValid() method returns true if this
//condition is met, false otherwise
public class ValidationLower implements Validation {
    public boolean isValid(String input) {
        boolean valid = true;
        for (int i = 0; i < input.length(); i++) {
            if (!(input.charAt(i) >= 'a' && input.charAt(i) <= 'z')) {
                valid = false;
                break;
            }
        }
        return valid;
    }
}
