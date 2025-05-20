package array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TwoSumTest {

    TwoSum obj;

    @Before
    public void setup() {
        obj = new TwoSum();
    }

    @Test
    public void test1() {
        int[] inputArray = {2,7,11,15};
        int target = 9;
        int[] expectedOutput = {0, 1};
        int[] actualOutput = obj.twoSum(inputArray, target);

        Assert.assertArrayEquals(expectedOutput, actualOutput);
    }

}