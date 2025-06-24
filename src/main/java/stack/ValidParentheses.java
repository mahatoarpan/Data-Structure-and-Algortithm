package stack;

import java.util.ArrayDeque;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        if (s == null || s.isEmpty())   return true;
        ArrayDeque<Character> st = new ArrayDeque<>();
        for(int i =0 ;i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(')   st.push(')');
            else if(ch == '{')  st.push('}');
            else if(ch == '[')  st.push(']');
            else if(st.isEmpty() || st.pop() != ch) return false;
        }
        return st.isEmpty();
    }
}
