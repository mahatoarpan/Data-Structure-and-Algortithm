package binary_search;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FirstAndLastOccurrenceTest {

    FirstAndLastOccurrence obj;

    @Before
    public void setup() {
        obj = new FirstAndLastOccurrence();
    }

    @Test
    public void test1() {
        int[] inputArray = {1};
        int target = 1;
        int[] expected = {0,0};
        int[] actual = obj.searchRange(inputArray, target);

        Assert.assertArrayEquals(expected, actual);

    }

    @Test
    public void test2() {
        int[] inputArray = {2, 2};
        int target = 3;
        int[] expected = {-1,-1};
        int[] actual = obj.searchRange(inputArray, target);

        Assert.assertArrayEquals(expected, actual);

    }

}