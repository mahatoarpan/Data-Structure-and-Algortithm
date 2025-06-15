package String;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveOutermostParenthesesTest {

    RemoveOutermostParentheses obj;

    @Before
    public void setup() {
        obj = new RemoveOutermostParentheses();
    }

    @Test
    public void test1() {
        String input = "(()())(())";
        String expectedOutput = "()()()";

        Assert.assertEquals(expectedOutput, obj.removeOutermostParentheses(input));
    }

    @Test
    public void test2() {
        String input = "(()())(())(()(()))";
        String expectedOutput = "()()()()(())";

        Assert.assertEquals(expectedOutput, obj.removeOutermostParentheses(input));
    }

    @Test
    public void test3() {
        String input = "()()";
        String expectedOutput = "";

        Assert.assertEquals(expectedOutput, obj.removeOutermostParentheses(input));
    }

    @Test
    public void test4() {
        String input = "((()())(()()))";
        String expectedOutput = "(()())(()())";

        Assert.assertEquals(expectedOutput, obj.removeOutermostParentheses(input));
    }
}