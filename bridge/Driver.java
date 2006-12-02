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
 * Simple driver that tests the different stack implementations.
 */
public class Driver {
    public static void main(String[] args) {
        ArrayImp stack1 = new ArrayImp();
        Stack stack2 = new Stack(ImplementationType.ListImplementation);

        for (int i = 1; i < 16; i++) {
            stack1.push(i);
            stack2.push(i);
        }

        System.out.print("Array stack: ");
        for (int i = 1; i < 18; i++)
            System.out.print(stack1.pop() + "  ");
        System.out.print('\n');

        System.out.print("List stack:  ");
        for (int i = 1; i < 18; i++)
            System.out.print(stack2.pop() + "  ");
        System.out.print('\n');
    }
}
