package array;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class IntersectionInTwoSortedArray {
    public int[] findIntersection(int[] arr1, int[] arr2) {
        List<Integer> resList = new ArrayList<>();
        int arr1Idx = 0, arr2Idx = 0;
        while (arr1Idx < arr1.length && arr2Idx < arr2.length) {
            if (arr1[arr1Idx] == arr2[arr2Idx]) {
                resList.add(arr1[arr1Idx]);
                arr1Idx++;
                arr2Idx++;
            } else if (arr1[arr1Idx] < arr2[arr2Idx]) {
                arr1Idx++;
            } else {
                arr2Idx++;
            }
        }
        return resList.stream().mapToInt(Integer::intValue).toArray();
    }
}
