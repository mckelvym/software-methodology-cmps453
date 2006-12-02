// Class    : CMPS 453
// Section  : 001
// Problem  : Programming Assignment #3
// Name     : McKelvy, James Markus
// CLID     : jmm0468

//  --* Certification of Authenticity *--
//  I certify that this assignment is entirely my own work.

package shapes;

// This is the parent class of Parallelogram
public class Quadrilateral {

    // a quadrilateral is described by 4 sides which
    // may be of differing lengths
    private float s1;
    private float s2;
    private float s3;
    private float s4;

    // parameterized contructor, sets the lengths of each side
    public Quadrilateral(float s1, float s2, float s3, float s4) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.s4 = s4;
    }

    // returns the perimeter of the quadrilateral
    // just sum up the lengths of the sides
    public float getPerimeter() {
        return s1 + s2 + s3 + s4;
    }

    // this is currently not implemented
    //protected float getArea(){
    //	return 0;
    //}

    // protected function to get the length of a side,
    // this one is for s1
    protected float getS1() {
        return s1;
    }

    // protected function to get the length of a side,
    // this one is for s2
    protected float getS2() {
        return s2;
    }

    // protected function to get the length of a side,
    // this one is for s3
    protected float getS3() {
        return s3;
    }

    // protected function to get the length of a side,
    // this one is for s4
    protected float getS4() {
        return s4;
    }
}
