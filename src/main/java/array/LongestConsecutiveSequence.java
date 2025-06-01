package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
        public int longestConsecutive(int[] nums) {

            Set<Integer> set = new HashSet<>();
            int longest = 0;
            for (int num : nums) {
                set.add(num);
            }

            for (int num : nums) {
                if (set.contains(num - 1)) {
                    continue;
                }
                int count = 0;
                int temp = num;
                while(set.contains(temp)) {
                    count++;
                    set.remove(temp);
                    temp++;
                }
                longest = Math.max(longest, count);
            }
            return longest;
        }
}
