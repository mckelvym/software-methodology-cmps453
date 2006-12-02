// Class    : CMPS 453
// Section  : 001
// Problem  : Factory Method Programming Assignment
// Name     : McKelvy, James Markus
// CLID     : jmm0468

//  --* Certification of Authenticity *--
//  I certify that this assignment is entirely my own work,
//  with the exception of the files provided for the project
//  from the teacher.

import java.io.IOException;

// tests the factory
public class Driver {
    public static void main(String[] args) {
        FederalFraudvillian moralMisfits[] = new FederalFraudvillian[10];
        int in;
        int i;
        int total = 0;
        Factory factory = new RepublicanFactory();

        try {
            System.out.print("President(1); Attorney General (2); Minority Party (3) Go(0): ");
            in = (char) System.in.read();
            while (in != '0') {
                if (in == '1')
                    moralMisfits[total++] = factory.createPresident();
                else if (in == '2')
                    moralMisfits[total++] = factory.createAttorneyGeneral();
                else if (in == '3')
                    moralMisfits[total++] = factory.createMinorityPartyCongressPerson();

                if (in == '1' || in == '2' || in == '3')
                    System.out.print("President(1); Attorney General (2); Minority Party (3) Go(0): ");
                in = (char) System.in.read();
            }

            for (i = 0; i < total; i++)
                moralMisfits[i].partyLine();
        } catch (IOException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
