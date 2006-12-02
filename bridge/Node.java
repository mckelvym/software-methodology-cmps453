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
 * A stack node.
 */
public class Node {
    private int value;
    private Node next;

    public Node(int val, Node next) {
        value = val;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }
}
