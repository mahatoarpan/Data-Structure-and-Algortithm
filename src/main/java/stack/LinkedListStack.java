package stack;

import linked_list.singly_linked_list.LLNode;

public class LinkedListStack {
    private static final String UNDERFLOW_EXCEPTION = "Stack is empty";
    private LLNode top;

    public LinkedListStack() {
        top = null;
    }

    public void push(int data) {
        LLNode temp = new LLNode(data);
        temp.setNext(top);
        top = temp;
    }

    public int peek() throws StackException {
        if (isEmpty()) {
            throw new StackException(LinkedListStack.UNDERFLOW_EXCEPTION);
        }
        return top.getData();
    }

    public int pop() throws StackException {
        if (isEmpty()) {
            throw new StackException(LinkedListStack.UNDERFLOW_EXCEPTION);
        }
        LLNode deletedNode = top;
        int deletedData = deletedNode.getData();
        top = top.getNext();
        deletedNode = null;
        return deletedData;
    }

    private boolean isEmpty() {
        return top == null;
    }

}
