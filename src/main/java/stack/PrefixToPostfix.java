package stack;

import java.util.ArrayDeque;

public class PrefixToPostfix {
    public String postfixToPrefix(String s){
        ArrayDeque<String> stack = new ArrayDeque<>();
        for(int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                stack.push("" + ch);
            } else {
                String left = stack.pop();
                String right = stack.pop();
                stack.push(left + right + ch);
            }
        }
        return stack.pop();
    }
}
