package array;

import java.util.Arrays;

public class UnionOfTwoSortedArrays {
    public static void main(String[] args) {
        int arr1[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int arr2[] = {2, 3, 4, 4, 5, 11, 12};
        System.out.println("Union: " + Arrays.toString(findUnion(arr1, arr2)));
    }

    private static int[] findUnion(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int arr1Index = 0, arr2Index = 0, resIndex = 0;
        while (arr1Index < arr1.length && arr2Index < arr2.length) {
            if(arr1[arr1Index] <= arr2[arr2Index]) {
                result[resIndex] = arr1[arr1Index];
                resIndex++;
                arr1Index++;
            } else {
                result[resIndex] = arr2[arr2Index];
                resIndex++;
                arr2Index++;
            }
        }

        while(arr1Index < arr1.length) {
            result[resIndex] = arr1[arr1Index];
            resIndex++;
            arr1Index++;
        }
        while(arr2Index < arr2.length) {
            result[resIndex] = arr2[arr2Index];
            resIndex++;
            arr2Index++;
        }
        return result;
    }
}
