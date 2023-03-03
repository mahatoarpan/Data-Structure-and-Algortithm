package stack;

public class DynamicArrayStack {
    private static final String UNDERFLOW_EXCEPTION = "Stack is empty";
    private static final int CAPACITY = 16;
    protected int capacity;
    protected int[] stack;
    protected int top = -1;

    public DynamicArrayStack(){
        this(CAPACITY);
    }

    public DynamicArrayStack(int capacity) {
        this.capacity = capacity;
        stack = new int[capacity];
    }

    public int size() {
        return top + 1;
    }
    public boolean isEmpty() {
        return top < 0;
    }

    public void push(int data) throws StackException {
        if (size() == capacity) {
            expand();
        }
        top++;
        stack[top] = data;
    }

    public int peek() throws StackException {
        if (isEmpty()) {
            throw new StackException(DynamicArrayStack.UNDERFLOW_EXCEPTION);
        }
        return stack[top];
    }

    public int pop() throws StackException {
        if (isEmpty()) {
            throw new StackException(DynamicArrayStack.UNDERFLOW_EXCEPTION);
        }
        int deletedData = stack[top];
        top--;
        shrink();
        return deletedData;
    }

    private void expand() {
        int length = size();
        int[] newStack = new int[length << 1];
        // copy the old stack data to new stack
        System.arraycopy(stack,0,newStack,0,length);
        stack = newStack;
        this.capacity = this.capacity << 1;
    }

    /**
     * When the capacity is double the stack size, reduce the capacity to half
     */
    private void shrink() {
        int length = top + 1;
        if ((length << 1) == capacity ) {
            int[] newStack = new int[length];
            System.arraycopy(stack,0,newStack,0, length);
            stack = newStack;
            capacity = length;
        }
    }
}
