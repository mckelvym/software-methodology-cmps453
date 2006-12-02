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
 * Factory that simplifies compressing and decompressing of Rar
 */
public class RarFactory implements Factory {

    // helps get a new Rar compressor
    @Override
    public Compressor createCompressor() {
        // TODO Auto-generated method stub
        return new RarCompressor();
    }

    // helps get a new Rar decompressor
    @Override
    public Decompressor createDecompressor() {
        // TODO Auto-generated method stub
        return new RarDecompressor();
    }

}
