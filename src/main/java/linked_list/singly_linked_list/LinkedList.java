package linked_list.singly_linked_list;

import linked_list.LinkedListException;

import java.util.ArrayList;
import java.util.List;

public class LinkedList {
    private final static String EMPTY_LINKED_LIST_EXCEPTION = "Linked List is empty";
    Node head;
    Node tail;
    int size = 0;

    public boolean isEmpty() {
        return head == null;
    }

    public void insertAtBeginning(Node node) {
        node.setNext(head);
        if (head == null) {
            tail = node;
        }
        head = node;
        size++;
    }

    public void insertAtEnd(Node node) {
        if (isEmpty()) {
            head = node;
        } else {
            tail.setNext(node);
        }
        tail = node;
        size++;
    }

    public void insertAt(Node node, int position) {
        if (isEmpty()) {
            head = node;
            tail = node;
        } else if(position <= 0) {
            insertAtBeginning(node);
        } else if (position > size) {
            insertAtEnd(node);
        } else {
            Node temp = head;
            for (int i = 0; i < position; i++) {
                temp = temp.getNext();
            }
            node.setNext(temp.getNext());
            temp.setNext(node);
        }
        size++;
    }

    public Node removeFromBeginning() throws LinkedListException {
        if (isEmpty()) {
            throw new LinkedListException(EMPTY_LINKED_LIST_EXCEPTION);
        }
        Node deletedNode = head;
        head = head.getNext();
        deletedNode.setNext(null);
        if (size == 1) {
            tail = head;
        }
        size--;
        return deletedNode;
    }

    public Node removeFromEnd() throws LinkedListException {
        if (isEmpty()) {
            throw new LinkedListException(EMPTY_LINKED_LIST_EXCEPTION);
        }
        Node deleteNode;
        if (head.getNext() == null) {
            deleteNode = removeFromBeginning();
        } else {
            Node temp = head.getNext();
            Node previousToTemp = head;
            while (temp.getNext() != null) {
                previousToTemp = temp;
                temp = temp.getNext();
            }
            deleteNode = temp;
            previousToTemp.setNext(null);
            tail = previousToTemp;
        }
        size--;
        return deleteNode;
    }

    public Node removeAt(int position) throws LinkedListException {
        if (isEmpty()) {
            throw new LinkedListException(EMPTY_LINKED_LIST_EXCEPTION);
        }
        Node deletedNode;
        if (position <= 0) {
            deletedNode = removeFromBeginning();
        } else if(position >= size) {
            deletedNode = removeFromEnd();
        } else {
            Node temp = head;
            for (int i = 0; i < position; i++) {
                temp = temp.getNext();
            }
            deletedNode = temp.getNext();
            temp.setNext(deletedNode.getNext());
        }
        size--;
        return deletedNode;
    }

    public List<Integer> getList() throws LinkedListException {
        if (isEmpty()) {
            throw new LinkedListException(EMPTY_LINKED_LIST_EXCEPTION);
        }
        Node currentNode = head;
        List<Integer> list = new ArrayList<>();
        while (currentNode != null) {
            list.add(currentNode.getData());
            currentNode = currentNode.getNext();
        }
        return list;
    }

    public void delete() {
        head = null;
        tail = null;
    }
}
