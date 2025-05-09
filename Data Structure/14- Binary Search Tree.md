# Binary Search Tree (BST)

## Time Complexity

| Operation  | Average Case | Worst Case |
|------------|--------------|------------|
| Search     | O(log n)     | O(n)       |
| Insert     | O(log n)     | O(n)       |
| Delete     | O(log n)     | O(n)       |
| Traversal  | O(n)         | O(n)       |

## Space Complexity
- **Average/Worst Case**: O(n) (for storing n nodes)

### Balanced BST (Best Case)
```
    O
   / \
  O   O
 / \ / \
O  O O  O
```
- Height: log₂n
- Operations: O(log n)

### Skewed BST (Worst Case)
```
    O
     \
      O
       \
        O
         \
          O
```
- Height: n
- Operations: O(n)

## Notes
- Average case assumes reasonably balanced tree
- Worst case occurs when tree becomes skewed (like a linked list)
- Self-balancing BSTs (AVL, Red-Black) maintain O(log n) operations by preventing skewness

## Implementation

```java
package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    // Inner class representing a node in the BST
    private static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.value = value;
        }
    }

    private TreeNode root;
    private int size;
    // Constructor initializes an empty BST
    public BinarySearchTree() {
        root = null;
        size = 0;
    }
    // Recursive helper to insert a value into the BST
    private TreeNode insert(TreeNode node, int value) {
        if (node == null) {
            node = new TreeNode(value);
            return node;
        }
        if (value > node.value) {
            node.right = insert(node.right, value);
        } else {
            node.left = insert(node.left, value);
        }
        return node;
    }
    // Public method to insert a value
    public void insert(int value) {
        root = insert(root, value);
        size++;
    }
    // Recursive pre-order traversal (Root -> Left -> Right)
    private void preOrder(TreeNode node) {
        if (node == null) return;
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
    // Public pre-order traversal
    public void pre_order() {
        preOrder(root);
        System.out.println();
    }
    // Recursive in-order traversal (Left -> Root -> Right)
    private void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }
    // Public in-order traversal (prints values in sorted order)
    public void in_order() {
        inOrder(root);
        System.out.println();
    }
    // Recursive post-order traversal (Left -> Right -> Root)
    private void postOrder(TreeNode node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }
    // Public post-order traversal
    public void post_order() {
        postOrder(root);
        System.out.println();
    }
    // Breadth-First Search (Level-order traversal)
    public void printBFS() {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.value + " ");
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        System.out.println();
    }

    private boolean searchRec(TreeNode node, int value) {
        if (node == null) return false;
        if (value == node.value) return true;
        if (value > node.value) return searchRec(node.right, value);
        return searchRec(node.left, value);
    }

    public boolean search(int value) {
        return searchRec(root, value);
    }
    // Finds the smallest value in a subtree (used for deletion)
    private int findSmallestValue(TreeNode node) { // passing node.right
        if (node.left == null) return node.value;
        return findSmallestValue(node.left);
    }

    private TreeNode removeRec(TreeNode node, int value) {
        if (node.value == value) {
            // Case 1: Node is a leaf
            if (node.right == null && node.left == null) return null;

            // Case 2: Node has one child
            if (node.right == null) return node.left;
            if (node.left == null) return node.right;

            // Case 3: Node has two children
            // Replace with smallest value in right subtree
            int small = findSmallestValue(node.right);
            node.value = small;
            node.right = removeRec(node.right, small);
            return node;
        }
        // Recursively search for node to delete
        if (node.value < value) {
            node.right = removeRec(node.right, value);
        } else {
            node.left = removeRec(node.left, value);
        }
        return node;
    }
    // Public deletion method
    public void remove(int value) {
        if (!search(value)) {
            System.out.println("Value not found");
            return;
        }
        root = removeRec(root, value);
        size--;  // Decrement size only if deletion occurred
    }
    // Clears the BST
    public void clear() {
        root = null;
        size = 0;
    }
    // Returns number of nodes
    public int size() {
        return size;
    }
    // Checks if BST is empty
    public boolean isEmpty() {
        return size == 0;
    }
}
```

