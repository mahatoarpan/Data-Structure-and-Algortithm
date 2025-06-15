package binary_search;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FindPeakElementTest {

    FindPeakElement obj;

    @Before
    public void setup(){
        obj = new FindPeakElement();
    }

    @Test
    public void test1(){
        int[] input = {1,2,3,1};
        Assert.assertEquals(2, obj.findPeakElement(input));
    }
    @Test
    public void test2(){
        int[] input = {1,2,1,3,5,6,4};
        Assert.assertEquals(5, obj.findPeakElement(input));
    }


}