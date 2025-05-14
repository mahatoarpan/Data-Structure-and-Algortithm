package array;

import java.util.Arrays;

public class FindSecondLargestAndSecondSmallest {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7, 7, 5};
        System.out.println(Arrays.toString(getSeconds(arr)));
    }

    private static int[] getSeconds(int[] arr) {
        int largest, secondLargest, smallest, secondSmallest;
        largest = Integer.MIN_VALUE;
        secondLargest = Integer.MIN_VALUE;
        smallest = Integer.MAX_VALUE;
        secondSmallest = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] > secondLargest && arr[i] < largest) {
                secondLargest = arr[i];
            }
            if (arr[i] < smallest) {
                secondSmallest = smallest;
                smallest = arr[i];
            } else if(arr[i] < secondSmallest && arr[i] > smallest) {
                secondSmallest = arr[i];
            }
        }
        return secondSmallest != secondLargest ? new int[]{secondSmallest, secondLargest} : new int[]{-1, -1};
    }
}
