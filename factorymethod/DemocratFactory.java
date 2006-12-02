// Class    : CMPS 453
// Section  : 001
// Problem  : Factory Method Programming Assignment
// Name     : McKelvy, James Markus
// CLID     : jmm0468

//  --* Certification of Authenticity *--
//  I certify that this assignment is entirely my own work,
//  with the exception of the files provided for the project
//  from the teacher.

// a factory for creating democrat party members
public class DemocratFactory implements Factory {

    private String partyName = "Democrat";

    public AttorneyGeneral createAttorneyGeneral() {
        return new AttorneyGeneral(partyName);
    }

    public MinorityPartyCongressPerson createMinorityPartyCongressPerson() {
        return new MinorityPartyCongressPerson(partyName);
    }

    public President createPresident() {
        return new President(partyName);
    }

}
