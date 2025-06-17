package String;

// https://leetcode.com/problems/rotate-string/
// 796. Rotate String
public class RotateString {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) {
            return false;
        }
        String temp = goal + goal;
        System.out.println(temp);
        return temp.contains(s);
    }
}
