package array;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SetZeroMatrixTest {

    SetZeroMatrix obj;

    @Before
    public void init() {
        obj = new SetZeroMatrix();
    }

    @Test
    public void test1() {
        int[][] input = {{1,1,1},{1,0,1},{1,1,1}};
        int[][] output = {{1,0,1},{0,0,0},{1,0,1}};

        Assert.assertArrayEquals("Test 1 failed", output, obj.setZero_Approach3(input));
    }

    @Test
    public void test2() {
        int[][] input = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        int[][] output = {{0,0,0,0},{0,4,5,0},{0,3,1,0}};

        Assert.assertArrayEquals("Test 2 failed", output, obj.setZero_Approach3(input));
    }

    @Test
    public void test3() {
        int[][] input = {{7,19,3},{4,21,0}};
        int[][] output = {{7,19,0},{0,0,0}};

        Assert.assertArrayEquals("Test 3 failed", output, obj.setZero_Approach3(input));
    }

    @Test
    public void test4() {
        int[][] input = {{1,2,3,4},{5,0,7,8},{0,10,11,12},{13,14,15,0}};
        int[][] output = {{0,0,3,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};

        Assert.assertArrayEquals("Test 4 failed", output, obj.setZero_Approach3(input));
    }

}