/*
isEmpty():
  Time: O(1) - Just checks size
  Space: O(1) - No additional space used

clear():
  Time: O(1) - Just resets pointers
  Space: O(1) - No additional space used

enqueue(T x):
  Time: O(1) - Just adds a node at the end
  Space: O(1) - Creates one new node

dequeue():
  Time: O(1) - Just moves the front pointer
  Space: O(1) - No additional space used

front():
  Time: O(1) - Just accesses front data
  Space: O(1) - No additional space used

back():
  Time: O(1) - Just accesses back data
  Space: O(1) - No additional space used

size():
  Time: O(1) - Returns stored size
  Space: O(1) - No additional space used

print():
  Time: O(n) - Iterates through all elements
  Space: O(1) - Only uses a temporary pointer

*/

package packageName;

public class Node<T> {
    public T data;
    public Node<T> next;
    public Node(T value){
        this.data = value;
        this.next = null;
    }
}

package packageName;

import java.util.NoSuchElementException;

public class Queue<T> {
    private Node<T> front,back;
    private int size = 0;

    boolean isEmpty() {
        return size == 0;
    }
    public void clear(){
        front = null;
        back = null;
        size = 0;
    }
    public void enqueue(T x) {
        Node<T> newNode = new Node<>(x);
        if (isEmpty()) {
            front = newNode;
        } else {
            back.next = newNode;
        }
        back = newNode;
        size++;
    }
    public void dequeue() {
        if(isEmpty()){
            throw new NoSuchElementException("Queue is empty");
        }
        if(size == 1){
            clear();
        }
        else{
            front = front.next;
            size--;
        }
    }
    public T front(){
        if(isEmpty()){
            throw new NoSuchElementException("Queue is empty");
        }
        return front.data;
    }
    public T back(){
        if(isEmpty()){
            throw new NoSuchElementException("Queue is empty");
        }
        return back.data;
    }
    public int size(){
        return this.size;
    }
    public void print(){
        if(isEmpty()){
            System.out.println("Queue is empty");
        }
        else{
            Node<T> temp = front;
            while(temp != null){
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }
}
