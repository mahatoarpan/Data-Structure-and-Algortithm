package stack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PrefixToInfixTest {
    PrefixToInfix obj;

    @Before
    public void setup() {
        obj = new PrefixToInfix();
    }

    @Test
    public void test1() {
        String input = "*+AB-CD";
        String expectedOutput = "((A+B)*(C-D))";

        Assert.assertEquals(expectedOutput, obj.prefixToInfix(input));
    }

    @Test
    public void test2() {
        String input = "*-A/BC-/AKL";
        String expectedOutput = "((A-(B/C))*((A/K)-L))";

        Assert.assertEquals(expectedOutput, obj.prefixToInfix(input));
    }
}
