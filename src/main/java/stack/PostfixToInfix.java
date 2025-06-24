package stack;

import java.util.ArrayDeque;

public class PostfixToInfix {
    public String postfixToInfix(String s) {
        ArrayDeque<String> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                stack.push("" + ch);
            } else {
                String right = stack.pop();
                String left = stack.pop();
                stack.push("(" + left + ch + right + ")");
            }
        }
        return stack.pop();
    }
}
