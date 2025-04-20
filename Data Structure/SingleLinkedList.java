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
pop_back()	        Removes last element	                          O(n) (must traverse to tail)	 O(1)
pop_at(int)	        Removes element at specified position	          O(n) (worst case)	         O(1)
find(T)	                Returns first index of matching element	          O(n)	                         O(1)
findAtIndex(int)	Returns element at specified index	          O(n)	                         O(1)
isEmpty()	        Checks if list is empty	                          O(1)	                         O(1)
print()	                Prints all elements	                          O(n)	                         O(1)
clear()	                Empties the list	                          O(1)	                         O(1)

*/





public class Node<T> {
    public T data;
    public Node<T> next;
    public Node(T value){
        this.data = value;
        this.next = null;
    }
}

package PackageName;
import java.util.Objects;

public class SingleLinkedList<T> {
    public Node<T> head;
    public Node<T> tail;
    public int size = 0;

    private void createFirstNode(Node<T> node) {
        head = node;
        tail = node;
        size = 1;
    }
    public boolean isEmpty() {
        return head == null;
    }
    public void clear() {
        head = null;
        tail = null;
    }
    public void push_back(T nodeData) {
        Node<T> node = new Node<>(nodeData);
        if (isEmpty()) {
            createFirstNode(node);
        } else {
            tail.next = node;
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
        Node<T> prev = head;
        for(int i= 0; i < pos - 1; i++){
            prev = prev.next;
        }
        node.next = prev.next;
        prev.next = node;
        size++;
    }

    public void pop_front() {
        if (isEmpty()) return;
        if (size == 1) {
            clear();
        } else {
            head = head.next;
        }
        size--;
    }
    public void pop_back() {
        if(isEmpty()) return;
        if (size == 1) {
            clear();
        } else {
            Node<T> temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
        }
        size--;
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
        Node<T> prev = head;
        for (int i = 0; i < pos - 1; i++) {
            prev = prev.next;
        }
        Node<T> willRemoveNode = prev.next;
        prev.next = willRemoveNode.next;
        willRemoveNode.next = null;
        size--;
    }


    public int find(T nodeData) {
        Node<T> temp = head;
        int index = 0;
        while (temp != null) {
            if (Objects.equals(nodeData, temp.data)) { // Null-safe comparison
                return index;
            }
            index++;
            temp = temp.next;
        }
        return -1;
    }

    public T findAtIndex(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative: " + index);
        }
        if(index >= size){
            throw new IndexOutOfBoundsException("Index cannot be greater than size: " + index);
        }
        Node<T> temp = head;
        int currentIndex = 0;
        while (currentIndex < index) {
            temp = temp.next;
            currentIndex++;
        }
        return temp.data;
    }
    public void print() {
        Node<T> temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

