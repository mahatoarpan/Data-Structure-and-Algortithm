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

### Approach 2: Better
**Step 1:** Traverse to find the largest element

**Step 2:** Traverse to find the second-largest element

**Step 3:** Repeat above steps to find the second smallest

```java
public class Solution {
    public int findSeconds(int[] nums) {
        int secondSmallest = secondSmallest(nums);
        int secondLargest = secondLargest(nums);
        return new int[]{secondSmallest, secondLargest};
    }

    private int secondLargest(int[] nums) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int num : nums) {
            largest = Math.max(largest, num);
        }
        for (int num : nums) {
            if (num < largest && num > secondLargest) 
                secondLargest = num;
        }
        return secondLargest != Integer.MIN_VALUE ? secondLargest : -1;
    }

    private int secondSmallest(int[] nums) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        for (int num : nums) {
            smallest = Math.min(smallest, num);
        }
        for (int num : nums) {
            if (num > smallest && num < secondSmallest) {
                secondSmallest = num;
            }
        }
        return secondSmallest != Integer.MAX_VALUE ? secondSmallest : -1;
    }
}
// Time Complexity: O(2n)
// Space Complexity: O(1)
```

### Approach 3: Optimal
**Step 1:** Assign largest and second-largest with MIN_VALUE and smallest and second-smallest with MAX_VALUE

**Step 2:** While traversing the loop, check current element is smallest then update `secondSmallest = smallest` and `smallest = nums[i]`

**Step 3:** Else if current element is smaller than just the second-smallest, update `secondSmallest = nums[i]`

**Step 4:** Perform Step 2 and Step 3 with modification to find second-largest

```java
public class Solution {
    public int findSeconds(int[] nums) {
        int secondSmallest = secondSmallest(nums);
        int secondLargest = secondLargest(nums);
        return new int[]{secondSmallest, secondLargest};
    }

    private int secondLargest(int[] nums) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num < largest && num > secondLargest) {
                secondLargest = num;
            }
        }
        return secondLargest != Integer.MIN_VALUE ? secondLargest : -1;
    }

    private int secondSmallest(int[] nums) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        for (int num : nums) {
            smallest = Math.min(smallest, num);
        }
        for (int num : nums) {
            if (num < smallest) {
                secondSmallest = smallest;
                smallest = num;
            } else if (num > smallest && num < secondSmallest) {
                secondSmallest = num;
            }
        }
        return secondSmallest != Integer.MAX_VALUE ? secondSmallest : -1;
    }
}
// Time Complexity: O(n)
// Space Complexity: O(1)
```
---

## Q3. Remove duplicates from sorted array
*leetcode - [Remove Duplicates from Sorted Array(26)](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)*

```
Example 1:
    Input: nums = [1,1,2]
    Output: 2, nums = [1,2,_]
    Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
        It does not matter what you leave beyond the returned k (hence they are underscores).
```
```
Example 2:
    Input: nums = [0,0,1,1,1,2,2,3,3,4]
    Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
    Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
        It does not matter what you leave beyond the returned k (hence they are underscores).
```

### Approach 1: Brute Force
**Step 1:** Copy the elements into an ordered set (TreeSet in java)

**Step 2:** Copy back the data of set into the original array

**Step 3:** return the size of set as it indicates the number of distinct elements in the array

```java
public class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> uniqueElements = new TreeSet<>();
        
        for (int num : nums) {
            uniqueElements.add(num);
        }
        int index = 0;
        for(int element : uniqueElements) {
            nums[index++] = element;
        }
        return index;
    }
}
// Time complexity: O(n * log n) - Because of treeset
// Space complexity: O(k) - Because k distinct elements needs to be stored in treeset
```

### Approach 2: Optimal
**Step 1:** take two pointers, `i = 0` `j = 0`

**Step 2:** traverse the array using pointer `j`

**Step 3:** while traversing, if `nums[i] == nums[j]`, increment j

**Step 4:** else copy `nums[j]` into `nums[i+1]` 

*Intuition: Move second pointer until we find different number. Once we get a new number we increase the first pointer.* 

```java
public class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                j++;
            } else {
                nums[i++] = nums[j];
            }
        }
        return i + 1;
    }
}
// Time Complexity: O(n)
// Space Complexity: O(1)
```
---

## Q4. Rotate array to the right by K steps.

*leetcode - [Rotate Array(189)](https://leetcode.com/problems/rotate-array/)*

```
Example 1:
    Input: nums = [1,2,3,4,5,6,7], k = 3
    Output: [5,6,7,1,2,3,4]
    Explanation:
    rotate 1 steps to the right: [7,1,2,3,4,5,6]
    rotate 2 steps to the right: [6,7,1,2,3,4,5]
    rotate 3 steps to the right: [5,6,7,1,2,3,4]
```

```
Example 2:
    Input: nums = [-1,-100,3,99], k = 2
    Output: [3,99,-1,-100]
    Explanation: 
    rotate 1 steps to the right: [99,-1,-100,3]
    rotate 2 steps to the right: [3,99,-1,-100]
```

### Approach 1: Brute Force

**Step 1:** Loop `k` time and 

**Step 2:** Rotate array by 1 place at one iteration of outer loop

```java
public class Solution {
    public void rotateByKSteps(int[] nums, int k) {
        k %= nums.length;
        for (int i = 0; i < k; i++) {
            int temp = nums[nums.length - 1];
            for (int j = 1; j < nums.length; j++) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }
}
// Time Complexity: O(k * n)
// Space Complexity: O(1)
```

### Approach 2: Better

**Step 1:** Copy last `k` elements into new array

**Step 2:** Move first `n-k` elements by `k` steps

**Step 3:** Copy the temp array data to `0-k` elements

```java
public class Solution {
    public void rotateByKSteps(int[] nums, int k) {
        int[] temp = new int[k];
        int idx = 0;
        for (int i = nums.length - k; i < nums.length; i++) {
            temp[idx++] = nums[i];
        }
        for (int i = nums.length - k - 1; i >= 0; i--) {
            nums[i + k] = nums[i];
        }

        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }
    }
}
// Time Complexity: O(n)
// Space Complexity: O(k)
```

### Approach 2: Better

**Step 1:** Copy last `k` elements into new array

**Step 2:** Move first `n-k` elements by `k` steps

**Step 3:** Copy the temp array data to `0-k` elements

```java
public class Solution {
    public void rotateByKSteps(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums,0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private  void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
// Time Complexity: O(n)
// Space Complexity: O(1)
```
---








