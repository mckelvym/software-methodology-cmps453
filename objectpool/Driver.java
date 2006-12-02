// Class    : CMPS 453
// Section  : 001
// Problem  : Object Pool Programming Assignment
// Name     : McKelvy, James Markus
// CLID     : jmm0468

//  --* Certification of Authenticity *--
//  I certify that this assignment is entirely my own work,
//  with the exception of the files provided for the project
//  from the teacher.

// test the connection pool class
public class Driver {
    public static void main(String[] args) {
        Connection connection1;
        Connection connection2;

        // the connection pool is used to acquire and release connections
        for (int i = 0; i < 10; i++) {
            connection1 = ConnectionPool.getInstance().acquire();
            connection2 = ConnectionPool.getInstance().acquire();
            // do something with the open connections.
            ConnectionPool.getInstance().release(connection1);
            ConnectionPool.getInstance().release(connection2);
        }
    }
}
