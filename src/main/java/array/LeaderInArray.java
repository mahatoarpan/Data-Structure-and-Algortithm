package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeaderInArray {
    public int[] leader(int[] nums) {
        int maxSoFar = Integer.MIN_VALUE;
        List<Integer> resList = new ArrayList<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > maxSoFar) {
                maxSoFar = nums[i];
                resList.add(maxSoFar);
            }
        }
        Collections.reverse(resList);
        return resList.stream().mapToInt(i->i).toArray();
    }
}
