package array;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FindTheDuplicateNumberTest extends TestCase {

    FindTheDuplicateNumber obj;

    @Before
    public void setUp() {
        obj = new FindTheDuplicateNumber();
    }

    @Test
    public void test1() {
        int[] input = {1,3,4,2,2};
        int output = 2;

        Assert.assertEquals("Test 1 failed", output, obj.find_Approach3(input));
    }

    @Test
    public void test2() {
        int[] input = {2,5,9,6,9,3,8,9,7,1};
        int output = 9;

        Assert.assertEquals("Test 1 failed", output, obj.find_Approach3(input));
    }

}