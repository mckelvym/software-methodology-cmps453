package cmps453;

// Class    : CMPS 453
// Section  : 001
// Problem  : Abstract Factory Programming Assignment
// Name     : McKelvy, James Markus
// CLID     : jmm0468

//  --* Certification of Authenticity *--
//  I certify that this assignment is entirely my own work,
//  with the exception of the files provided for the project
//  from the teacher.

/**
 * Capable of compressing in rar format.
 */
public class RarCompressor implements Compressor {
    @Override
    public void compress() {
        System.out.println("File compressed using Rar");
    }
}
