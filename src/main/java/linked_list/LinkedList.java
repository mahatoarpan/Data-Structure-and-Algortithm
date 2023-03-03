package linked_list;

import java.util.List;

public class LinkedList {
    private final static String EMPTY_LINKED_LIST = "Linked List is empty";
    ListNode head;
    int size = 0;

    public boolean isEmpty() {
        return head == null;
    }
    public void insertAtBeginning(ListNode node) {
        if (isEmpty()) {
            head = node;
            head.setNext(null);
        } else  {
            node.setNext(head);
            head = node;
        }
        size++;
    }

    public void insertAtEnd(ListNode node) {
        if (isEmpty()) {
            head = node;
            head.setNext(null);
        } else {
            ListNode temp  = head;
            while(temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(node);
        }
        size++;
    }

    public void insert(ListNode node, int position) {
        if (isEmpty()) {
            head = node;
            head.setNext(null);
        }
        else if (position <= 0)      insertAtBeginning(node);
        else if (position >= size)   insertAtEnd(node);
        else {
            ListNode temp = head;
            for (int i = 0; i < position; i++) {
                temp = temp.getNext();
            }
            node.setNext(temp.getNext());
            temp.setNext(node);
        }
        size++;
    }

    public ListNode deleteFromBeginning() throws LinkedListException {
        if (isEmpty()) {
            throw new LinkedListException(LinkedList.EMPTY_LINKED_LIST);
        }
        ListNode deletedNode = head;
        head = head.getNext();
        size--;
        return deletedNode;
    }

    public ListNode deleteFromEnd() throws LinkedListException {
        if (isEmpty()){
            throw new LinkedListException(LinkedList.EMPTY_LINKED_LIST);
        }
        ListNode deletedNode;
        if (head.getNext() == null) {
            // there is only 1 node
            deletedNode = deleteFromBeginning();
        } else {
            ListNode temp = head.getNext();
            ListNode prevToTemp = head;
            while(temp.getNext() != null) {
                prevToTemp = temp;
                temp = temp.getNext();
            }
            deletedNode = temp;
            prevToTemp.setNext(null);
        }
        size--;
        return  deletedNode;
    }

    public void removeMatched(ListNode node) throws LinkedListException {
        if (isEmpty()){
            throw new LinkedListException(LinkedList.EMPTY_LINKED_LIST);
        }
        if (head.equals(node)) {
            head = head.getNext();
        } else {
            ListNode temp = head.getNext();
            ListNode prevToTemp = head;
            while(temp.getNext() != null) {
                if (temp.equals(node)) {
                    prevToTemp.setNext(temp.getNext());
                    temp.setNext(null);
                    size--;
                    break;
                }
                prevToTemp = temp;
                temp = temp.getNext();
            }
        }

    }
}
