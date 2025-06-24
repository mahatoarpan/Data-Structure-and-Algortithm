package queue;

public class QueueArrayImpl {
    private static final String OVERFLOW_EXCEPTION_MSG = "Queue Overflow Exception";
    private static final String UNDERFLOW_EXCEPTION_MSG = "Queue Underflow Exception";

    private int[] queue;
    private int front, rear;

    public QueueArrayImpl(int capacity) {
        queue = new int[capacity];
        front = -1;
        rear = -1;
    }

    public void push(int data) throws QueueException {
        if (rear + 1 == queue.length) {
            throw new QueueException(OVERFLOW_EXCEPTION_MSG);
        }
        if(rear == -1) {
            front = 0;
        }
        queue[++rear] = data;
    }

    public int pop() throws QueueException {
        if(front == -1) {
            throw new QueueException(UNDERFLOW_EXCEPTION_MSG);
        }
        int popped = queue[front];
        front++;
        return popped;
    }

    public int peek() throws QueueException {
        if(front == -1) {
            throw new QueueException(UNDERFLOW_EXCEPTION_MSG);
        }
        return queue[front];
    }
}
