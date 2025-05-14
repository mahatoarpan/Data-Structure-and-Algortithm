package array;

import java.util.Arrays;

// https://leetcode.com/problems/move-zeroes/description/
// 189. Rotate Array
public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        System.out.println("Original Array: " + Arrays.toString(nums));
//        rightRotate(nums, k);
//        System.out.println("Right Rotated Array: " + Arrays.toString(nums));
        leftRotatedArray(nums, k);
        System.out.println("Right Rotated Array: " + Arrays.toString(nums));
    }

    private static void leftRotatedArray(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
        reverse(nums,0, nums.length - 1);
    }

    private static void rightRotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums,0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
