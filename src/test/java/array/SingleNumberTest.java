package array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SingleNumberTest {

    SingleNumber obj;

    @Before
    public void setup() {
        obj = new SingleNumber();
    }

    @Test
    public void test1() {
        int[] input = {2,2,1};
        int expectedOutput = 1;
        int actualOutput = obj.singleNumber(input);

        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void test2() {
        int[] input = {4,1,2,1,2};
        int expectedOutput = 4;
        int actualOutput = obj.singleNumber(input);

        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void test3() {
        int[] input = {1};
        int expectedOutput = 1;
        int actualOutput = obj.singleNumber(input);

        Assert.assertEquals(expectedOutput, actualOutput);
    }

}