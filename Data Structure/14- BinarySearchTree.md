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
