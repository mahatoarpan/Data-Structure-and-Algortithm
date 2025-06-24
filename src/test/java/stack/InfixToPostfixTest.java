package stack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InfixToPostfixTest {

    InfixToPostfix obj;

    @Before
    public void setup() {
        obj = new InfixToPostfix();
    }

    @Test
    public void test1(){
        String input = "a+b*(c^d-e)^(f+g*h)-i";
        String expectedOutput = "abcd^e-fgh*+^*+i-";

        Assert.assertEquals(expectedOutput, obj.infixToPostfix(input));
    }

    @Test
    public void test2(){
        String input = "(p+q)*(m-n)";
        String expectedOutput = "pq+mn-*";

        Assert.assertEquals(expectedOutput, obj.infixToPostfix(input));
    }
}