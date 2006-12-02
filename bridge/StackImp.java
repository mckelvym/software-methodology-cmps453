// Class    : CMPS 453
// Section  : 001
// Problem  : Bridge Programming Assignment
// Name     : McKelvy, James Markus
// CLID     : jmm0468

//  --* Certification of Authenticity *--
//  I certify that this assignment is entirely my own work,
//  with the exception of the files provided for the project
//  from the teacher.

// interface from which the different implementation types inherit
public interface StackImp {
    public boolean isEmpty();

    public boolean isFull();

    public void push(int Val);

    public int pop();
}
