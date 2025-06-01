package array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RotateImageTest {

    RotateImage obj;

    @Before
    public void setup() {
        obj = new RotateImage();
    }

    @Test
    public void test1() {
        int[][] input = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] expectedOutput = {{7,4,1},{8,5,2},{9,6,3}};

        Assert.assertArrayEquals(expectedOutput, obj.rotate(input));

    }

    @Test
    public void test2() {
        int[][] input = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        int[][] expectedOutput = {{15,13,2,5},{14,3,4,1},{12,6,8,9},{16,7,10,11}};

        Assert.assertArrayEquals(expectedOutput, obj.rotate(input));

    }

}