package stack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PostfixToInfixTest {
    PostfixToInfix obj;

    @Before
    public void setip() {
        obj = new PostfixToInfix();
    }

    @Test
    public void test1() {
        String input = "abc+*d/";
        String expectedOutput = "((a*(b+c))/d)";

        Assert.assertEquals(expectedOutput, obj.postfixToInfix(input));
    }

    @Test
    public void test2() {
        String input = "ab*c+";
        String expectedOutput = "((a*b)+c)";

        Assert.assertEquals(expectedOutput, obj.postfixToInfix(input));
    }
}
