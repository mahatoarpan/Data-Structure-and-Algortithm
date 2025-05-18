## Q1. Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array. 
*[leetcode - Missing Number(268)](https://leetcode.com/problems/missing-number/)*

```
Examples:

    Input: nums = [3,0,1]
    Output: 2
    Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.

    Input: nums = [0,1]
    Output: 2
    Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums. 2 is the missing number in the range since it does not appear in nums.

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

*Intuition: XOR of same number equals 0. By this logic all the natural numbers from `1-n` will cancel the numbers available in the array. Only one number will be left. That will be the missing number.*

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
*TUF - [Second largest element in an Array](https://takeuforward.org/data-structure/find-second-smallest-and-second-largest-element-in-an-array/)*

```
Examples :

    Input: [1,2,4,7,7,5]
    Output: [2,5]
    Explanation: The elements are as follows 1,2,3,5,7,7 and hence second largest of these is 5 and second smallest is 2

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
Examples:

    Input: nums = [1,1,2]
    Output: 2, nums = [1,2,_]
    Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
        It does not matter what you leave beyond the returned k (hence they are underscores).

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
Examples :

    Input: nums = [1,2,3,4,5,6,7], k = 3
    Output: [5,6,7,1,2,3,4]
    Explanation:
    rotate 1 steps to the right: [7,1,2,3,4,5,6]
    rotate 2 steps to the right: [6,7,1,2,3,4,5]
    rotate 3 steps to the right: [5,6,7,1,2,3,4]

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

### Q5. Move all `0's` to the end of it while maintaining the relative order of the non-zero elements.

*leetcode - [Move Zeroes](https://leetcode.com/problems/move-zeroes/)*

```
Example :

    Input: [0,1,0,3,12]
    Output: [1,3,12,0,0]
```

### Approach 1: Brute Force

**Step 1:** Store non-zero elements into temporary array.

**Step 2:** Copy non-zero elements into original array.

**Step 3:** Assign `0's` to the remaining portion of the array.

```java
public class Solution {
    public void moveZeros(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        for (int num : nums) {
            if (num != 0)   temp.add(num);
        }
        for (int i = 0; i < temp.size(); i++) {
            nums[i] = temp.get(i);
        }
        for (int i = temp.size(); i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
// Time Complexity: O(2n)
// Space Complexity: O(n)
```

### Approach 2: Optimal

**Step 1:** Find the first `0` int the array and store it as `idx_0`.

**Step 2:** Traverse from `idx_0 + 1` and find non-zero. 

**Step 3:** If non-zero found swap with zero(`idx_0`)

```java
public class Solution {
    public void moveZeroes(int[] nums) {
        int i, idx_0 = 0;
        while (idx_0 < nums.length && nums[idx_0] != 0) {
            idx_0++;
        }
        i = idx_0 + 1;
        while (i < arr.length) {
            if (arr[i] != 0) {
                swap(arr, i, idx_0);
                idx_0++;
            }
            i++;
        }
    }
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
// Time Complexity: O(n)
// Space Complexity: O(1)
```
---

## Q6. Given a binary array, return the maximum number of consecutive `1's` in the array.

*leetcode - [Max Consecutive Ones](https://leetcode.com/problems/max-consecutive-ones/)

```
Example:

    Input: [1,1,0,1,1,1]
    Output: 3
    Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.

```

## Approach

**Step 1:** While traversing the array, if the value at current index is equal to 1, increase count by 1.

**Step 2:** If value at current index is not equal to 1, compare count with maxCount, if count is more update maxCount.

**Step 3:** Perform comparison between count and maxCount for the final time after the execution of the loop, for a scenario where max consecutive is at the end.

```java
public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                maxCount = Math.max(count, maxCount);
                count = 0;
            }
        }
        return Math.max(count, maxCount);
    }
}
// Time Complexity: O(n)
// Space Complexity: O(1)
```
---

## Q7. Given a non-empty array of integers, every element appears twice except for one. Find that single one.

*leetcode - [Single Number](https://leetcode.com/problems/single-number/)*

```
Examples:

    Input: nums = [2,2,1]
    Output: 1

    Input: nums = [4,1,2,1,2]
    Output: 4

    Input: nums = [1]
    Output: 1
```

### Approach 1 - Brute Force

**Step 1:** Iterate the array

**Step 2:** Linear search `nums[i]` element and count the occurrences.

**Step 3:** When occurrence of `nums[i] = 1` return from the function 

```java
public class Solution {
    public int singleNumber(int[] nums) {
        for (int num : nums) {
            int count = 0;
            for (int num1 : nums) {
                if (num1 == num) count++;
            }
            if (count == 1) return num;
        }
        return -1;
    }
}
// Time Complexity: O(n ^ 2)
// Space Complexity: O(1)
```

### Approach 2: Better

**Step 1:** Declare a hashmap

**Step 2:** Iterate over the array and store the number of occurrences in hashmap.

**Step 3:** Iterate the hash map, once a key is found with `count == 1` return the key.

```java
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
// Time Complexity: O(n * log m) + O(m) - m = size of the map
// Space Complexity: O(m)
```

### Approach 3: Optimal

**Step 1:** Iterate the array

**Step 2:** XOR the values of the array into result.

*Intuition: As each element appears twice, XOR will cancel them, only the number that occurs once will be left.*

```java
class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
// Time Complexity: O(n)
// Space Complexity: O(1)
```
---

## Q8. Find the length of longest subarray that sums to K

*TUF - [Longest Subarray with given sum K](https://takeuforward.org/data-structure/longest-subarray-with-given-sum-k/)*

```
Examples:

    Input Format: N = 3, k = 5, array[] = {2,3,5}
    Result: 2
    Explanation: The longest subarray with sum 5 is {2, 3}. And its length is 2.
    
    Input Format: N = 3, k = 5, array[] = {2,3,5}
    Result: 2
    Explanation: The longest subarray with sum 5 is {2, 3}. And its length is 2.
```

### Approach 1:  Brute Force

**Step 1:** Iterate the array with the starting index

**Step 2:** For every iteration of starting index, make `sum = 0`

**Step 3:** Within the first loop, iterate the array from starting index and mark it as last_index of the subarray.

**Step 4:** Sum all the elements while iterating the inner loop

**Step 5:** When `sum == k`, find the subarray length using `last_index - start_index + 1`

**Step 6:** Compare the new length with the longest subarray length available

```java
public class Solution {
    public static int getLongestSubarray(int[] nums, long k) {
        int maxLen = 0;
        for (int startIdx = 0; startIdx < nums.length; startIdx++) { 
            long sum = 0; 
            for (int lastIdx = startIdx; lastIdx < nums.length; lastIdx++) { 
                // add the current element to the subarray a[i...j-1]:
                sum += nums[lastIdx];

                if (sum == k)
                    maxLen = Math.max(maxLen, lastIdx - startIdx + 1);
            }
        }
        return maxLen;
    }
}
// Time Complexity: O(n ^ 2)
// Space Complexity: O(1)
```

### Approach 2: Better

**Step 1:** Declare a hashmap to store the prefix sums and the indices

**Step 2:** Iterate over the array

**Step 3:** Store the sum into the hashmap as <sum, index>

**Step 4:** Check if the <current_sum - k> value is present in hashmap

**Step 5:** If present, then get the difference in their indices.

**Step 6:** If length is greater, then put it in result.

```java
public class Solution {
    public int getLongestSubarray(int[] nums, long k) {
        Map<Long, Integer> preSumMap = new HashMap<>();
        long sum = 0;
        int maxLen = 0;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }
            
            long rem = sum - k;
            if (preSumMap.containsKey(rem)) {
                int len = i - preSumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }
            
            if (!preSumMap.containsKey(sum)) {
                preSumMap.put(sum, i);
            }
        }
        return maxLen;
    }
}
// Time Complexity: O(n * log n)
// Space Complexity: O(n)
```

### Approach 3: Optimal

**Step 1:** Initially startIdx and lastIdx will be 0.

**Step 2:** Move the lastIdx if `sum <= k`, when `sum == k` check the length of subarray with current max

**Step 3:** Move startIdx if `sum > k`


```java
public class Solution {
    public int getLongestSubarray(int[] nums, long k) {
        int startIdx = 0, lastIdx = 0, maxLen = 0;
        long sum = nums[0];
        while(lastIdx < nums.length) {
            while(startIdx <= lastIdx && sum > k) {
                sum -= nums[startIdx];
                startIdx++;
            }
            if (sum == k) {
                maxLen = Math.max(maxLen, lastIdx - startIdx + 1);
            }
            lastIdx++;
            if (lastIdx < nums.length) {
                sum += nums[lastIdx];
            }
        }
        return maxLen;
    }
}
// Time Complexity: O(2n)
// Space Complexity: O(1)
```
---








