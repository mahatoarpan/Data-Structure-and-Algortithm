package algorithm;

import org.junit.Assert;
import org.junit.Test;

public class PrintAllDivisorTest {

    @Test
    public void test1() {
        int n = 36;
        Assert.assertEquals("1 36 2 18 3 12 4 9 6 ", PrintAllDivisor.print(36));
    }

    @Test
    public void test2() {
        int n = 2;
        Assert.assertEquals("1 9 3 ", PrintAllDivisor.print(9));
    }
}