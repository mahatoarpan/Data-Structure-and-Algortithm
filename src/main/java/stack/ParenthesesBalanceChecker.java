package stack;

import java.util.Stack;

public class ParenthesesBalanceChecker {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0)   return true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ')') {
                if (!stack.isEmpty() && stack.peek() == '(')    stack.pop();
                else                                            return false;
            } else if (ch == '}') {
                if (!stack.isEmpty() && stack.peek() == '{')    stack.pop();
                else                                            return false;
            } else if (ch == ']') {
                if (!stack.isEmpty() && stack.peek() == '[')    stack.pop();
                else                                            return false;
            } else if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
