## Q1. Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array. 
*[leetcode - Missing Number(268)](https://leetcode.com/problems/missing-number/)*

```
Example 1:
    Input: nums = [3,0,1]
    Output: 2
    Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
```
```
Example 2:
    Input: nums = [0,1]
    Output: 2
    Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums. 2 is the missing number in the range since it does not appear in nums.
```
```
    Input: nums = [9,6,4,2,3,5,7,0,1]
    Output: 8
    Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.2 is the missing number in the range since it does not appear in nums.
```

### Approach 1: Brute Force
**Step 1:** Traverse through 1 to n as only numbers till N can be present in the array.

**Step 2:** Within the loop traverse the array to check if number exist or not.

```java
public class Solution {
    public int findMissingNumber(int[] nums) {
        for (int i = 1; i <= nums.length; i++) { // loop from 1 to n
            boolean flag = false;
            for (int num : nums) { // traverse all the numbers of the loop
                if (num == i) {
                    flag = true;
                    break;
                }
            }
            if (!flag) return i;
        }
        return -1;
    }
}
// Time Complexity: O(n^2)
// Space Complexity: O(1) - no additional data structures used.
```

### Approach 2: Better
**Step 1:** Create a hash array of length [n+1] to store the count of numbers 

**Step 2:** Traverse Hash Array to find the location with 0 count value.

```java
public class Solution {
    public int findMissingNumber(int[] nums) {
        int[] hashArray = new int[nums.length + 1];
        for (int num : nums) {
            hashArray[num]++;
        }
        for (int i = 1; i < hashArray.length; hashArray++) {
            if (hashArray[i] == 0) return i;
        }
        return -1;
    }
}
// Time Complexity: O(2n)
// Space Complexity: O(n) - hash array to store the count
```

### Approach 3: Optimal
**Step 1:** Sum all natural numbers till n.`sum = (n * (n + 1)) / 2`

**Step 2:** Sum all the elements in the array

**Step 3:** Subtract sum of elements from sum of natural numbers to get the result 

```java
public class Solution {
    public int findMissingNumber(int[] nums) {
        int n = nums.length;
        long sumOfNaturalNumbers = ((long) n * (n + 1)) / 2; // upcasting sum to long as multiplication of larger value of n can hit integer limit
        int sumOfElements = 0;
        for (int num : nums) { // loop from 1 to n
            sumOfElements += num;
        }
        return (int)(sumOfNaturalNumbers - sumOfElements);
    }
}
// Time Complexity: O(n)
// Space Complexity: O(1)
```

### Approach 4: Optimal
**Step 1:** XOR all the natural numbers till N.

**Step 2:** XOR all the array elements to the above XOR result

*Intuition: All similar numbers will be cancelled out so only the missing number will become the result*

```java
public class Solution {
    public int findMissingNumber(int[] nums) {
        int missingNumber = 0;
        for (int i = 0; i < nums.length; i++) {
            missingNumber = missingNumber ^ nums[i] ^ (i + 1);
        }
        return missingNumber;
    }
}
// Time Complexity: O(n)
// Space Complexity: O(1)
```
---
## Q2. Given an array, find the second-smallest and second-largest element in the array. Print ‘-1’ in the event that either of them doesn’t exist.
*[TUF](https://takeuforward.org/data-structure/find-second-smallest-and-second-largest-element-in-an-array/)*

```
Example 1:
    Input: [1,2,4,7,7,5]
    Output: [2,5]
    Explanation: The elements are as follows 1,2,3,5,7,7 and hence second largest of these is 5 and second smallest is 2
```
```
Example 2:
    Input: [1]
    Output: [-1,-1]
    Explanation: Since there is only one element in the array, it is the largest and smallest element present in the array. There is no second largest or second smallest element present.
```

### Approach 1: Brute Force
**Step 1:** Sort the array

**Step 2:** Traverse from front and find the second smallest and break

**Step 3:** Traverse from rear and find the second largest and break

```java
public class Solution {
    public int findSeconds(int[] nums) {
        Arrays.sort(nums);
        int secondSmallest = secondSmallest(nums);
        int secondLargest = secondLargest(nums);
        return new int[]{secondSmallest, secondLargest};
    }

    private int secondLargest(int[] nums) {
        int largest = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (largest > nums[i]) return nums[i];
        }
        return -1;
    }

    private int secondSmallest(int[] nums) {
        int smallest = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (smallest < nums[i]) return nums[i];
        }
        return -1;
    }
}
// Time Complexity: O(n * log n) - due to sorting of array
// Space Complexity: O(1)
```









