package stack;

public class StackArrayImpl {
    private int[] stack;
    private int top;

    public StackArrayImpl(int size) {
        stack = new int[size];
        top = -1;
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty(){
        return top < 0;
    }

    public int peek() throws StackException {
        if (isEmpty()) {
            throw new StackException("Stack is Empty");
        }
        return stack[top];
    }

    public void push(int element) throws StackException {
        if (size() == stack.length) {
            throw new StackException("Stack is Full");
        }
        top++;
        stack[top] = element;
    }

    public int pop() throws StackException {
        if (isEmpty()) {
            throw new StackException("Stack is Empty");
        }
        int element = stack[top];
        stack[top] = 0;
        top--;
        return element;
    }
}
