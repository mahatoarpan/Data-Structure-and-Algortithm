package array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LongestConsecutiveSequenceTest {

    LongestConsecutiveSequence obj;

    @Before
    public void setup() {
        obj = new LongestConsecutiveSequence();
    }

    @Test
    public void test1() {
        int[] input = {100,4,200,1,3,2};
        int expectedOutput = 4;
        int actualOutput = obj.longestConsecutive(input);

        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void test2() {
        int[] input = {0,3,7,2,5,8,4,6,0,1};
        int expectedOutput = 9;
        int actualOutput = obj.longestConsecutive(input);

        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void test3() {
        int[] input = {1,0,1,2};
        int expectedOutput = 3;
        int actualOutput = obj.longestConsecutive(input);

        Assert.assertEquals(expectedOutput, actualOutput);
    }

}