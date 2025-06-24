package stack;

import java.util.Stack;

public class QueueUsingStack {
    private final Stack<Integer> stack1;
    private final Stack<Integer> stack2;

    public QueueUsingStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int data) {
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        stack1.push(data);
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }

    public int pop() throws StackException {
        if(stack1.isEmpty()) {
            throw new StackException("Stack is Empty");
        }
        return stack1.pop();
    }

    public int peek() throws StackException {
        if(stack1.isEmpty()) {
            throw new StackException("Stack is Empty");
        }
        return stack1.peek();
    }


}
