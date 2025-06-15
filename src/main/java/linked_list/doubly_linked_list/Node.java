package linked_list.doubly_linked_list;

public class Node {
    private int data;
    private Node previous;
    private Node next;

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node previous, Node next) {
        this.data = data;
        this.previous = previous;
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
