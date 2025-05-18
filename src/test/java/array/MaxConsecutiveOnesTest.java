package array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxConsecutiveOnesTest {

    MaxConsecutiveOnes obj;

    @Before
    public void setup() {
        obj = new MaxConsecutiveOnes();
    }

    @Test
    public void test1() {
        int[] input = {1,1,0,1,1,1};
        int expectedOutput = 3;
        int actualOutput = obj.findMaxConsecutiveOnes(input);

        Assert.assertEquals(expectedOutput, actualOutput);
    }
    @Test
    public void test2() {
        int[] input = {1,0,1,1,0,1};
        int expectedOutput = 2;
        int actualOutput = obj.findMaxConsecutiveOnes(input);

        Assert.assertEquals(expectedOutput, actualOutput);
    }
}