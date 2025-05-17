package array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntersectionInTwoSortedArrayTest {

    IntersectionInTwoSortedArray obj;

    @Before
    public void init() {
        obj = new IntersectionInTwoSortedArray();
    }

    @Test
    public void test1() {
        int[] input1 = {1,2,2,3,3,4,5,6};
        int[] input2 = {2,3,3,5,6,6,7};
        int[] expectedOutput = {2,3,3,5,6};
        int[] actualOutput = obj.findIntersection(input1, input2);

        Assert.assertArrayEquals("Test 1 failed", expectedOutput, actualOutput);
    }

}