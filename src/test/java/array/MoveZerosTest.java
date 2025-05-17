package array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MoveZerosTest {

    MoveZeros obj;

    @Before
    public void init() {
        obj = new MoveZeros();
    }

    @Test
    public void test1() {
        int[] input = {0,1,0,3,12};
        int[] expectedOutput = {1,3,12,0,0};
        obj.moveZeros(input);

        Assert.assertArrayEquals("Test 1 failed", expectedOutput, input);


    }

}