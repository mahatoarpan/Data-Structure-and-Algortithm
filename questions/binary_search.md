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
            int mid = low + (high - low) / 2;
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

        int mid = low + (high - low) / 2;
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

```
Examples:

    Input: nums = [5,7,7,8,8,10], target = 8
    Output: [3,4]
    
    Input: nums = [5,7,7,8,8,10], target = 6
    Output: [-1,-1]

    Input: nums = [], target = 0
    Output: [-1,-1]
```

### Approach 1: Brute Force

**Step 1:** initialize two variables, first and last, to store the first position and last occurrence position.

**Step 2:** iterate over the array

**Step 3:** if target found, update the last variable with that position. Update the first variable only when it was marked as -1 initially.

```java
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (first == - 1){
                    first = i;
                }
                last = i;
            }
        }
        return result;
    }
}
// Time Complexity: O(n)
// Space Complexity: O(1)
```

### Approach 2: Optimal 1 

**Step 1:** Find the lower bound

**Step 2:** If lower bound is available, search for upper bound

**Step 3:** Else, return {-1,-1}

```java
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[]{-1,-1};
        }
        int lower = lowerBound(nums, target);
        if(lower == -1) {
            return new int[]{-1,-1};
        } else {
            int upper = upperBound(nums, target);
            return new int[]{lower, upper};
        }
    }

    private int lowerBound(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int result = nums.length;
        while(low <= high) {
            int mid = low + ((high - low) / 2);
            if(target <= nums[mid]) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return result == nums.length ||
                nums[result] != target ?
                -1 : result;
    }

    private int upperBound(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int result = nums.length;
        while(low <= high) {
            int mid = low + ((high - low) / 2);
            if(target < nums[mid]) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result - 1;
    }
}
// Time Complexity: O(log n) + O(log n)
// Space Complexity: O(1)
```

### Approach 3: Optimal 2

**Step 1:** Find the first occurrence using binary search

**Step 2:** If first occurrence is not -1, find the last occurrence

**Step 3:** Else return {-1, -1}

```java
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1,-1};
        if (nums == null || nums.length == 0) {
            return res;
        }
        res[0] = findFirstIndex(nums, target);
        if (res[0] != -1) {
            res[1] = findLastIndex(nums, target);
        }
        return res;
    }
    
    private int findFirstIndex(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int res = -1;
        
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (nums[mid] == target) {
                res = mid;
                high = mid - 1;
            } else if(nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
    }

    private int findLastIndex(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int res = -1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (nums[mid] == target) {
                res = mid;
                low = mid + 1;
            } else if(nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
    }
}
// Time Complexity: O(log n) + O(log n)
// Space Complexity: O(1)
```

## Q6. Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

*leetcode - [Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/description/)*

```
Examples:

    Input: nums = [4,5,6,7,0,1,2], target = 0
    Output: 4
    
    Input: nums = [4,5,6,7,0,1,2], target = 3
    Output: -1
    
    Input: nums = [1], target = 0
    Output: -1
```

### Approach 1: Brute Force

**Linear Search**

```
// Time Complexity: O(n)
// Space Complexity: O(1)
```

### Approach 2: Optimal

**Step 1:** find the rotation index

**Step 2:** if rotation index is -1, use binary search on complete array as array is not rotated

**Step 3:** else, check `target < nums[0]`, if yes, binary search on array from rotation index till end of array. Target can possibly be in the rotated part

**Step 4:** If `target >= nums[0]`, binary search on array from 0 till rotation index - 1. 

```java
class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int breakPoint = findBreakPoint(nums);
        int res = -1;
        int low = 0, high = nums.length - 1;


        if(breakPoint == -1) {
            // completely sorted array
            return binarySearch(nums, 0, nums.length - 1, target);
        } else {
            return target < nums[0] ? 
                binarySearch(nums, breakPoint, nums.length -1, target) : 
                binarySearch(nums, 0, breakPoint - 1, target);
        }

    }
    
    private int findBreakPoint(int[] nums) {
        if(nums[0] < nums[nums.length - 1]) {
            return -1;
        }
        int res = -1;
        int low = 0, high = nums.length - 1;
        while(low <= high) {
            int mid = low + ((high - low)/2);
            if(nums[mid] < nums[0]) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    private int binarySearch(int[] nums, int low, int high, int target) {
        while(low <= high) {
            int mid = low + ((high - low) / 2);
            if(target == nums[mid]) {
                return mid;
            } else if(target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
// Time Complexity: O(log n) + O(log n)
// Space Complexity: O(1)
```

## Q7. Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.

*leetcode - [Search in Rotated Sorted Array II](https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/)*

```
Examples:

    Input: nums = [2,5,6,0,0,1,2], target = 0
    Output: true
    
    Input: nums = [1,0,1,1,1], target = 0
    Output: true
```

```java
class Solution {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return false;
        }
        int low = 0, high = nums.length - 1;
        while(low <= high) {
            int mid = low + ((high - low)/2);
            if(nums[mid] == target) {
                return true;
            } 
            
            if(nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
                continue;
            } 
            if (nums[low] <= nums[mid]) {
                // sorted left half
                if(nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                // sorted right half
                if(nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}
// Time Complexity: O(n)
// Space Complexity: O(1)
```

## Q8. Given the sorted rotated array nums of unique elements, return the minimum element of this array.

*leetcode - [Find Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/)*

```
Examples:

    Input: nums = [3,4,5,1,2]
    Output: 1

    Input: nums = [11,13,15,17]
    Output: 11
```

### Approach 1: Brute Force

*Linear search over the array and store the minimum number*

```
Time Complexity: O(n)
Space Complexity: O(1)
```

### Approach 2: Optimal

**Step 1:** Find the rotated index, as rotated index is the smallest element

**Step 2:** If rotated index is -1, array is not sorted, return nums[0]

**Step 3:** If rotated index is something else, then return nums[rotated_index]

```java
class Solution {
    public int findMin(int[] nums) {
        int res = -1;
        int low = 0, high = nums.length - 1;
        while(low <= high) {
            int mid = low + ((high - low)/2);
            if(nums[mid] < nums[0]) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res == -1 ? nums[0] : nums[res];
    }
}
// Time Complexity: O(log n)
// Space Complexity: O(1)
```

## Q9. given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Return the single element that appears only once.

*leetcode - [Single Element in a Sorted Array](https://leetcode.com/problems/single-element-in-a-sorted-array/description/)*
*video explanation - [YouTube](https://youtu.be/AZOmHuHadxQ)

```
Examples:

    Input: nums = [1,1,2,3,3,4,4,8,8]
    Output: 2
    
    Input: nums = [3,3,7,7,10,11,11]
    Output: 10
```

### Approach 1: Brute Force 1

**Step 1:** Check for Edge cases first
    
    Case 1: When there is only 1 element in the array
    Case 2: When first element is the result
    Case 3: When last element is the result

**Step 2:** Start iterating from 1st element in the array and check if the element is either equal to its left or right. If not then element is the answer.

```java
public class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1 || nums[0] != nums[1]) {
            return nums[0];
        }
        if (nums[nums.length - 2] != nums[nums.length - 1]){
            return nums[nums.length - 1];
        }
        
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i - 1] != nums[i] && nums[i] != nums[i+1]) {
                return nums[i];
            }
        }
        return -1
    }
}
// Time Complexity: O(n)
// Space Complexity: O(1)
```

### Approach 2: Brute Force 2

XOR all the elements, all the elements which occurs twice will cancel each other.

```java
public class Solution {
    public int singleNonDuplicate(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = result ^ num;
        }
        return result;
    }
}
// Time Complexity: O(n)
// Space Complexity: O(1)
```

### Approach 3: Optimal

**Step 1:** Check for Edge cases first

    Case 1: When there is only 1 element in the array
    Case 2: When first element is the result
    Case 3: When last element is the result

**Step 2:** Place the 2 pointers i.e. low and high: Initially, we will place the pointers excluding index 0 and n-1 like this: low will point to index 1, and high will point to index n-2 i.e. the second last index.

**Step 3:** Check if `arr[mid]` is the single element:
If `arr[mid] != arr[mid-1]` and `arr[mid] != arr[mid+1]`: If this condition is true for `arr[mid]`, we can conclude `arr[mid]` is the single element. We will return `arr[mid]`.

**Step 4:** If `(mid % 2 == 0 and arr[mid] == arr[mid+1])` or `(mid%2 == 1 and arr[mid] == arr[mid-1])`: 
This means we are in the left half and we should eliminate it as our single element appears on the right. So, we will do this:
`low = mid+1`.

**Step 5:** Otherwise, we are in the right half and we should eliminate it as our single element appears on the left. So, we will do this: `high = mid-1`.


```java
public class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1 || nums[0] != nums[1]) {
            return nums[0];
        }
        if (nums[nums.length - 2] != nums[nums.length - 1]){
            return nums[nums.length - 1];
        }
        
        int low = 1; int high = nums.length - 2;
        while(low <= high) {
            int mid = low + ((high - low)/2);

            if(nums[mid - 1] != nums[mid] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            } else if (nums[mid - 1] == nums[mid]) {
                // left to the number, consecutive number pair will be (even_index, odd_index)
                if(mid % 2 == 0) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                // right to the number, consecutive number pair will be (odd_index, even_index)
                if(mid % 2 == 0) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1
    }
}
// Time Complexity: O(log n)
// Space Complexity: O(1)
```

## Q10. A peak element is an element that is strictly greater than its neighbors. Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
You may imagine that `nums[-1] = nums[n] = -∞`.

*leetcode - [Find Peak Element](https://leetcode.com/problems/find-peak-element/description/)*

*A peak element in an array refers to the element that is greater than both of its neighbors. Basically, if arr[i] is the peak element, `arr[i] > arr[i-1]` and `arr[i] > arr[i+1]`.*

```
Examples:

    Input: nums = [1,2,3,1]
    Output: 2
    Explanation: 3 is a peak element and your function should return the index number 2.
    
    Input: nums = [1,2,1,3,5,6,4]
    Output: 5
    Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.
```

### Approach 1: Brute Force

**Step 1:** Check the edge cases

    When only 1 element is available, its the peak
    When nums[0] > nums[1], it can be a possible peak as imaginary nums[-1] is -∞
    When nums[n-1] > nums[n-2], it can be a possible peak as imaginary nums[n] is -∞

**Step 2:** Start iterating from 1st element and check if it is greater than its neighbours. If yes return the position.

```java
class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1 || nums[0] > nums[1]){
            return 0;
        }
        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }
        
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i-1] && nums[i] > nums[i+1]){
                return i;
            }
        }
        return -1;
    }
}
// Time Complexity: O(n)
// Space Complexity: O(1)
```

### Approach 2: Optimal

**Step 1:** Check the edge cases

    When only 1 element is available, its the peak
    When nums[0] > nums[1], it can be a possible peak as imaginary nums[-1] is -∞
    When nums[n-1] > nums[n-2], it can be a possible peak as imaginary nums[n] is -∞

**Step 2:** If the peak is not at the ends, it must be somewhere in the middle. The Binary Search iteration continuously shrinks the search window until a peak is found.

**Step 3:** If mid is peak: `arr[mid] > arr[mid-1]` and `arr[mid] > arr[mid+1]`, return mid.

**Step 4:** Else, decide which half to search next.
* `if (nums[mid] > nums[mid - 1])`: condition checks if we are on an uphill slope, if yes, peak must lie to the right.
*  if no, we are on a downhill slope, so peak must be on the left.

```java
class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1 || nums[0] > nums[1]){
            return 0;
        }
        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }
        int low = 1, high = nums.length - 2;
        while(low <= high) {
            int mid = low + ((high - low) / 2);
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (nums[mid] > nums[mid - 1]) {
                // we are on the uphill, peak must be on the right
                low = mid + 1;
            } else {
                // we are on the downhill, peak must be on the left
                high = mid - 1;
            }
        }
        return -1;
    }
}
// Time Complexity: O(log n)
// Space Complexity: O(1)
```










