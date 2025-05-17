package array;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UnionOfTwoSortedArraysTest {
    UnionOfTwoSortedArrays obj;

    @Before
    public void init() {
        obj = new UnionOfTwoSortedArrays();
    }

    @Test
    public void test1() {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arr2 = {2, 3, 4, 4, 5, 11, 12};
        int[] expectedOutput = {1,2,2,3,3,4,4,4,5,5,6,7,8,9,10,11, 12};
        int[] actualOutput = obj.findUnion(arr1, arr2);

        Assert.assertArrayEquals("Test 1 failed.", expectedOutput, actualOutput);
    }
}