## Q1. Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).

*leetcode - [Implement Stack using Queues](https://leetcode.com/problems/implement-stack-using-queues/description/)*

Implement the MyStack class:

* `void push(int x)`: Pushes element x to the top of the stack.
* `int pop()`: Removes the element on the top of the stack and returns it.
* `int top()`: Returns the element on the top of the stack.
* `boolean empty()`: Returns true if the stack is empty, false otherwise.

```
Examples:

Input
["MyStack", "push", "push", "top", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 2, 2, false]

Explanation
MyStack myStack = new MyStack();
myStack.push(1);
myStack.push(2);
myStack.top(); // return 2
myStack.pop(); // return 2
myStack.empty(); // return False
```

### Approach 1: Using 2 queues

```java
class MyStack {
    Queue<Integer> q1,q2;
    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q2.add(x);
        while(!q1.isEmpty()){
            q2.add(q1.remove());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q1.remove();
    }
    
    /** Get the top element. */
    public int top() {
        return q1.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}
// Time Complexity: [push: O(n), pop: O(1), top: O(1), empty: O(1)]
// Space Complexity: O(2n)
```

### Approach 2: Using single queue

```java
class MyStack {

    private Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }
    
    public void push(int x) {   
        queue.add(x);
        for(int i = 0 ; i < queue.size() - 1; i++) {
            queue.add(queue.remove());
        }
    }
    
    public int pop() {
        return queue.remove();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}
// Time Complexity: [push: O(n), pop: O(1), top: O(1), empty: O(1)]
// Space Complexity: O(n)
```






