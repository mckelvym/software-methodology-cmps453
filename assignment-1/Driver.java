// Class    : CMPS 453
// Section  : 001
// Problem  : Programming Assignment #1
// Name     : McKelvy, James Markus
// CLID     : jmm0468

//  --* Certification of Authenticity *--
//  I certify that this assignment is entirely my own work.

// This is a driver class for the project that takes input arguments
// and does something *poof*
public class Driver {

    public static void main(String[] args) {
        // lets make an instance of ourself, shall we?
        Driver d = new Driver();

        // for a square, there should be two arguments:
        // the word "square" (any case) follwed by a number (fp or int)
        if (args.length == 2 && args[0].toLowerCase().equals("square")) {
            d.makeSquare(Float.parseFloat(args[1]));
        }
        // for a rectange, there should be three arguments:
        // the word "rectangle" (any case) followed by 2 numbers (fp or int)
        else if (args.length == 3 && args[0].toLowerCase().equals("rectangle")) {
            d.makeRectangle(Float.parseFloat(args[1]), Float.parseFloat(args[2]));
        }
        // for a parallelogram, there should be four arguments:
        // the word "parallelogram" (any case) followed by 3 numbers (fp or int)
        else if (args.length == 4 && args[0].toLowerCase().equals("parallelogram")) {
            d.makeParallelogram(Float.parseFloat(args[1]), Float.parseFloat(args[2]), Float.parseFloat(args[3]));
        } else {
            d.out("No arguments or incorrect format. Try again.");
            d.out("Use one of the following commands:");
            d.out("java Driver square [side]");
            d.out("java Driver rectangle [base] [height]");
            d.out("java Driver parallelogram [base] [leg] [perpendicular]");
        }
    }

    // makes a square and prints some info about it
    private void makeSquare(float value1) {
        // create a new square object
        Square s = new Square(value1);
        // now print some data about it
        out("The Square you specified with side length " + value1 + " has:");
        out("- Perimeter of " + s.getPerimeter());
        out("- Area of " + s.getArea());
    }

    // makes a rectangle and prints some info about it
    private void makeRectangle(float value1, float value2) {
        // create a new rectangle object
        Rectangle r = new Rectangle(value1, value2);
        // now print some data about it
        out("The Rectangle you specified with length " + value1 + ", height " + value2 + " has:");
        out("- Perimeter of " + r.getPerimeter());
        out("- Area of " + r.getArea());
    }

    // makes a parallelogram and prints some info about it
    private void makeParallelogram(float value1, float value2, float value3) {
        // create a new parallelogram object
        Parallelogram p = new Parallelogram(value1, value2, value3);
        // now print some data about it
        out("The Parallelogram you specified with base " + value1 + ", legs " + value2 + ", and height (perpendicular) " + value3 + " has:");
        out("- Perimeter of " + p.getPerimeter());
        out("- Area of " + p.getArea());
    }

    // simple private function to help save some typing
    // and some whitespace
    private void out(Object obj) {
        System.out.println(obj);
    }
}
