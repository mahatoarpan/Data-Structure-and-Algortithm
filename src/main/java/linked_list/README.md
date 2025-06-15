## What is Linked List?

It is a linear data structure that can be visualized as a chain with different nodes connected, where each node represents a different element. The difference between arrays and linked lists is that, unlike arrays, the elements are not stored at a contiguous location.

Since for any element to be added in an array, we need the exact next memory location to be empty, and it is impossible to guarantee that it is possible. Hence, adding elements to an array is not possible after the initial assignment of size.

A linked list is a data structure containing two crucial pieces of information, the first being the data and the other being the pointer to the next element. The ‘head’ is the first node, and the ‘tail’ is the last node in a linked list.

#### Types of Linked List
* **Singly Linked Lists:** In a singly linked list, each node points to the next node in the sequence. Traversal is straightforward but limited to moving in one direction, from the head to the tail.
* **Doubly Linked Lists:** In this each node points to both the next node and the previous node, thus allowing it for bidirectional connectivity.
* **Circular Linked Lists:** In a circular linked list, the last node points back to the head node, forming a closed loop.

## Q1. You are given the node to be deleted node. You will not be given access to the first node of head. 

*leetcode - [Delete Node in a Linked List](https://leetcode.com/problems/delete-node-in-a-linked-list/description/)*

*By deleting the node we mean:*
* *The value of the given node should not exist in the linked list.*
* *The number of nodes in the linked list should decrease by one.*
* *All the values before node should be in the same order.*
* *All the values after node should be in the same order.*

```
Examples: 
   
Input: head = [4,5,1,9], node = 5
Output: [4,1,9]
Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.

Input: head = [4,5,1,9], node = 1
Output: [4,5,9]
Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.
```

### Approach 1: Brute force

***Intuition:** To delete the node we need to change the link of previous node, but in this case we cannot access the previous node. Instead of removing the node we will overwrite the data of the node with next node's data. And perform the same for next all nodes until we reach the second last node. Once we reach the second last node we break the link of second last node with the last node.*

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode currentNode = node;
        ListNode nextNode = currentNode.next;
        while(nextNode.next != null) {
            currentNode.val = nextNode.val;
            currentNode = nextNode;
            nextNode = nextNode.next;
        }
        currentNode.val = nextNode.val;
        currentNode.next = null;
    }
}
// Time Complexity: O(n)
// Space Complexity: O(1)
```

### Approach 2: Optimal

*Instead of iterating over the linked list, we can simply copy the data of next node and remove the next node.*

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
// Time Complexity: O(1)
// Space Complexity: O(1)
```

## Q2. Given the head of a singly linked list, return the middle node of the linked list. If there are two middle nodes, return the second middle node.

*leetcode - [Middle of the Linked List](https://leetcode.com/problems/middle-of-the-linked-list/description/)*

```
Examples:

Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.

Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
```

### Approach 1: Brute force

**Step 1:** Count the number of nodes

**Step 2:** Iterate for `count/2` times to get to the middle node.

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while(temp != null) {
            count++;
            temp = temp.next;
        }
        
        temp = head;
        for (int i = 0; i < count / 2; i++) {
            temp = temp.next;
        }
        return temp;
    }
}
// Time complexity: O(n + n/2)
// Space Complexity: O(1)
```

### Approach 2: Optimal -- [Fast-Slow pointer]

***Intuition:** As we move fast pointer at 2x than the slow pointer, slow will reach the middle of the list by the time fast reaches the end.*

**Step 1:** Initialize 2 pointers, slow and fast.

**Step 2:** Start iterating the list from the head, slow with 1 move at a time and fast with 2 moves at the same time.

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
// Time Complexity: O(n/2)
// Space Complexity: O(1)
```

## Q3. Given the head of a singly linked list, reverse the list, and return the reversed list.

*leetcode -[Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/description/)*

```
Examples:

Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

Input: head = [1,2]
Output: [2,1]

Input: head = []
Output: []
```

### Approach 1 -- Iterative

**Step 1:** Initialize 3 pointers

    previousPointer -> initially points to nothing
    currentPointer -> initially points to head -- used to traverse the list
    nextPointer -> initialyy points to nothing

**Step 2:** While traversing perform the following until currentPointer becomes null
    
    1. Temporarily save the next of currentPointer in nextPointer
    2. Change the next of currentPointer, and point towards previousPointer
    3. Once the link direction changed for currentPointer, move previousPointer to currentPointer and currentPointer to nextPointer
    
**Step 3:** Once the currentPointer becomes null, previousPointer will store the new head of the linked list.

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }

        ListNode previousNode = null;
        ListNode currentNode = head;
        ListNode nextNode;

        while(currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        return previousNode;
    }
}
// Time Complexity: O(n)
// Space Complexity: O(1)
```

### Approach 2 -- Recursive

**Step 1:** Base Case - If list is empty or contains only one node. Return the head as it's already reversed in these cases.

**Step 2:** If the base conditions are not met, the function invokes itself recursively with `node.next` until the base condition is reached. 

**Step 3:** Store the new head coming from the recursive function call.

**Step 4:** Adjust the next pointer of the next node from the current node and point it towards the current node.

**Step 5:** Remove the next pointer of current node to prevent cyclic refence.

**Step 6:** Return the new head.

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
// Time Complexity: O(n)
// Space Complexity: O(n) - if recursion call stack is considered else O(1)
```

## Q4. Given head, the head of a linked list, determine if the linked list has a cycle in it.

*leetcode - [Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/description/)*

*There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.*

```
Examples:

Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.

```

### Approach 1: Brute force

**Step 1:** Create a hash set to store the nodes

**Step 2:** While iterating the list, check if the node is available in set

**Step 3:** If yes, return true, else add the node to the set and continue.

```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode temp = head;
        while(temp != null) {
            if (set.contains(temp)) {
                return true;
            }
            set.add(temp);
            temp = temp.next;
        }
        return false;
    }
}
// Time Complexity: O(n)
// Space Complexity: (n)
```

### Approach 2: Optimal

**Step 1:** Initialize two pointers, `slow` and `fast`, to the head of the linked list. `slow` will advance one step at a time, while `fast` will advance two steps.

**Step 2:** Traverse the linked list with `slow` and `fast` using two coniditons
    
    Condition 1: fast or fast.next reaches the end of the list. If this is the case then there is no loop
    Condition 2: fast and slow pointers meet at the same node. This indicates the presence of a loop

***Intuition:** In a linked list with a loop, consider two pointers: one that moves one node at a time (slow) and another that moves two nodes at a time (fast). If we start moving these pointers with their defined speed they will surely enter the loop and might be at some distance 'd' from each other within the loop. The fast pointer, moving at double the speed of the slow one, closes the gap between them by one node in every iteration. This means that with each step, the distance decreases by one node.*

```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
// Time Complexity: O(n)
// Space Complexity: O(1)
```

## Q5. Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

*leetcode - [Linked List Cycle II](https://leetcode.com/problems/linked-list-cycle-ii/description/)*

```
Examples:

Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.

Input: head = [1,2], pos = 0
Output: tail connects to node index 0
Explanation: There is a cycle in the linked list, where tail connects to the first node.
```

### Approach 1: 

**Step 1:** Create a hash set to store the nodes

**Step 2:** While iterating the list, check if the node is available in set

**Step 3:** If yes, return the node, else add the node to the set and continue.

```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode temp = head;
        while(temp != null) {
            if (set.contains(temp)) {
                return temp;
            }
            set.add(temp);
            temp = temp.next;
        }
        return null;
    }
}
// Time Complexity: O(n)
// Space Complexity: (n)
```

### Approach 2: Optimal

**Step 1:** Initialize two pointers, `slow` and `fast`, to the head of the linked list. `slow` will advance one step at a time, while `fast` will advance two steps.

**Step 2:** Traverse the linked list with `slow` and `fast` using two coniditons
    
    Condition 1: fast or fast.next reaches the end of the list. If this is the case then there is no loop
    Condition 2: fast and slow pointers meet at the same node. This indicates the presence of a loop

**Step 3:** If `fast` or `fast.next` is null, return null as the list does not contain any cycle.

**Step 4:** If the list contains cycle, start fast pointer from head. By the time fast and slow meet again it will be the cyclic node.

```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if(fast == null || fast.next == null) {
            return null;
        }
        fast = head;
        while(fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
// Time Complexity: O(n)
// Space Complexity: O(1)
```

## Q6. Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

*leetcode - [Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list/description/)*

```
Examples:

Input: head = [1,2,2,1]
Output: true

Input: head = [1,2]
Output: false
```

### Approach 1: Brute Force

**Step 1:** Initialize a stack

**Step 2:** Iterate the linked list and push the data into stack

**Step 3:** Again iterate over the list and check `node.val == stack.top` are same or not. If yes, continue, else return false

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ListNode temp = head;

        while(temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }
        temp = head;
        while(temp != null) {
            if(temp.val != stack.pop()) {
                return false;
            }
            temp = temp.next;
        }
        return true;
    }
}
// Time Complexity: O(n)
// Space Complexity: O(n)
```

### Approach 2: Optimal

**Step 1:** Traverse to the middle of the linked list

**Step 2:** Reverse the second half of the list

**Step 3:** Traverse both heads of 2 halfs of the list and check if their value are same or not

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondListHead = reverse(slow);
        ListNode temp =  head;

        while(secondListHead != null) {
            if(temp.val != secondListHead.val) {
                return false;
            }
            temp = temp.next;
            secondListHead = secondListHead.next;
        }

        return true;
    }

    private ListNode reverse(ListNode node) {
        if(node == null || node.next == null) {
            return node;
        }

        ListNode tempHead = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return tempHead;
    }
}
// Time Complexity: O(n)
// Space Complexity: O(1)
```

## Q7. Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list. The first node is considered odd, and the second node is even, and so on.
*leetcode - [Odd Even Linked list](https://leetcode.com/problems/odd-even-linked-list/description/)*


```
Examples:

Input: head = [1,2,3,4,5]
Output: [1,3,5,2,4]
Explaination: 1->2->3->4->5  becomes 1->3->5->2->4. All the odd indices come together and even idices come together.

Input: head = [2,1,3,5,6,4,7]
Output: [2,3,6,7,1,5,4]
Explaination: 2->1->3->5->6->4->7 becomes 2->3->6->7->1->5->4
```

### Approach 1: Brute Force

**Step 1:** Store the data of odd indices into a list

**Step 2:** Store the data of even indices into the same list

**Step 3:** Copy the data from list to the linked list

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        List<Integer> list = new ArrayList<>();
        addValueToList(head, list); // add all the odd index values into the list
        addValueToList(head.next, list) // add all the even index values into the list
        int index = 0;
        ListNode temp = head;
        while(temp != null) {
            temp.val = list.get(index++);
            temp = temp.next;
        }
        return head;
    }

    private void addValueToList(ListNode node, List<Integer> list) {
        while(node != null && node.next != null) {
            list.add(node.val);
            node = node.next.next;
        }
        if(node != null) {
            list.add(node.val);
        }
    }
}
// Time Complexity: O(n)
// Space Complexity: O(n)
```

### Approach 2

**Step 1:** Create 2 dummy head nodes: `oddHead` and `evenHead`

**Step 2:** Add the first node to the odd list and second to the  even list and so on.

**Step 3:** Append even list to the end of odd list

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = new ListNode(0), oddTail = oddHead;
        ListNode evenHead = new ListNode(0), evenTail = evenHead;
        ListNode current = head, previous;
        boolean isOdd = true;
        while(current != null) {
            // break the links of the current node
            previous = current;
            current = current.next;
            previous.next = null;

            if(isOdd) {
                oddTail.next = previous;
                oddTail = oddTail.next;
            } else {
                evenTail.next = previous;
                evenTail = evenTail.next;
            }
            isOdd = !isOdd;
        }
        oddHead = oddHead.next;
        evenHead = evenHead.next;
        oddTail.next = evenHead;
        return oddHead;
    }
}
// Time Complexity: O(n)
// Space Complexity: O(1)
```

## Q8. Given the head of a linked list, remove the nth node from the end of the list and return its head.

*leetcode - [Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/)*

```
Examples:

Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

Input: head = [1], n = 1
Output: []

Input: head = [1,2], n = 1
Output: [1]
```

### Approach 1: Brute Force

**Step 1:** Start a recursive function from the head of the list

**Step 2:** While back tracking, count how many nodes have passed

**Step 3:** If `count == n`, it means the next node is the one we want to remove.

**Step 4:** After recursion ends, if the total count is equal to n,
it means the first node (head) should be removed.

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return head;
        }
        int nodeCount = helper(head, n);
        if(nodeCount == n) {
            head = head.next;
        }
        return head;
    }

    private int helper(ListNode node, int n) {
        if(node == null) {
            return 0;
        }
        int nodeCount = helper(node.next, n);
        if(nodeCount == n) {
            node.next = node.next.next;
        }
        return nodeCount + 1;
    }
}
// Time Complexity: O(n)
// Space Complexity: O(1)
```

### Approach 1: Better

**Step 1:** Add a dummy head to the list

**Step 2:** Find the length of the linked list

**Step 3:** Iterate over the list for `length - n` times to reach the previous node of the node to be deleted. -- This is the reason to add the dummy head. So that we can change the link of previous node.

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int len = 0;
        ListNode temp = head;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        len = len - n;
        temp = dummy;
        while(len > 0){
            len--;
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return dummy.next;
    }
}
// Time Complexity: O(n) + O(l) -- where l is length - n
// Space Complexity: O(1)
```

### Approach 3: Optimal

**Step 1:** Add a dummy head node to the list. This helps handle edge cases, like removing the head node itself.

**Step 2:** Initialize two pointers `lead` and `follow` with dummy head

**Step 3:** Move the lead pointer `n+1` steps.

**Step 4:** Move both lead and follow until lead reaches the end. When lead reaches end, slow will be right before the node that needs to be removed.

**Step 5:** Delete follow.next node

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        ListNode follower = start;
        ListNode leader = start;
        dummyHead.next = head;
        for(int i = 0; i < n+1; i++){
            leader = leader.next;
        }
        
        while(leader != null){
            laeder = leader.next;
            follower = follower.next;
        }
        follower.next = follower.next.next;
        return dummyHead.next;
    }
}
// Time Complexity: O(n)
// Space Complexity: O(1)
```


