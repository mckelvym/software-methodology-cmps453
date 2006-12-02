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
 * Array-based implementation of a stack.
 */
public class ArrayImp implements StackImp {
    private int array[];
    private int sp;
    private int size;

    public ArrayImp() {
        this(10);
    }

    public ArrayImp(int size) {
        array = new int[size];
        this.size = size;
        sp = 0;
    }

    public void push(int val) {
        if (!isFull())
            array[sp++] = val;
    }

    public int pop() {
        if (isEmpty())
            return 0;
        else
            return array[--sp];
    }

    public boolean isEmpty() {
        return sp == 0;
    }

    public boolean isFull() {
        return sp == size;
    }
}
