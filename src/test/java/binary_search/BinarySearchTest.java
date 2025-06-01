package binary_search;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {

    BinarySearch obj;

    @Before
    public void setup() {
        obj = new BinarySearch();
    }

    @Test
    public void test1() {
        int[] input = {-1,0,3,5,9,12};
        int target = 9;
        int expectedOutput = 4;
        Assert.assertEquals(expectedOutput, obj.search(input, target));
    }

    @Test
    public void test2() {
        int[] input = {-1,0,3,5,9,12};
        int target = 2;
        int expectedOutput = -1;
        Assert.assertEquals(expectedOutput, obj.search(input, target));
    }
}