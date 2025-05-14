package array;
// https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
// Remove duplicates from Sorted Array
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        int k = removeDuplicates(nums);
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    private static int removeDuplicates(int[] nums) {
        int i = 0, j = 1;

        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                j++;
            } else {
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
}
