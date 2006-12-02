package testing;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

    public static Test suite() {
        TestSuite suite = new TestSuite("Test for testing");
        //$JUnit-BEGIN$
        suite.addTestSuite(TestScores.class);
        suite.addTestSuite(TestAbstractTicTac.class);
        suite.addTestSuite(TestFileScoreHandler.class);
        //$JUnit-END$
        return suite;
    }

}
