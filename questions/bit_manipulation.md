## Q1. Swap two numbers

```
Example:

input: a=2, b=5
output: a=5, b=2
```

### Approach

**Step 1:** XOR a and b and store it in a.

    a = a ^ b

**Step 2:** XOR a and b and store it in b. Now b will have the value of a.

    b = a ^ b
    b = (a ^ b) ^ b -- // b ^ b will cancel out
    b = a

**Step 3:** XOR a and b and store it in a. Now a will have the value of b.
    
    a = a ^ b
    a = (a ^ b) ^ a -- // a ^ a will cancel out
    a = b


## Q2. Check if the ith bit is set or not

```
Example

input: n=13, i=2
output = true
```

### Approach 1: Brute Force

**Step 1:** Get the binary representation of n.

**Step 2:** Check if the ith number from back is 1 or not, starting with 0.

```java
public class Solution {
    public boolean checkIthSetBit(int n, int i) {
        String bin = getBinRepresentation(n);
        return bin.charAt(bin.length() - 1 - i) == '1';
    }
    
    private String getBinRepresentation(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            sb.append(n % 2);
            n = n / 2;
        }
        return sb.reverse().toString();
    }
}
// Time Complexity: O(log n)
// Space Complexity: O(log n)
```

### Approach 2: Optimal

**Step 1:** Right shift the number by i.

    n = 13, binary representation = 1101
    1101 >> 2 = 0011

**Step 2:** take the right shift result and perform & with 1. If it gives 1 then its set else not.

    0011 & 0001 = 0001


```java
public class Solution {
    public boolean checkIthSetBit(int n, int i) {
        return (n>>i & 1) == 1;
    }
}
```

## Given an integer n, return true if it is a power of two. Otherwise, return false.

```
Examples

Input: n = 1
Output: true
Explanation: 20 = 1

Input: n = 16
Output: true
Explanation: 24 = 16
```

### Approach 1:

**Step 1:** Convert the number to binary.

**Step 2:** Check if the 0th character is 1 and rest all are 0. Then its power of 2 else not.

```java
public class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            sb.append(n % 2);
            n = n / 2;
        }
        String s = sb.reverse().toString();
        return s.charAt(0) == '1' && !s.substring(1).contains("1");
    }
}
// Time Complexity: O(log n)
// Space Complexity: O(log n)
```

### Approach 2: Optimal

Use bitwise AND operator between the number and number - 1. If its 0 then the number is power of 2.

```java
class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) {
            return false;
        }
        return (n & (n-1)) == 0;
    }
}
```

