import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests extends TestSuite {
    public static Test suite() {
        TestSuite suite = new TestSuite("Test for default package");
        //$JUnit-BEGIN$
        suite.addTestSuite(QuadrilateralTest.class);
        suite.addTestSuite(ParallelogramTest.class);
        suite.addTestSuite(RectangleTest.class);
        suite.addTestSuite(SquareTest.class);
        //$JUnit-END$
        return suite;
    }
}
