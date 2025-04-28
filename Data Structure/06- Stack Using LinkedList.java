/*
- Stack using LinkedList
  ✓ varibale size 
  ✗ implementation is not easy


Method	                  TimeComplexity	                 Space Complexity
Node(T value)	               O(1)	                              O(1)
createFirstNode()	           O(1)	                              O(1)
isEmpty()	                   O(1)	                              O(1)
clear()                      O(1)	                              O(1)
push(T nodeData)	           O(1)                               O(1)
pop()	                       O(1)	                              O(1)
top()	                       O(1)	                              O(1)
length()	                   O(1)	                              O(1)
print()	                     O(n)	                              O(1)


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

import java.util.EmptyStackException;

public class Stack<T> {
    Node<T> top;
    int size = 0;

    public boolean isEmpty() {
        return top == null;
    }
    public void clear() {
        top = null;
        size = 0;
    }
    public void push(T nodeData){ // push front
        Node<T> node = new Node<>(nodeData);
        if (isEmpty()) {
            top = node;
            size = 1;
        } else {
            node.next = top;
            top = node;
            size++;
        }
    }
    public void pop() { // pop front
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        if (size == 1) {
            clear();
        } else {
            top = top.next;
            size--;
        }
    }
    public T top(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return top.data;
    }
    public int length(){
        return size;
    }
    public void print(){
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        Node<T> current = top;
        while(current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

}
