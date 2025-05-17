package array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MissingNumberTest {

    MissingNumber obj;
    @Before
    public void setup() {
        obj = new MissingNumber();
    }

    @Test
    public void test1() {
        int[] input = {9,6,4,2,3,5,7,0,1};
        int expectedOutput = 8;
        int actualOutput = obj.findMissingNumber(input);

        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void test2() {
        int[] input = {0,1};
        int expectedOutput = 2;
        int actualOutput = obj.findMissingNumber(input);

        Assert.assertEquals(expectedOutput, actualOutput);
    }

}