// Class    : CMPS 453
// Section  : 001
// Problem  : Singleton Programming Assignment
// Name     : McKelvy, James Markus
// CLID     : jmm0468

//  --* Certification of Authenticity *--
//  I certify that this assignment is entirely my own work,
//  with the exception of the files provided for the project
//  from the teacher.

// tests the singleton class to see if it functions correctly
public class Driver {

    public static void main(String[] args) {
        Driver driver = new Driver();
        driver.foo();
        driver.bar();
        System.out.println("main: globalObject's value is " + GlobalObject.getInstance().getValue());
    }

    private void foo() {
        System.out.println("foo: globalObject's value is " + GlobalObject.getInstance().getValue());
    }

    void bar() {
        GlobalObject.getInstance().setValue(42);
        System.out.println("bar: globalObject's value is " + GlobalObject.getInstance().getValue());
    }
}
