package stack;

import java.util.ArrayDeque;

public class PostfixToPrefix {
    public String postfixToPrefix(String s){
        ArrayDeque<String> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                stack.push("" + ch);
            } else {
                String right = stack.pop();
                String left = stack.pop();
                stack.push( "" + ch + left + right);
            }
        }
        return stack.pop();
    }
}
