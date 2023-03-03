package stack;



import org.junit.Assert;
import org.junit.Test;


public class ReverseArrayTest {

    @Test
    public void testRevereIntArray() throws StackException {
        ReverseArray reverseArray = new ReverseArray();
        int[] arr = {1,2,3,4,5,6};
        int[] resArr =  reverseArray.reverse(arr);

        for(int i = 0; i < arr.length; i++) {
            Assert.assertEquals(arr[i], resArr[arr.length - 1 - i]);
        }
    }

}