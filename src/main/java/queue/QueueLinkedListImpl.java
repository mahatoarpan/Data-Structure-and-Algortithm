package queue;

import linked_list.ListNode;

public class QueueLinkedListImpl {
    ListNode front, rear;

    public boolean isEmpty() {
        return front == null;
    }

    public void enQueue(int data) {
        ListNode node = new ListNode(data);
        if (isEmpty()) {
            front = node;
        } else {
            rear.setNext(node);
        }
        rear = node;
    }

    public int deQueue() throws QueueException {
        if (isEmpty()){
            throw new QueueException("Queue Underflow Exception");
        }
        ListNode deletedNode = front;
        front = front.getNext();
        int deletedData = deletedNode.getData();
        deletedNode = null;
        if (isEmpty()) {
            // check for the condition when queue gets empty after deQueue operation
            rear = null;
        }
        return deletedData;
    }

}
