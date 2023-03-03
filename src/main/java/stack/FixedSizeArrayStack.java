package stack;

public class FixedSizeArrayStack {
    private static final String UNDERFLOW_EXCEPTION = "Stack is empty";
    private static final String OVERFLOW_EXCEPTION = "Stack is full";
    protected int capacity;
    // Default array capacity
    private static final int CAPACITY = 10;
    protected int[] stack;
    protected  int top = -1;

    public FixedSizeArrayStack(){
        this(CAPACITY);
    }

    public FixedSizeArrayStack(int capacity) {
        this.capacity = capacity;
        stack = new int[capacity];
    }

    public int size(){
        return top + 1;
    }
    public boolean isEmpty() {
        return top < 0;
    }
    public boolean isFull() {
        return (top+1) == capacity;
    }
    /*
     * Insert an element at the top of the stack
     */
    public void push(int data) throws StackException {
        if (isFull()) {
            throw new StackException(OVERFLOW_EXCEPTION);
        }
        top++;
        stack[top] = data;
    }

    /*
     * Inspects the element at the top of the stack
     */
    public int top() throws StackException {
        if (isEmpty()){
            throw new StackException(UNDERFLOW_EXCEPTION);
        }
        return stack[top];
    }

    /*
     * Removes the top element from the stack
     */
    public int pop() throws StackException {
        if (isEmpty()) {
            throw new StackException(UNDERFLOW_EXCEPTION);
        }
        int removedData = stack[top];
        stack[top] = Integer.MIN_VALUE;
        top--;
        return removedData;
    }

    public String toString() {
        String s;
        s = "[";
        if (!isEmpty()) {
            s += stack[0];
            for (int i = 1; i <= top; i++) {
                s += "," + stack[i];
            }
        }
        s += "]";
        return s;
    }
}
