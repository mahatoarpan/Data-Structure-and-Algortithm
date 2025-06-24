## Q1. Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

*leetcode - [Implement Queue using Stacks](https://leetcode.com/problems/implement-queue-using-stacks/description/)*

Implement the MyQueue class:

* `void push(int x)`: Pushes element x to the back of the queue.
* `int pop()`:  Removes the element from the front of the queue and returns it.
* `int peek()`: Returns the element at the front of the queue.
* `boolean empty()`: Returns true if the queue is empty, false otherwise.

```

```

### Approach 1: Using 2 stacks

```java
class MyQueue {

    private final Stack<Integer> stack1;
    private final Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void push(int x) {
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        stack1.push(x);
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }
    
    public int pop() {
        return stack1.pop();
    }
    
    public int peek() {
        return stack1.peek();
    }
    
    public boolean empty() {
        return stack1.isEmpty();
    }
}
// Time Complexity: [push: O(2n), pop: O(1), top: O(1), empty: O(1)]
// Space Complexity: O(2n)
```

### Approach 2: Using single stack

```java
class MyQueue {
    Stack<Integer> st;
    /** Initialize your data structure here. */
    public MyQueue() {
        st = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if(st.isEmpty()){
            st.push(x);
            return;
        }
        int popped = st.pop();
        push(x);
        st.push(popped);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return st.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return st.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return st.isEmpty();
    }
}
// Time Complexity: [push: O(n), pop: O(1), top: O(1), empty: O(1)]
// Space Complexity: O(n)
```

## Q2. Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:
1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.
3. Every close bracket has a corresponding open bracket of the same type.

*leetcode - [Valid Parentheses](https://leetcode.com/problems/valid-parentheses/description/)*

```
Examples:

Input: s = "()"
Output: true

Input: s = "([])"
Output: true

Input: s = "(]"
Output: false
```

### Solution

**Step 1:** Initialize a stack to store parentheses

**Step 2:** Iterate over the string and extract the character at ith index

**Step 3:** If character == '(' store ')' in the stack.

**Step 4:** If character == '[' store ']' in the stack.

**Step 5:** If character == '{' store '}' in the stack.

**Step 6:** If any other character is there compare the top of the stack with current character.

```java
public class Solution {
    public boolean isValid(String s) {
        if (s == null || s.isEmpty())   return true;
        ArrayDeque<Character> st = new ArrayDeque<>();
        for(int i =0 ;i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(')   st.push(')');
            else if(ch == '{')  st.push('}');
            else if(ch == '[')  st.push(']');
            else if(st.isEmpty() || st.pop() != ch) return false;
        }
        return st.isEmpty();
    }
}
// Time Complexity: O(n)
// Space Complexity: O(n)
```

## Q3. Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:
* MinStack() initializes the stack object.
* void push(int val) pushes the element val onto the stack.
* void pop() removes the element on the top of the stack.
* int top() gets the top element of the stack.
* int getMin() retrieves the minimum element in the stack.

You must implement a solution with O(1) time complexity for each function.

```
Examples:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
```

### Approach 1

```java
import java.util.ArrayDeque;

class MinStack {
    private ArrayDeque<Pair> stack;

    public MinStack() {
        stack = new ArrayDeque<>();
    }

    public void push(int val) {
        Pair pair = new Pair(val, val);
        if (!stack.isEmpty()) {
            pair.min = Math.min(val, stack.peek().min);
        } 
        stack.push(pair);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return stack.peek().min;
    }
}

class Pair {
    int data;
    int min;
    
    public Pair(int data, int min) {
        this.data = data;
        this.min = min;
    }
}
```

### Approach 2

```java
class Node{
    int data;
    int min;
    Node next;

    Node(int data, int min){
        this.data = data;
        this.min = min;
        this.next = null;
    }
}
class MinStack {
    Node top;
    public MinStack() {
        top = null;
    }
    
    public void push(int val) {
        if(top == null){
            top = new Node(val,val);
        }else{
            int mini = Math.min(val,top.min);
            Node newNode = new Node(val,mini);
            newNode.next = top;
            top = newNode;
        }
    }
    
    public void pop() {
        if(top == null) return;
        top = top.next;
    }
    
    public int top() {
        return top.data;
    }
    
    public int getMin() {
        return top.min;
    }
}
```

## Q4. Given an infix expression, Your task is to convert the given infix expression to a postfix expression.

*TUF - [Infix to Postfix](https://takeuforward.org/data-structure/infix-to-postfix/)*

```
Examples:

Input: a+b*(c^d-e)^(f+g*h)-i
Output: abcd^e-fgh*+^*+i-

Input: (p+q)*(m-n)
Output: pq+mn-*
```

### Approach

**Step 1:** Scan the infix expression from left to right.

**Step 2:** If the scanned character is an operand, add it to answer.

**Step 3:** Else if the scanned character is '(' push it into the stack.

**Step 4:** Else if the scanned character is ')', pop the stack and add to answer until '(' is encountered. Discard both the parenthesis.

**Step 5:** Else pop all the operators from the stack which have a higher or equal  precedence than the current character. Then push the current operator to the stack.

**Step 6:** Once the complete infix string is scanned. Pop all the elements available in stack and add to answer.

```java
public class Solution {
    public String infixToPostfix(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetter(ch) || Character.isDigit(ch)) {
                sb.append(ch);
            } else if (ch == '('){
                stack.push(ch);
            } else if (ch == ')') {
                while(!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop();
            } else {
                while(!stack.isEmpty() && priority(ch) <= priority(stack.peek())) {
                    sb.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    private int priority(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }
}
// Time Complexity: O(n) + O(n)
// Space Complexity: O(n)
```

## Q5. Given an infix expression, Your task is to convert the given infix expression to a prefix expression.

*TUF - [Infix to Prefix](https://takeuforward.org/data-structure/infix-to-prefix/)*


```
Examples:

Input: x+y*z/w+u
Output: ++x/*yzwu

Input: a+b
Output: +ab
```

### Approach

**Step 1:** Scan the infix expression from right to left.

**Step 2:** If the scanned character is an operand, add it to answer.

**Step 3:** Else if the scanned character is ')' push it into the stack.

**Step 4:** Else if the scanned character is '(', pop the stack and add to answer until ')' is encountered. Discard both the parenthesis.

**Step 5:** Else pop all the operators from the stack which have a higher precedence than the current character. Then push the current operator to the stack.

**Step 6:** Once the complete infix string is scanned. Pop all the elements available in stack and add to answer.

**Step 7:** Reverse the answer.

```java
public class Solution {

    public String infixToPrefix(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch) || Character.isLetter(ch)) {
                sb.append(ch);
            } else if(ch == ')') {
                stack.push(ch);
            } else if(ch == '(') {
                while(!stack.isEmpty() && stack.peek() != ')') {
                    sb.append(stack.pop());
                }
                stack.pop();
            } else {
                while(!stack.isEmpty() && priority(ch) < priority(stack.peek())) {
                    sb.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    private int priority(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }
}
// Time Complexity: O(n) + O(n)
// Space Complexity: O(n)
```

## Q6. Given an postfix expression, your task is to convert the given postfix expression to an infix expression.

```
Examples:

Input: abc++
Output: (a+(b+c))


Input: ab*c+
Output: ((a*b)+c)

Input: abc+*d/
Output: ((a*(b+c))/d)
```

### Approach

**Step 1:** Scan the postfix expression from left to right.

**Step 2:** If the scanned character is an operand, add it to stack.

**Step 3:** Else pop 2 elements from the stack and put current character(operator) between them and enclose the whole expression between '()'.

**Step 4:** Pop the stack to get the final result once the scan is completed.

```java
public class Solution {
    public String postfixToInfix(String s) {
        ArrayDeque<String> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                stack.push("" + ch);
            } else {
                String right = stack.pop();
                String left = stack.pop();
                stack.push("(" + left + ch + right + ")");
            }
        }
        return stack.pop();
    }
}
// Time Complexity: O(n)
// Space Complexity: O(n)
```

## Q7. Given an prefix expression, your task is to convert the given prefix expression to an infix expression.

```
Examples:

Input: *+AB-CD
Output: ((A+B)*(C-D))

Input: *-A/BC-/AKL
Output: ((A-(B/C))*((A/K)-L))

```

### Approach

**Step 1:** Scan the postfix expression from right to left.

**Step 2:** If the scanned character is an operand, add it to stack.

**Step 3:** Else pop 2 elements from the stack and put current character(operator) between them and enclose the whole expression between '()'.

**Step 4:** Pop the stack to get the final result once the scan is completed.

```java
public class Solution {
    public String postfixToInfix(String s) {
        ArrayDeque<String> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                stack.push("" + ch);
            } else {
                String right = stack.pop();
                String left = stack.pop();
                stack.push("(" + left + ch + right + ")");
            }
        }
        return stack.pop();
    }
}
// Time Complexity: O(n)
// Space Complexity: O(n)
```

