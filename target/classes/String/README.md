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
public class Solution {
    public String removeOutermostParentheses(String s) {
        StringBuilder builder = new StringBuilder();
        int leftParenthesesCounter = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                leftParenthesesCounter++;
            } else {
                if (leftParenthesesCounter > 1) {
                    int rightParenthesesCounter = leftParenthesesCounter - 1;
                    while(leftParenthesesCounter > 1) {
                        builder.append('(');
                        leftParenthesesCounter--;
                    }
                    while(rightParenthesesCounter > 0) {
                        builder.append(')');
                        rightParenthesesCounter--;
                    }
                } else if (leftParenthesesCounter == 1) {
                    leftParenthesesCounter = 0;
                }
            }
        }
        return builder.toString();
    }
}
// Time Complexity: O(n)
// Space Complexity: O(1)
```




