## Q1. Given a valid parentheses string `s`, consider its primitive decomposition: `s = P1 + P2 + ... + Pk`, where `Pi` are primitive valid parentheses strings. Return `s` after removing the outermost parentheses of every primitive string in the primitive decomposition of `s`.

*leetcode - [Remove Outermost Parentheses](https://leetcode.com/problems/remove-outermost-parentheses/description/)*

```
Examples:

Input: s = "(()())(())"
Output: "()()()"
Explanation: 
The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
After removing outer parentheses of each part, this is "()()" + "()" = "()()()".

Input: s = "(()())(())(()(()))"
Output: "()()()()(())"
Explanation: 
The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".

Input: s = "()()"
Output: ""
Explanation: 
The input string is "()()", with primitive decomposition "()" + "()".
After removing outer parentheses of each part, this is "" + "" = "".
```

### Approach 1

**Step 1:** Initialize stack to store `(`.

**Step 2:** Iterate over the input string.

**Step 3:** If `string.charAt(i) = '('`, store it in stack. If `stack.size() > 1` add the character to result

**Step 4:** Else if `string.charAt(i) = ')'`, store the character in result if `stack.size() > 1`. Pop the topmost from the stack.
```java
public class Solution {
    public String removeOutermostParentheses(String s) {
        StringBuilder builder = new StringBuilder();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.add(ch);
                if (stack.size() > 1) {
                    builder.append(ch);
                }
            } else {
                if (stack.size() > 1) {
                    builder.append(ch);
                }
                stack.pop();
            }
        }
        return builder.toString();
    }
}
// Time Complexity: O(n)
// Space Complexity: O(n)
```

### Approach 2:

*Instead of having a stack we will count the occurrences of '('*

```java
class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder builder = new StringBuilder();
        int leftParenthesesCounter = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                leftParenthesesCounter++;
                if (leftParenthesesCounter > 1) {
                    builder.append(ch);
                }
            } else {
                if (leftParenthesesCounter > 1) {
                    builder.append(ch);
                }
                leftParenthesesCounter--;
            }
        }
        return builder.toString();
    }
}
// Time Complexity: O(n)
// Space Complexity: O(1)
```

## Q2. You are given a string num, representing a large integer. Return the largest-valued odd integer (as a string) that is a non-empty substring of num, or an empty string "" if no odd integer exists.

*leetcode - [Largest Odd Number in String](https://leetcode.com/problems/largest-odd-number-in-string/description/)*

```
Examples:

Input: num = "52"
Output: "5"
Explanation: The only non-empty substrings are "5", "2", and "52". "5" is the only odd number.

Input: num = "4206"
Output: ""
Explanation: There are no odd numbers in "4206".

Input: num = "35427"
Output: "35427"
Explanation: "35427" is already an odd number.
```

### Approach 1:

**Step 1:** Iterate through the string from right to left.

**Step 2:** If the last digit is odd, return the entire string as it is already the largest odd number;

**Step 3:** If the last digit is even, keep moving left until an odd digit is found.

**Step 4:** Return the substring from the beginning of the string to the index where the first odd digit is encountered.

```java
class Solution {
    public String largestOddNumber(String num) {
        int index = num.length() - 1;
        while(index >= 0) {
            int number = num.charAt(index) - '0';
            if(number % 2 == 1) {
                return num.substring(0, index + 1);
            }
            index--;
        }
        return "";
    }
}
// Time Complexity: O(n)
// Space Complexity: O(1)
```

## Q3. Given an input string s, reverse the order of the words.

*leetcode - [Reverse Words in a String](https://leetcode.com/problems/reverse-words-in-a-string/description/)*

```
Examples:

Input: s = "the sky is blue"
Output: "blue is sky the"

Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.

Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
```

### Approach 1: Brute Force

**Step 1:** Split the string using `s.spilt(" ")` and store in array.

**Step 2:** Iterate over the array from right to left.

**Step 3:** If `strArr[i]` is not white spaces then add it to result.

```java
class Solution {
    public String reverseWords(String s) {
        String[] strArr = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for(int i = strArr.length - 1; i >= 0; i--) {
            if(strArr[i].trim != "") {
                sb.append(strArr[i]).append(" ");
            }
        }
        return sb.toString().trim();
    }
}
// Time Complexity: O(n)
// Space Complexity: O(n)
```

### Approach 2: Better

**Step 1:** Add an extra space at the beginning of the string s. This ensures that the first word is processed properly when traversing from the end.

**Step 2:** Set two pointers - rearPointer (end of a word) and frontPointer (used to find the start of the word)

**Step 3:** Start a loop from rear end of the string and continue until frontPointer is within the string bounds.

**Step 4:** If `charAt(frontPointer) != ' '`, then we are at the rear end of a word. Set rearPointer to current frontPointer.

**Step 5:** Move frontPointer until we hit a space.

**Step 6:** Extract the word - `s.substring(frontPointer + 1, rearPointer + 1)` and append to the result.

```java
class Solution {
    public String reverseWords(String s) {
        s = " " + s;
        StringBuilder sb = new StringBuilder();
        int frontPointer = s.length() - 1, rearPointer = s.length() - 1;
        while(frontPointer >= 0) {
            char ch = s.charAt(frontPointer);
            if(ch != ' ') {
                // when we are the rear end of a word
                rearPointer = frontPointer;
                while(frontPointer >= 0 && s.charAt(frontPointer) != ' ') {
                    frontPointer--;
                }
                sb.append(s.substring(frontPointer + 1, rearPointer + 1) + " ");
            } else {
                frontPointer--;
            }
        }
        
        return sb.toString().trim();
    }
}
// Time Complexity: O(n)
// Space Complexity: O(1)
```

## Q4. Write a function to find the longest common prefix string amongst an array of strings.

*leetcode -[Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix/description/)*

```
Examples;

Input: strs = ["flower","flow","flight"]
Output: "fl"

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
```

### Approach 1: Brute Force

**Step 1:** Sort the words in ascending order.

**Step 2:** Loop through each character in the shortest string.

**Step 3:** Compare the ith character of first and last string. If characters match, put it into result, else return.

```java
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder();
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length-1];
        for (int i=0; i<Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return res.toString();
            }
            res.append(first.charAt(i));
        }
        return res.toString();
    }
}
// Time Complexity: O(kn * log n) - k is the maximum length of a string
// Space Complexity: O(1)
```

### Approach 2: Optimal

**Step 1:** Assume the first string is the longest common prefix for now.

**Step 2:** Loop Through the Remaining Strings.

**Step 3:** Compare characters of result with current string until the end of either string is reached or characters mismatch

**Step 4:** Once mismatched character is found, eleminate the rest from the result

```java
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String res = strs[0];  // Start with the first string
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            // Compare res with strs[i] character by character
            while (j < res.length() && j < strs[i].length() && res.charAt(j) == strs[i].charAt(j)) {
                j++;
            }
            // Trim res to the matched prefix
            res = res.substring(0, j);

            // If at any point prefix is empty, no need to continue
            if (res.isEmpty()) return "";
        }
        return res;
    }
}
// Time Complexity: O(n*k)
// Space Complexity: O(1)
```





