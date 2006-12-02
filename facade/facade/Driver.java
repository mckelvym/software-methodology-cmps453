// Class    : CMPS 453
// Section  : 001
// Problem  : Programming Assignment #4 (facade)
// Name     : McKelvy, James Markus
// CLID     : jmm0468

//  --* Certification of Authenticity *--
//  I certify that this assignment is entirely my own work,
//  with the exception of the files provided for the project
//  from the teacher.

package facade;

/**
 * Creates and destroys a window.
 */
public class Driver {
    public static void main(String[] args) {
        SimpleWindow mysimplewindow = new SimpleWindow();
        mysimplewindow.create("My Simple Window");
        mysimplewindow.show();
        mysimplewindow.destroy();
    }
}
