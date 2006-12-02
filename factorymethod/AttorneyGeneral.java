// Class    : CMPS 453
// Section  : 001
// Problem  : Factory Method Programming Assignment
// Name     : McKelvy, James Markus
// CLID     : jmm0468

//  --* Certification of Authenticity *--
//  I certify that this assignment is entirely my own work,
//  with the exception of the files provided for the project
//  from the teacher.

// creates an attorney general with the specified party name
// and has its own party line
class AttorneyGeneral extends FederalFraudvillian {
    public AttorneyGeneral(String party) {
        super(party);
    }

    public void partyLine() {
        System.out.println(party + ": see no evil");
    }
};
