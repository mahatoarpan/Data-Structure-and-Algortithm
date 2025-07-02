## Q1. Given the root of a binary tree, return the preorder traversal of its nodes' values.

*leetcode - [Binary Tree Preorder Traversal](https://leetcode.com/problems/binary-tree-preorder-traversal/description/)*

```
Examples:

Input: root = [1,null,2,3]
Output: [1,2,3]

Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
Output: [1,2,4,5,6,7,3,8,9]
```

![Tree 1](../images/bin_tree1.png "Tree 1")
![Tree 2](../images/bin_tree2.png "Tree 2")

### Approach 1: Recursive

**Step 1:** Print the current node data.

**Step 2:** Make a recursion call to left subtree

**Step 3:** Make a recursion call to right subtree.

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        helper(root, traversal);
        return traversal;
    }

    private void helper(TreeNode root, List<Integer> traversal) {
        if(root == null) {
            return;
        }
        traversal.add(root.val);
        helper(root.left, traversal);
        helper(root.right,traversal);
    }
}
// Time Complexity: O(n)
// Space Complexity: O(n), if recursion stack is considered
```

### Approach 2: Iterative

**Step 1:** Initialize a stack.

**Step 2:** Put the root node into the stack.

**Step 3:** Iterate over the stack until the stack is empty.

**Step 4:** Print the current top node of the stack.

**Step 4:** While iterating, first insert the right child node of current node taken from the stack. And then the left node.

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        if (root != null) {
            ArrayDeque<TreeNode> stack = new ArrayDeque<>();
            stack.push(root);
            
            while(!stack.isEmpty()) {
                TreeNode node = stack.pop();
                traversal.add(node.val);
                if(node.right != null ){
                    stack.push(node.right);
                }
                if(node.left != null) {
                    stack.push(node.left);
                }
            }
        }
        return traversal;
    }
}
// Time Complexity: O(n)
// Space Complexity: O(n)
```

## Q2. Given the root of a binary tree, return the inorder traversal of its nodes' values.

*leetcode - [Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal/description/)*

```
Examples

Input: root = [1,null,2,3]
Output: [1,3,2]

Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
Output: [4,2,6,5,7,1,3,9,8]
```

![Tree 1](../images/bin_tree1.png "Tree 1")
![Tree 2](../images/bin_tree2.png "Tree 2")

### Approach 1: Recursive

**Step 1:** Recursively traverse the left node of the current node.

**Step 2:** Print the current node value.

**Step 3:** Recursively traverse the right node of the current node.

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }
    
    private void helper(TreeNode node, List<Integer> result) {
        if (node == null){
            return;
        }
        helper(node.left);
        result.add(node.val);
        helper(node.right);
    }
}
```

### Approach 2: Iterative

**Step 1:** Initialize a stack

**Step 2:** Make root as the current node

**Step 3:** Enter infinite loop, this loop will keep going until the stack is empty

**Step 4:** Within loop, if node is not null, push the current node into stack and move to left.

**Step 5:** Once node value become null, check stack is empty or not. If empty break out of the loop. Else, process the top of the stack and move to right of the stack top node. 


```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        ArrayDeque<TreeNode> st = new ArrayDeque<>();
        TreeNode node = root;
        while (true) {
            if (node != null) {
                st.push(node);
                node = node.left;
            } else {
                if (st.isEmpty()) {
                    break;
                } 
                node = st.pop();
                result.add(node.val);
                node = node.right;
            }
        }
        return result;
    }
}
```


