package two_pointer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TrappingRainWaterTest {

    TrappingRainWater obj;

    @Before
    public void setup() {
        obj = new TrappingRainWater();
    }

    @Test
    public void test1() {
        int[] input = {0,1,0,2,1,0,1,3,2,1,2,1};
        int expectedOutput = 6;

        Assert.assertEquals(expectedOutput, obj.trap(input));
    }

    @Test
    public void test2() {
        int[] input = {4,2,0,3,2,5};
        int expectedOutput = 9;

        Assert.assertEquals(expectedOutput, obj.trap(input));
    }
}