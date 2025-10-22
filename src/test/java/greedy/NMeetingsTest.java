package greedy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NMeetingsTest {

    private NMeetings obj;

    @Before
    public void setup(){
        obj = new NMeetings();
    }

    @Test
    public void test1() {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9 ,9};
        int expected = 4;
        int actual = obj.findMaxMeetingOrganized(start, end);
        Assert.assertEquals(expected, actual);
    }

}