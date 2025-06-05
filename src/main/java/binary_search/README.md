## Q1. Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

*leetcode - [Binary Search](https://leetcode.com/problems/binary-search/description/)*

```
Examples;

    Input: nums = [-1,0,3,5,9,12], target = 9
    Output: 4
    Explanation: 9 exists in nums and its index is 4
    
    Input: nums = [-1,0,3,5,9,12], target = 2
    Output: -1
    Explanation: 2 does not exist in nums so return -1
```

### Approach:

**Step 1:** Divide the search space in 2 equal halves

**Step 2:** Compare the middle element with the target
    
    if target == nums[mid] -> target is found, return the index
    if target < nums[mid] -> target is located on the left half of the array. So, next search space will be the left half.
    if target > nums[mid] -> target is located ion the right half of the array. So, next search space will be the right half.

**Step 3:** Trim down the search space. If target occurs on the left, high becomes mid - 1. Else if target occurs on the right, low becomes mid + 1.

#### Iterative Code
```java
public class Solution {
    public int search(int[] nums, int target) {
        int low = 0; int high = nums.length - 1;
        while(low <= high) {
            int mid = low + ((low + high) / 2);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
```

#### Recursive Code
```java
public class Solution {
    public int search(int[] nums, int low, int high, int target) {
        if (low > high)     return -1;

        int mid = low + ((low + high) / 2);
        if (target == nums[mid])
            return mid;
        else if (target < nums[mid])
            return search(nums, low, mid - 1, target);
        else 
            return search(nums, mid + 1, high, target);
    }
}
```

    Time Complexity: O(log n)
    Space Complexity: O(1)

## Q2. Given a sorted array of N integers and an integer x, write a program to find the lower bound of x.

*TUF - [Lower Bound](https://takeuforward.org/arrays/implement-lower-bound-bs-2/)*

*The lower bound algorithm finds the first or the smallest index in a sorted array where the value at that index is greater than or equal to the key*

```
Examples:

    Input Format: N = 4, arr[] = {1,2,2,3}, x = 2
    Result: 1
    Explanation: Index 1 is the smallest index such that arr[1] >= x.
    
    Input Format: N = 5, arr[] = {3,5,8,15,19}, x = 9
    Result: 3
    Explanation: Index 3 is the smallest index such that arr[3] >= x.

```

### Approach 1: Brute Force

**Step 1:** While iterating the array, if`nums[i] == key` or `nums[i] > key`, then return i

**Step 2:** If the array is traversed completely, then return array length as the hypothetical location where key can be placed. 

```java
public class Solution {
    public int lowerBound(int[] nums, int key) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= key)     
                return i;
        }
        return nums.length;
    }
}
// Time Complexity: O(n)
// Space Complexity: O(1)
```

### Approach 2: Optimal 

**Step 1:** Start with an assumption that the last index of the array contains the number smaller than the key. Doing so, we will assume that the key will should be added to the last of the array.

**Step 2:** Keep two pointers, `low = 0` and `high = nums.length - 1`

**Step 3:** Use binary search algorithm and find mid, `mid = low + ((high - low)/2)`

**Step 4:** If `key <= nums[mid]`, then store the index in answer and make `high = mid - 1`

**Step 5:** Else `low = mid + 1`

```java
public class Solution {
    public int lowerBound(int[] nums, int key){
        int answer = nums.length;
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low)/2);
            if (key <= nums[mid]) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return answer;
    }
}
// Time Complexity: O(log n)
// Space Complexity: O(1)
```

## Q3. Given a sorted array of N integers and an integer x, write a program to find the upper bound of x.

*TUF - [Upper Bound](https://takeuforward.org/arrays/implement-upper-bound/)*

*The upper bound algorithm finds the first or the smallest index in a sorted array where the value at that index is greater than the given key i.e. x. The upper bound is the smallest index, ind, where arr[ind] > x. But if any such index is not found, the upper bound algorithm returns n i.e. size of the given array. The main difference between the lower and upper bound is in the condition. For the lower bound the condition was arr[ind] >= x and here, in the case of the upper bound, it is arr[ind] > x.*

### Approach 1: Brute Force

**Step 1:** While iterating the array, if `nums[i] > key`, then return i

**Step 2:** If the array is traversed completely, then return array length as the hypothetical location where key can be placed.

```java
public class Solution {
    public int lowerBound(int[] nums, int key) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > key)     
                return i;
        }
        return nums.length;
    }
}
// Time Complexity: O(n)
// Space Complexity: O(1)
```

### Approach 2: Optimal

**Step 1:** Start with an assumption that the last index of the array contains the number smaller than the key. Doing so, we will assume that the key will should be added to the last of the array.

**Step 2:** Keep two pointers, `low = 0` and `high = nums.length - 1`

**Step 3:** Use binary search algorithm and find mid, `mid = low + ((high - low)/2)`

**Step 4:** If `key < nums[mid]`, then store the index in answer and make `high = mid - 1`

**Step 5:** Else `low = mid + 1`

```java
public class Solution {
    public int lowerBound(int[] nums, int key){
        int answer = nums.length;
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low)/2);
            if (key < nums[mid]) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return answer;
    }
}
// Time Complexity: O(log n)
// Space Complexity: O(1)
```

## Q4. Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

*leetcode - [Search Insert Position](https://leetcode.com/problems/search-insert-position/description/)*

```
Examples:
    Input: nums = [1,3,5,6], target = 5
    Output: 2
    
    Input: nums = [1,3,5,6], target = 2
    Output: 1
    
    Input: nums = [1,3,5,6], target = 7
    Output: 4
```

*Solution same as question 2 - **Lower Bound***


## Q5. Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value. If target is not found in the array, return [-1, -1].

*leetcode - [Find First and Last Position of Element in Sorted Array](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/)*



