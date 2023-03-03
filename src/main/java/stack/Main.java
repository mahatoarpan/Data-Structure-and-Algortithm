package stack;

public class Main {
    public static void main(String[] args) throws StackException {
        LinkedListStack stack = new LinkedListStack();
        int arr[] = new int[18];
        for (int ele : arr) {
            stack.push(ele);
        }
    }
}
