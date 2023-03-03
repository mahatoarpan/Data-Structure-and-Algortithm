package array;

import java.util.Arrays;
import java.util.HashSet;

public class FindTheDuplicateNumber {

    public int find_Approach1(int[] numArray) {
        int result = -1;
        Arrays.sort(numArray);
        for(int i = 0; i < numArray.length - 1; i++) {
            if(numArray[i] == numArray[i+1])    result = numArray[i];
        }
        return result;
    }

    public int find_Approach2(int[] numArray) {
        HashSet<Integer> set = new HashSet<>();
        int result = -1;
        for(int num : numArray) {
            if(set.contains(num)) {
                result = num;
                break;
            }
            set.add(num);
        }
        return result;
    }

    public int find_Approach3(int[] numArray) {
        int slowPointer = numArray[0];
        int fastPointer = numArray[0];

         do{
            slowPointer = numArray[slowPointer];
            fastPointer = numArray[numArray[fastPointer]];
        } while(fastPointer != slowPointer);

        fastPointer = numArray[0];
        while(fastPointer != slowPointer){
            slowPointer = numArray[slowPointer];
            fastPointer = numArray[fastPointer];
        }

        return slowPointer;
    }
}
