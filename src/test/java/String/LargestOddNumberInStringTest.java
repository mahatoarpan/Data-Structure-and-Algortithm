package String;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LargestOddNumberInStringTest {

    LargestOddNumberInString obj;

    @Before
    public void setup() {
        obj = new LargestOddNumberInString();
    }

    @Test
    public void test1() {
        String input = "52";
        String expectedOutput = "5";

        Assert.assertEquals(expectedOutput, obj.largestOddNumber(input));
    }
    @Test
    public void test2() {
        String input = "4206";
        String expectedOutput = "";

        Assert.assertEquals(expectedOutput, obj.largestOddNumber(input));
    }
    @Test
    public void test3() {
        String input = "35427";
        String expectedOutput = "35427";

        Assert.assertEquals(expectedOutput, obj.largestOddNumber(input));
    }
}
