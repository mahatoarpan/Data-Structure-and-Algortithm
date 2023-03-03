package String;

public class CircularRotation {

    public boolean isCircularRotated(String s1, String s2) {

        if (s1.length() == s2.length()) {
            for(int i = 0; i < s1.length(); i++) {
                String firstHalf = s1.substring(i);
                if (s2.contains(firstHalf)) {
                    int index = s2.indexOf(firstHalf);
                    if (s2.substring(index + firstHalf.length()).equals(s1.substring(0,i))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
