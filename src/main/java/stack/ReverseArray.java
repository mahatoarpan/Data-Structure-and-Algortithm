package stack;

public class ReverseArray {

    public int[] reverse(int[] arr) throws StackException {
        StackArrayImpl stack = new StackArrayImpl(arr.length);
        int[] result = new int[arr.length];
        for (int ele : arr) {
            stack.push(ele);
        }
        for(int i = 0; i <arr.length; i++) {
            result[i] = stack.pop();
        }
        return result;
    }
}
