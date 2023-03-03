package queue;

public class CircularQueueArrayImpl {
    private static final int CAPACITY = 16;
    private static final String OVERFLOW_EXCEPTION_MSG = "Queue Overflow Exception";
    private static final String UNDERFLOW_EXCEPTION_MSG = "Queue Underflow Exception";
    private int capacity;
    private int size;
    private int front, rear;
    private int[] queue;

    public CircularQueueArrayImpl() {
        this(CAPACITY);
    }

    public CircularQueueArrayImpl(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public void enQueue(int data) throws QueueException {
        if (isFull()) {
            throw new QueueException(OVERFLOW_EXCEPTION_MSG);
        }
        size++;
        queue[rear] = data;
        rear = (rear + 1) % capacity;
    }

    public int deQueue() throws QueueException {
        if (isEmpty()) {
            throw new QueueException(UNDERFLOW_EXCEPTION_MSG);
        }
        size--;
        int deletedData = queue[front];
        queue[front] = Integer.MIN_VALUE;
        front = (front + 1) % capacity;
        return deletedData;
    }

    public int front() throws QueueException {
        if (isEmpty()) {
            throw new QueueException(UNDERFLOW_EXCEPTION_MSG);
        }
        return queue[front];
    }

    public int rear() throws QueueException {
        if (isEmpty()) {
            throw new QueueException(UNDERFLOW_EXCEPTION_MSG);
        }
        return queue[front];
    }
}
