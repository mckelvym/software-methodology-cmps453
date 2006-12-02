// Class    : CMPS 453
// Section  : 001
// Problem  : Bridge Programming Assignment
// Name     : McKelvy, James Markus
// CLID     : jmm0468

//  --* Certification of Authenticity *--
//  I certify that this assignment is entirely my own work,
//  with the exception of the files provided for the project
//  from the teacher.

// this is a wrapper class for a stack type
public class Stack {
    // private member keeps track of what type of stack implementation is being used
    private StackImp stack;

    // the stack reference is initialized depending upon the ImplementationType variable
    Stack(ImplementationType it) {
        if (it == ImplementationType.ArrayImplementation)
            stack = new ArrayImp();
        if (it == ImplementationType.ListImplementation)
            stack = new ListImp();
    }

    // wrapper function
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    // wrapper function
    public boolean isFull() {
        return stack.isFull();
    }

    // wrapper function
    public void push(int Val) {
        stack.push(Val);
    }

    // wrapper function
    public int pop() {
        return stack.pop();
    }
}
