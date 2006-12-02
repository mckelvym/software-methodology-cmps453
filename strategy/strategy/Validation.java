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

// interface for a validation type
// this validation needs to return true
// if the validation succeeded, and false
// if it did not. We will leave the implementation
// details up to child classes.
public interface Validation {
    public boolean isValid(String string);
}
