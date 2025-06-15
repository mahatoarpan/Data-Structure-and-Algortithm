package String;

import java.util.ArrayDeque;

// 1021. Remove Outermost Parentheses
// https://leetcode.com/problems/remove-outermost-parentheses/description/
public class RemoveOutermostParentheses {
    public String removeOutermostParentheses(String s) {
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
