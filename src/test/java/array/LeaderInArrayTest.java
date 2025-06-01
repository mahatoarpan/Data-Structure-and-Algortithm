package array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeaderInArrayTest {

    LeaderInArray obj;
    @Before
    public void setup() {
        obj = new LeaderInArray();
    }

    @Test
    public void test1() {
        int[] input = {4, 7, 1, 0};
        int[] expectedOutput = {7,1,0};
        int[] actualOutput = obj.leader(input);

        Assert.assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void test2() {
        int[] input = {10,22,12,3,0,6};
        int[] expectedOutput = {22,12,6};
        int[] actualOutput = obj.leader(input);

        Assert.assertArrayEquals(expectedOutput, actualOutput);
    }

}