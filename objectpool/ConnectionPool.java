// Class    : CMPS 453
// Section  : 001
// Problem  : Object Pool Programming Assignment
// Name     : McKelvy, James Markus
// CLID     : jmm0468

//  --* Certification of Authenticity *--
//  I certify that this assignment is entirely my own work,
//  with the exception of the files provided for the project
//  from the teacher.

// maintains a pool of connections so that we don't have to deal
// with the "cost" of creating and destroying connections
public class ConnectionPool {

    // this is used to make this class a singleton
    private static ConnectionPool instance = null;
    // limit the number of connections in the pool
    private int poolSize = 10;
    // the array of connections to be used
    private Connection connections[] = new Connection[poolSize];
    // keep track of which connections are available
    private boolean connection_used[] = new boolean[poolSize];

    // when instanciated, all connections have not been used yet
    private ConnectionPool() {
        for (int i = 0; i < poolSize; i++) {
            connection_used[i] = false;
        }
    }

    // this is for singleton behavior
    public static ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    // returns the first available connection, if it has been
    // instanciated, just open it and return it, if it has not
    // been instanciated, it is instanciated, opened, and returned,
    // if no connections are available, null is returned.
    public Connection acquire() {
        for (int i = 0; i < poolSize; i++) {
            if (!connection_used[i]) {
                connection_used[i] = true;
                if (connections[i] == null) {
                    connections[i] = new Connection();
                }
                connections[i].open();
                return connections[i];
            }
        }
        return null;
    }

    // "closes" the connection and sets the corresponding
    // element in the boolean array to false.
    public void release(Connection connection) {
        int id = connection.getId();
        for (int i = 0; i < poolSize; i++) {
            if (id == connections[i].getId()) {
                connection_used[i] = false;
                connections[i].close();
                break;
            }
        }
    }

}
