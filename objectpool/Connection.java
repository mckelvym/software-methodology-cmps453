// Class    : CMPS 453
// Section  : 001
// Problem  : Object Pool Programming Assignment
// Name     : McKelvy, James Markus
// CLID     : jmm0468

//  --* Certification of Authenticity *--
//  I certify that this assignment is entirely my own work,
//  with the exception of the files provided for the project
//  from the teacher.

// represents a connection within a system
public class Connection {
    // keeps track of the number of connections
    private static int totalConnections = 0;
    private int myid;

    // gives each connection a unique id
    public Connection() {
        myid = ++totalConnections;
    }

    // open this connection
    public void open() {
        System.out.println("Connection " + myid + " open.");
    }

    // close this connection
    public void close() {
        System.out.println("Connection " + myid + " close.");
    }

    // return this connection's unique id
    public int getId() {
        return myid;
    }
}
