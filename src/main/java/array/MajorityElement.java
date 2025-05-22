package array;

// https://leetcode.com/problems/majority-element/
// Majority Element

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int count = 0; int candidate = nums[0];
        for (int num : nums) {
            count = candidate == num ? count + 1 : count - 1;
            if (count == 0) {
                candidate = num;
            }
        }
        return candidate;
    }
}
