package linked_list;

import java.util.ArrayList;
import java.util.List;

public class DoublyLinkedList {
    private DLLNode head;
    private DLLNode tail;
    private int size;

    public boolean isEmpty() {
        return head == null;
    }

    public List<Integer> getList() throws LinkedListException {
        if (isEmpty()){
            throw new LinkedListException("Empty List Exception");
        }
        DLLNode currentNode = head;
        List<Integer> list = new ArrayList<>();
        while (currentNode != null) {
            list.add(currentNode.getData());
            currentNode = currentNode.getNext();
        }
        return list;
    }

    public void insertAtHead(int data) {
        DLLNode node = new DLLNode(data);
        node.setNext(head);
        if (isEmpty()) {
            tail = node;
        } else {
            head.setPrevious(node);
        }
        head = node;
        size++;
    }

    public void insertAtTail(int data) {
        if (isEmpty()){
            insertAtHead(data);
        } else {
            DLLNode node = new DLLNode(data);
            tail.setNext(node);
            node.setPrevious(tail);
            tail = node;
        }
        size++;
    }

    public void insert(int data, int position) {
        if (position <= 0)      insertAtHead(data);
        else if (position > size)    insertAtTail(data);
        else {
            DLLNode node = new DLLNode(data);
            DLLNode temp = head;
            for (int i = 0; i < position; i++) {
                temp = temp.getNext();
            }
            node.setPrevious(temp);
            node.setNext(temp.getNext());
            node.getNext().setPrevious(node);
            temp.setNext(node);
        }
        size++;
    }

    public DLLNode removeHead() throws LinkedListException {
        if (head == null) {
            throw new LinkedListException("Empty List Exception");
        }
        DLLNode deletedNode = head;
        head = head.getNext();
        if (head != null) {
            head.setPrevious(null);
        } else {
            tail = null;
        }
        deletedNode.setNext(null);
        size--;
        return deletedNode;
    }

    public DLLNode removeTail() throws LinkedListException {
        if (tail == null ) {
            throw new LinkedListException("Empty List Exception");
        }
        DLLNode deletedNode = tail;
        tail = tail.getPrevious();
        if (tail != null) {
            tail.setNext(null);
        } else {
            head = null;
        }
        deletedNode.setPrevious(null);
        size--;
        return deletedNode;
    }

    public DLLNode remove(int position) throws LinkedListException {
        if (head == null) {
            throw new LinkedListException("Empty List Exception");
        } else  if (position <= 0) {
            return removeHead();
        } else if (position >= size) {
            return removeTail();
        } else {
            DLLNode temp = head;
            for (int i = 1; i < position; i++) {
                temp = temp.getNext();
            }
            DLLNode deletedNode = temp;
            temp.getNext().setPrevious(temp.getPrevious());
            temp.getPrevious().setNext(temp.getNext());
            return deletedNode;
        }
    }
}
