package stack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InfixToPrefixTest {

    InfixToPrefix obj;

    @Before
    public void setup() {
        obj = new InfixToPrefix();
    }

    @Test
    public void test1(){
        String input = "x+y*z/w+u";
        String expectedOutput = "++x/*yzwu";

        Assert.assertEquals(expectedOutput, obj.infixToPrefix(input));
    }

    @Test
    public void test2() {
        String input = "a+b";
        String expectedOutput = "+ab";

        Assert.assertEquals(expectedOutput, obj.infixToPrefix(input));
    }

}