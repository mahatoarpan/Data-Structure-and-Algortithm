package stack;

import linked_list.singly_linked_list.Node;

public class LinkedListStack {
    private static final String UNDERFLOW_EXCEPTION = "Stack is empty";
    private Node top;

    public LinkedListStack() {
        top = null;
    }

    public void push(int data) {
        Node temp = new Node(data);
        temp.setNext(top);
        top = temp;
    }

    public int top() throws StackException {
        if (isEmpty()) {
            throw new StackException(LinkedListStack.UNDERFLOW_EXCEPTION);
        }
        return top.getData();
    }

    public int pop() throws StackException {
        if (isEmpty()) {
            throw new StackException(LinkedListStack.UNDERFLOW_EXCEPTION);
        }
        Node deletedNode = top;
        top = top.getNext();
        deletedNode.setNext(null);
        return deletedNode.getData();
    }

    private boolean isEmpty() {
        return top == null;
    }

}
