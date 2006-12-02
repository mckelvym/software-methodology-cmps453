// Class    : CMPS 453
// Section  : 001
// Problem  : Strategy Programming Assignment
// Name     : McKelvy, James Markus
// CLID     : jmm0468

//  --* Certification of Authenticity *--
//  I certify that this assignment is entirely my own work,
//  with the exception of the files provided for the project
//  from the teacher.

package strategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Receives and validates user input based on specified type by delegating
 * the task to the Validation interface's subclasses.
 */
public class DataEntry {
    /**
     * Type of expected input. Will be a polymorphed version
     * of this interface, based upon which algorithm is chosen
     */
    private Validation type;

    /**
     * Prompts the user for the type of DataEntry dialog to create
     * and creates and displays the specified dialog type.
     *
     * @param args command line parameters
     */
    public static void main(String[] args) {
        final String PROMPT_MSG = "Input type [ (n)umber, (u)pper, (l)ower, e(x)it ]: ";

        String answer;
        DataEntry dialog = new DataEntry();
        BufferedReader reader;

        try {
            System.out.print(PROMPT_MSG);
            reader = new BufferedReader(new InputStreamReader(System.in));
            answer = reader.readLine();
            while (answer != null && !answer.equals("x")) {
                dialog.setValidationType(answer);
                dialog.interact();
                System.out.print(PROMPT_MSG);
                answer = reader.readLine();
            }
        } catch (IOException exception) {
            handleException(exception);
        }
    }

    /**
     * May be called to handle any exceptions that occur.
     *
     * @param exception exception
     */
    private static void handleException(Exception exception) {
        System.out.println("Exception: " + exception.getMessage());
    }

    /**
     * Sets the validation type for this dialog.
     *
     * @param ch validation type; must be 'n', 'u', or 'l'.
     *           The correct Validation subclass is chosen and instanciated
     *           for the Validation variable.
     */
    public void setValidationType(String ch) {
        if (ch.equals("n"))
            type = new ValidationDigit();
        else if (ch.equals("u"))
            type = new ValidationUpper();
        else if (ch.equals("l"))
            type = new ValidationLower();
    }

    /**
     * Prompts user for input, then validates the input, delegating
     * to the Validation object.
     */
    public void interact() {
        final String BAD_ANSWER_MSG = "*** bad ***";  // Displayed when invalid input is entered
        final String GOOD_ANSWER_MSG = "*** good ***"; // Displayed when valid input is entered
        final String PROMPT_MSG = "Prompt: ";     // The prompt requesting user input

        String answer; // holds user input
        BufferedReader reader; // reads user input

        reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print(PROMPT_MSG);
            answer = reader.readLine();

            while (!(answer.equals("quit") || answer.equals(""))) {
                if (type.isValid(answer))
                    System.out.println(GOOD_ANSWER_MSG);
                else
                    System.out.println(BAD_ANSWER_MSG);

                System.out.print(PROMPT_MSG);
                answer = reader.readLine();
            }
        } catch (IOException exception) {
            handleException(exception);
        }
    }
}
