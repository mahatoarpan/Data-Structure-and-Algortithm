package stack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PostfixToPrefixTest {

    PostfixToPrefix obj;

    @Before
    public void setup() {
        obj = new PostfixToPrefix();
    }
    @Test
    public void test1() {
        String input = "AB+CD-*";
        String expectedOutput = "*+AB-CD";

        Assert.assertEquals(expectedOutput, obj.postfixToPrefix(input));
    }
    @Test
    public void test2() {
        String input = "ABC/-AK/L-*";
        String expectedOutput = "*-A/BC-/AKL";

        Assert.assertEquals(expectedOutput, obj.postfixToPrefix(input));
    }
}
