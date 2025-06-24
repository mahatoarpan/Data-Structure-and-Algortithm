package queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    private static final String OVERFLOW_EXCEPTION_MSG = "Queue Overflow Exception";
    private static final String UNDERFLOW_EXCEPTION_MSG = "Queue Underflow Exception";
    private Queue<Integer> queue;

    public StackUsingQueue() {
        queue = new LinkedList<>();
    }

    public void push(int data) {
        queue.add(data);
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.remove());
        }
    }

    public int top() throws QueueException {
        if(queue.isEmpty()) {
            throw new QueueException(UNDERFLOW_EXCEPTION_MSG);
        }
        return queue.peek();
    }

    public int pop() throws QueueException {
        if(queue.isEmpty()) {
            throw new QueueException(UNDERFLOW_EXCEPTION_MSG);
        }
        return queue.remove();
    }
}
