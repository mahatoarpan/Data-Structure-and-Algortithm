package String;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RotateStringTest {

    RotateString obj;

    @Before
    public void setup() {
        obj = new RotateString();
    }

    @Test
    public void test1() {
        String input1 = "abcde";
        String input2 = "cdeab";

        Assert.assertEquals(true, obj.rotateString(input1, input2));
    }
}
