package array;
// https://leetcode.com/problems/missing-number/description/
// 268. Missing Number
public class MissingNumber {

    public int findMissingNumber(int[] arr) {
        int missingNumber = 0;
        for (int i = 0; i < arr.length; i++) {
            missingNumber = missingNumber ^ arr[i] ^ (i + 1);
        }
        return missingNumber;
    }
}
