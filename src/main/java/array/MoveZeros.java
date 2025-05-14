package array;

import java.util.Arrays;

// https://leetcode.com/problems/move-zeroes/description/
// 283. Move Zeroes
public class MoveZeros {
    public static void main(String[] args) {
        int[] arr = {0,1,0,3,12};
        System.out.println("Original Array: " + Arrays.toString(arr));
        moveZeros(arr);
        System.out.println("Result Array: " + Arrays.toString(arr));
    }

    private static void moveZeros(int[] arr) {
        int i = 0;
        for(int j = 0; j < arr.length; j++){
            if(arr[j] != 0){
                arr[i] = arr[j];
                i++;
            }
        }
        while(i < arr.length){
            arr[i++] = 0;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
