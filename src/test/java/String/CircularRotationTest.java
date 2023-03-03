package String;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CircularRotationTest {

    private CircularRotation circularRotation;

    @Before
    public void setUp() {
        circularRotation = new CircularRotation();
    }

    @Test
    public void testIsCircularRotated_Pass1() {
        String s1 = "ACTGACG";
        String s2 = "TGACGAC";

        Assert.assertTrue(circularRotation.isCircularRotated(s1, s2));
    }

    @Test
    public void testIsCircularRotated_Pass2() {
        String s1 = "ARPAN";
        String s2 = "ANARP";

        Assert.assertTrue(circularRotation.isCircularRotated(s1, s2));
    }

    @Test
    public void testIsCircularRotated_Fail1() {
        String s1 = "ARPANM";
        String s2 = "ANARP";

        Assert.assertFalse(circularRotation.isCircularRotated(s1, s2));
    }
}