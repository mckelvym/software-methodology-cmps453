// Class    : CMPS 453
// Section  : 001
// Problem  : Factory Method Programming Assignment
// Name     : McKelvy, James Markus
// CLID     : jmm0468

//  --* Certification of Authenticity *--
//  I certify that this assignment is entirely my own work,
//  with the exception of the files provided for the project
//  from the teacher.

// common factory interface for creating party members
public interface Factory {
    public President createPresident();

    public MinorityPartyCongressPerson createMinorityPartyCongressPerson();

    public AttorneyGeneral createAttorneyGeneral();
}
