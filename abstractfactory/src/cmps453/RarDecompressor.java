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
 * Capable of decompressing rar files.
 */
public class RarDecompressor implements Decompressor {
    @Override
    public void decompress() {
        System.out.println("File decompressed using Rar");
    }
}
