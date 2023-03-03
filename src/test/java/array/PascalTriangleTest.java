package array;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangleTest {

    PascalTriangle pascalTriangle;

    @Before
    public void init() {
        pascalTriangle = new PascalTriangle();
    }

    @Test
    public void test1() {
        int input = 5;
        List<Integer> l1 = new ArrayList<>(Arrays.asList(1));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(1,1));
        List<Integer> l3 = new ArrayList<>(Arrays.asList(1,2,1));
        List<Integer> l4 = new ArrayList<>(Arrays.asList(1,3,3,1));
        List<Integer> l5 = new ArrayList<>(Arrays.asList(1,4,6,4,1));
        List<List<Integer>> output = new ArrayList<>(Arrays.asList(l1,l2,l3,l4,l5));

        Assert.assertTrue("Test 1 failed", output.equals(pascalTriangle.generate(input)));
    }
    @Test
    public void test2() {
        int input = 1;
        List<Integer> l1 = new ArrayList<>(Arrays.asList(1));
        List<List<Integer>> output = new ArrayList<>(Arrays.asList(l1));

        Assert.assertTrue("Test 1 failed", output.equals(pascalTriangle.generate(input)));
    }

    @Test
    public void test3() {
        int input = 2;
        List<Integer> l1 = new ArrayList<>(Arrays.asList(1));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(1,1));
        List<List<Integer>> output = new ArrayList<>(Arrays.asList(l1,l2));

        Assert.assertTrue("Test 1 failed", output.equals(pascalTriangle.generate(input)));
    }

}