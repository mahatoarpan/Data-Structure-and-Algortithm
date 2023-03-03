package stack;

import linked_list.ListNode;

public class LinkedListStack {
    private static final String UNDERFLOW_EXCEPTION = "Stack is empty";
    private ListNode top;

    public LinkedListStack() {
        top = null;
    }

    public void push(int data) {
        ListNode temp = new ListNode(data);
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
        ListNode deletedNode = top;
        int deletedData = deletedNode.getData();
        top = top.getNext();
        deletedNode = null;
        return deletedData;
    }

    private boolean isEmpty() {
        return top == null;
    }

}
