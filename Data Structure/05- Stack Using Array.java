/*

- Stack using Array
  ✓ Easy to implement 
  ✗ fixde size

Constructor Stack(int size)
  Time: O(1) - Just initializes variables
  Space: O(n) - Allocates array of size n

isEmpty()
  Time: O(1) - Simple comparison
  Space: O(1) - No additional space

isFull()
  Time: O(1) - Simple comparison
  Space: O(1) - No additional space

push(T element)
  Time: O(1) - Single array assignment
  Space: O(1) - No additional space (uses pre-allocated array)

pop()
  Time: O(1) - Single array access and assignment
  Space: O(1) - No additional space

top()
  Time: O(1) - Single array access
  Space: O(1) - No additional space

clear()
  Time: O(1)
  Space: O(1) - No additional space

print()
  Time: O(n) - Needs to traverse all elements
  Space: O(1) - Only uses constant extra space for tmp variable

size()
  Time: O(1) - Simple calculation
  Space: O(1) - No additional space

*/

package packageName;

import java.util.EmptyStackException;

public class Stack<T> {
    private T[] arr;
    private int top;
    private final int size;

    @SuppressWarnings("unchecked")
    public Stack(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Stack size must be positive");
        }
        this.size = size;
        this.arr = (T[]) new Object[size]; // Generic array creation
        top = -1;
    }
    public boolean isEmpty() {
        return top == -1;
    }
    public boolean isFull() {
        return top == size - 1;
    }
    public void push(T x) {
        if(isFull()) {
            throw new StackOverflowError("Stack is full");
        }
        arr[++top] = x;
    }
    public void pop() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        arr[top--] = null;
    }
    public T top() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return arr[top];
    }
    public void clear(){
        top = -1;
    }
    public void print(){
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        int tmp = top;
        while(tmp != -1){
            System.out.print(arr[tmp--] + " ");
        }
    }
    public int size() {
        return top + 1;
    }
}
