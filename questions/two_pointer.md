## Q1. Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

*leetcode - [Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/description/)*

```
Examples

Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

Input: height = [4,2,0,3,2,5]
Output: 9
```

### Approach 1: Brute Force

**Step 1:** Standing at a building `i` move both direction until size of `left` and `right` are increasing.

**Step 2:** get the minimum of left and right and subtract height of i from it. That will be the water getting trapped on top of that building.

**Step 3:** Add it the final sum.

```java
public class Solution {
    public int trap(final int[] height) {
        int result = 0;

        for(int i = 0; i < height.length; i++) {
            int left = 0, right = 0;
            for(int j = i; j >= 0; j--) {
                left = Math.max(left, height[j]);
            }
            for(int j = i; j < height.length; j++) {
                right = Math.max(right, height[j]);
            }
            result += Math.min(left, right) - height[i];
        }
        return result;
    }
}
// Time Complexity: O(n^2)
// Space Complexity: O(1)
```

### Approach 2: Better

**Step 1:** Initiate 2 new arrays, `prefixMax` and `suffixMax`

**Step 2:** Iterate the given array from left to right and store the max of current element and previous of prefix max into current of prefix max

    prefixMax[i] = Math.max(prefixMax[i-1], heights[i])

**Step 3:** Iterate the given array from right to left and store the max of current element and next of suffix max into current of suffix max

    suffixMax[i] = Math.max(suffixMax[i+1], heights[i])

**Step 4:** Iterate over the original array and check if both prefix and suffix max of current index is more the value of array

    if (prefixMax[i] > heights[i] && suffixMax[i] > heights[i])
        add min(prefixMax[i], suffixMax[i] - heights[i] to answer

```java
public class Solution {

    public int trap(final int[] height) {
        int[] prefixMax = new int[height.length];
        int[] suffixMax = new int[height.length];
        int result = 0;

        prefixMax[0] = height[0];
        suffixMax[height.length-1] = height[height.length-1];

        for (int i = 1; i < height.length; i++) {
            prefixMax[i] = Math.max(prefixMax[i-1], height[i]);
        }
        for (int i = height.length-2; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i+1], height[i]);
        }

        for (int i = 1; i < height.length - 1; i++) {
            if (prefixMax[i] > height[i] && suffixMax[i] > height[i]) {
                result += Math.min(prefixMax[i], suffixMax[i]) - height[i];
            }
        }
        return result;
    }
}
// Time Complexity: O(2n) + O(n)
// Space Complexity: O(2n)
```

### Approach 4: Better 2

**Step 1:** Initiate new array`suffixMax`

**Step 2:** Iterate the given array from right to left and store the max of current element and next of suffix max into current of suffix max

    suffixMax[i] = Math.max(suffixMax[i+1], heights[i])

**Step 3:** Iterate over the original array and check if both prefixMax and suffix max of current index is more the value of array

    if (prefixMax > heights[i] && suffixMax[i] > heights[i])
        add min(prefixMax[i], suffixMax[i] - heights[i] to answer

```java
public class Solution {

    public int trap(final int[] height) {
        int[] suffixMax = new int[height.length];
        int prefixMax = height[0];
        int result = 0;
        suffixMax[height.length-1] = height[height.length-1];

        for (int i = height.length-2; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i+1], height[i]);
        }

        for (int i = 1; i < height.length - 1; i++) {
            if (prefixMax > height[i] && suffixMax[i] > height[i]) {
                result += Math.min(prefixMax, suffixMax[i]) - height[i];
            }
            prefixMax = Math.max(prefixMax, height[i]);
        }
        return result;

    }
}
// Time Complexity: O(2n)
// Space Complexity: O(n)
```

### Approach 4: Optimal

**Step 1:** Initialize the following
    
    left_pointer
    right_pointer
    left_max -> max height seen so far from the left
    right_max -> max height seen so far from the right
    trapped_water -> to store the total trapped water

**Step 2:** Move either left pointer or right pointer until they cross each other.

**Step 3:** At every step, check if the left_pointer is smaller than the right_pointer.

**Step 4:** If yes, check if left_pointer is taller than the tallest building in left.

**Step 5:** If left_pointer is the tallest, update the tallest. Else, it means water can be trapped above left pointer. Add it to the trapped water.

**Step 6:** If at step 3 right_pointer is smaller. perform step 4 and step 5 by replacing left_pointer with right_pointer and left_max with right_max.

```java
public class TrappingRainWater {

    public int trap(int[] height) {
        // Total amount of trapped water
        int trappedWater = 0;
        // Pointers for left and right ends of the array
        int left = 0, right = height.length - 1;
        // Variables to keep track of the highest bar from left and right
        int leftMax = 0, rightMax = 0;
        
        while (left < right) {

            // Case 1: height at left is less than height at right
            if (height[left] < height[right]) {
                // If current height is greater than or equal to leftMax,
                // update leftMax — this becomes the new boundary
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    // Water can be trapped — the difference is added to the total
                    trappedWater += leftMax - height[left];
                }
                left++;
            } else {
                // Case 2: height at right is less than or equal to height at left

                // If current height is greater than or equal to rightMax,
                // update rightMax — this becomes the new boundary
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    // Water can be trapped — the difference is added to the total
                    trappedWater += rightMax - height[right];
                }
                right--;
            }
        }
        return trappedWater;
    }
}
// Time Complexity: O(n)
// Space Complexity: O(1)
```