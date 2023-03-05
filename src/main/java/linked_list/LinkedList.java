package linked_list;

import java.util.List;

public class LinkedList {
    private final static String EMPTY_LINKED_LIST_EXCEPTION = "Linked List is empty";
    ListNode head;
    int size = 0;

    public boolean isEmpty() {
        return head == null;
    }
    public void insertAtBeginning(ListNode node) {
        node.setNext(head);
        head = node;
        size++;
    }

    public void insertAtEnd(ListNode node) {
        if (isEmpty()) {
            head = node;
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
        }
        else if (position <= 0)      insertAtBeginning(node);
        else if (position > size)   insertAtEnd(node);
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

    public ListNode removeFromBeginning() throws LinkedListException {
        if (isEmpty()) {
            throw new LinkedListException(EMPTY_LINKED_LIST_EXCEPTION);
        }
        ListNode deletedNode = head;
        head = head.getNext();
        deletedNode.setNext(null);
        size--;
        return deletedNode;
    }

    public ListNode removeFromEnd() throws LinkedListException {
        if (isEmpty()){
            throw new LinkedListException(EMPTY_LINKED_LIST_EXCEPTION);
        }
        ListNode deletedNode;
        if (head.getNext() == null) {
            // there is only 1 node
            deletedNode = removeFromBeginning();
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
            throw new LinkedListException(EMPTY_LINKED_LIST_EXCEPTION);
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

    public ListNode remove(int position) throws LinkedListException {
        if (isEmpty()){
            throw new LinkedListException(EMPTY_LINKED_LIST_EXCEPTION);
        }
        ListNode deletedNode;
        if (position <= 0){
            deletedNode = removeFromBeginning();
        } else if (position >= size) {
            deletedNode = removeFromEnd();
        } else {
            ListNode temp = head;
            for (int i = 1; i < position; i++) {
                temp = temp.getNext();
            }
            deletedNode = temp.getNext();
            temp.setNext(deletedNode.getNext());
        }
        size--;
        return deletedNode;
    }

    public void delete() {
        head = null;
    }
}
