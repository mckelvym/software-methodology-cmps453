// Class    : CMPS 453
// Section  : 001
// Problem  : Bridge Programming Assignment
// Name     : McKelvy, James Markus
// CLID     : jmm0468

//  --* Certification of Authenticity *--
//  I certify that this assignment is entirely my own work,
//  with the exception of the files provided for the project
//  from the teacher.

/**
 * List implementation of a stack.
 */
public class ListImp implements StackImp {
    private Node head;

    public ListImp() {
        head = null;
    }

    public void push(int val) {
        head = new Node(val, head);
    }

    public int pop() {
        if (isEmpty())
            return 0;
        int val = head.getValue();
        head = head.getNext();
        return val;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean isFull() {
        return false;
    }
}
