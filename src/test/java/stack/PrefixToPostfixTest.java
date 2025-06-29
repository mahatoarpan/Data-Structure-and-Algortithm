package stack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PrefixToPostfixTest {

    PrefixToPostfix obj;

    @Before
    public void setup(){
        obj = new PrefixToPostfix();
    }

    @Test
    public void test1(){
        String input = "*-A/BC-/AKL";
        String expectedOutput = "ABC/-AK/L-*";

        Assert.assertEquals(expectedOutput, obj.postfixToPrefix(input));
    }
}
