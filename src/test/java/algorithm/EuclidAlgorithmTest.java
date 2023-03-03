package algorithm;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class EuclidAlgorithmTest extends TestCase {

    EuclidAlgorithm euclidAlgorithm;

    @Before
    public void setUp(){
        euclidAlgorithm = new EuclidAlgorithm();
    }

    @Test
    public void testGreatestCommonDivisor1() {
        assertEquals(3, euclidAlgorithm.greatestCommonDivisor(105, 24));
    }

}