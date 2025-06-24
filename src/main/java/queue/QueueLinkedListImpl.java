package queue;

import linked_list.singly_linked_list.Node;

public class QueueLinkedListImpl {
    Node front, rear;

    public boolean isEmpty() {
        return front == null;
    }

    public void enQueue(int data) {
        Node node = new Node(data);
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
        Node deletedNode = front;
        front = front.getNext();
        deletedNode.setNext(null);
        if (isEmpty()) {
            // check for the condition when queue gets empty after deQueue operation
            rear = null;
        }
        return deletedNode.getData();
    }

}
