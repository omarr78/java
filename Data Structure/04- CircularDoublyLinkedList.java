/*
A generic singly linked list implementation that supports:
    Insertion at front/back/specific position
    Deletion from front/back/specific position
    Search operations
    Basic utility methods

Method      	        Description	                                 TimeComplexity	        Space Complexity

push_back(T)	        Adds element at the end	                          O(1)                           O(1)
push_front(T)	        Adds element at the beginning	                  O(1)	                         O(1)
push_at(T, int)	        Inserts element at specified position	          O(n) (worst case)	         O(1)
pop_front()	        Removes first element	                          O(1)	                         O(1)
pop_back()	        Removes last element	                          O(1)                        	 O(1)
pop_at(int)	        Removes element at specified position	          O(n) (worst case)	         O(1)
find(T)	                Returns first index of matching element	          O(n)	                         O(1)
findAtIndex(int)	Returns element at specified index	          O(n)	                         O(1)
isEmpty()	        Checks if list is empty	                          O(1)	                         O(1)
print()	                Prints all elements	                          O(n)	                         O(1)
clear()	                Empties the list	                          O(1)	                         O(1)

*/





package PackageName;

public class Node<T> {
    public T data;
    public Node<T> next;
    public Node<T> prev;

    public Node(T value){
        this.data = value;
        this.next = null;
        this.prev = null;
    }
}

package PackageName;

import java.util.Objects;

public class CircularDoublyLinkedList<T> {
    public Node<T> head;
    public Node<T> tail;
    public int size = 0;

    private void createFirstNode(Node<T> node) {
        head = node;
        tail = node;
        node.next = node;
        node.prev = node;
        size = 1;
    }
    public boolean isEmpty() {
        return head == null;
    }
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
    public void push_back(T nodeData) {
        Node<T> node = new Node<>(nodeData);
        if (isEmpty()) {
            createFirstNode(node);
        } else {
            tail.next = node;
            node.prev = tail;
            node.next = head;
            head.prev = node;
            tail = node;
            size++;
        }
    }
    public void push_front(T nodeData) {
        Node<T> node = new Node<>(nodeData);
        if (isEmpty()) {
            createFirstNode(node);
        } else {
            node.next = head;
            node.prev = tail;
            head.prev = node;
            tail.next = node;
            head = node;
            size++;
        }
    }
    public void push_at(T nodeData, int pos) {
        Node<T> node = new Node<>(nodeData);
        if (pos <= 0) {
            push_front(nodeData);
            return;
        }
        if (pos >= size){
            push_back(nodeData);
            return;
        }
        Node<T> prevNode = head;
        for(int i= 0; i < pos - 1; i++){
            prevNode = prevNode.next;
        }
        node.next = prevNode.next;
        node.prev = prevNode;
        node.next.prev = node;
        prevNode.next = node;
        size++;
    }
    public void pop_front() {
        if (isEmpty()) return;
        if (size == 1) {
            clear();
        } else {
            head = head.next;
            head.prev = tail;
            tail.next = head;
            size--;
        }
    }
    public void pop_back() {
        if(isEmpty()) return;
        if (size == 1) {
            clear();
        } else {
            tail = tail.prev;
            tail.next = head;
            head.prev = tail;
            size--;
        }
    }
    public void pop_at(int pos) {
        if (pos <= 0) {
            pop_front();
            return;
        }
        if (pos >= size - 1) {
            pop_back();
            return;
        }
        Node<T> curr = head;
        for (int i = 0; i < pos; i++) {
            curr = curr.next;
        }
        Node<T> A = curr.prev;
        Node<T> B = curr.next;
        A.next = B;
        B.prev = A;
        size--;
    }
    public int find(T nodeData) {
        Node<T> temp = head;
        for(int i = 0; i < size; i++){
            if (Objects.equals(nodeData, temp.data)) { // Null-safe comparison
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }
    public T findAtIndex(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative: " + index);
        }
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        if(index >= size){
            throw new IndexOutOfBoundsException("Index cannot be greater than size: " + index);
        }
        Node<T> temp = head;
        for(int i = 0; i < index; i++){
            temp = temp.next;
        }
        return temp.data;
    }
    public void print() {
        Node<T> temp = head;
        for(int i = 0; i < size; i++) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

