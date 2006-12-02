// Class    : CMPS 453
// Section  : 001
// Problem  : Factory Method Programming Assignment
// Name     : McKelvy, James Markus
// CLID     : jmm0468

//  --* Certification of Authenticity *--
//  I certify that this assignment is entirely my own work,
//  with the exception of the files provided for the project
//  from the teacher.

// a parent class to party members
// they must have a party line
// also sets the party affiliation
public abstract class FederalFraudvillian {
    protected String party;

    public FederalFraudvillian() {
        party = "Democrat";
    }

    public FederalFraudvillian(String pp) {
        party = pp;
    }

    protected abstract void partyLine();
}
