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

import java.io.IOException;

/**
 * Enter capital Z for zip file, capital R for rar file, capital Q to quit.
 */
public class Main {
    public static void main(final String[] args) {
        char choice;
        // Wrapper for various compression/decompression schemes
        Factory factory;

        System.out.print("(Z)ip; (R)ar; (Q)uit: ");

        try {
            choice = (char) System.in.read();
        } catch (final IOException e) {
            System.out.println("\nException occurred: " + e.getMessage());
            return;
        }

        // get the right factory for compression/decompression
        switch (choice) {
            case 'Z':
                factory = new ZipFactory();
                break;

            case 'R':
                factory = new RarFactory();
                break;

            default:
                System.out.println("Quitting");
                return;
        }

        processFile(factory);
    }

    /**
     * Opens a file, decompresses for editing, edits the file contents, then
     * compresses the file again for saving.
     */
    private static void processFile(final Factory method) {
        // uses the factory to delegate creating compressors/decompressors

        // creates the correct compressor and compresses using it's own scheme
        method.createCompressor().compress();
        System.out.println("File contents modified");
        // creates the correct decompressor and decompresses using it's own
        // scheme
        method.createDecompressor().decompress();
    }
}
