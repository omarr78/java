/*

Constructor
  Time: O(1) - just initializes variables
  Space: O(n) - allocates array of size n

isEmpty()
  Time: O(1) - simple size comparison
  Space: O(1) - no additional space used

isFull()
  Time: O(1) - simple size comparison
  Space: O(1) - no additional space used

enqueue(T item)
  Time: O(1) - constant time operations (modulo, assignment, increment)
  Space: O(1) - no additional space beyond what's already allocated
  
dequeue()
  Time: O(1) - constant time operations (modulo, increment)
  Space: O(1) - no additional space used

front()
  Time: O(1) - array access by index
  Space: O(1) - no additional space used

back()
  Time: O(1) - array access by index
  Space: O(1) - no additional space used

size()
  Time: O(1) - returns stored size value
  Space: O(1) - no additional space used

clear()
  Time: O(1) - just resets pointers
  Space: O(1) - no additional space used

print()
  Time: O(n) - iterates through all elements
  Space: O(1) - no additional space used

*/

package packageName;

import java.util.NoSuchElementException;

public class Queue<T> {
    private T[] arr;
    private int front;
    private int back;
    private int currentSize;
    private final int capacity;

    @SuppressWarnings("unchecked")
    public Queue(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Queue size must be positive");
        }
        this.capacity = size;
        arr = (T[]) new Object[capacity];
        front = 0;
        back = -1;
        currentSize = 0;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean isFull() {
        return currentSize == capacity;
    }

    public void enqueue(T item) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        back = (back + 1) % capacity;
        arr[back] = item;
        currentSize++;
    }

    public void dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        front = (front + 1) % capacity;
        currentSize--;
    }

    public T front() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return arr[front];
    }

    public T back() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return arr[back];
    }

    public int size() {
        return currentSize;
    }

    public void clear() {
        front = 0;
        back = -1;
        currentSize = 0;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        int temp = front;
        for (int i = 0; i < currentSize; i++) {
            System.out.print(arr[temp] + " ");
            temp = (temp + 1) % capacity;
        }
        System.out.println();
    }
}
