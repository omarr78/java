
# Separate Chaining
The idea is to make each cell of the hash table point to a linked list of records that have the same hash function value.
Chaining is simple but requires additional memory outside the table.

## Java Implementation

```java
package org.example;

import java.util.ArrayList;
import java.util.List;

public class SeparateChaining {
    private static class Node<T>{
        public T data;
        Node<T> next;
        public Node(T value){
            this.data = value;
            this.next = null;
        }
    }
    private static class Pair<K, V> {
        K head;
        V tail;
    }

    private List<Pair<Node<Integer>,Node<Integer>>> buckets;
    private final int capacity;
    private int size;

    public SeparateChaining(int capacity) {
        this.capacity = capacity;
        this.buckets = new ArrayList<>(capacity);
        for(int i = 0 ; i < capacity ; i++){
            buckets.add(new Pair<>());
        }
        this.size = 0;
    }
    public int hashFunction(int value){
        return Math.abs(value % capacity);
    }
    public void insert(int value){
        int idx = hashFunction(value);
        Node<Integer> newNode = new Node<>(value);
        Pair<Node<Integer>,Node<Integer>> bucket = buckets.get(idx);

        if(bucket.head == null){
            bucket.head = newNode;
            bucket.tail = newNode;
        }
        else{
            bucket.tail.next = newNode;
            bucket.tail = newNode;
        }
        size++;
    }
    public boolean contains(int value){
        int idx = hashFunction(value);
        Node<Integer> temp = buckets.get(idx).head;

        while(temp != null){
            if(temp.data == value ){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public void remove(int value){
        if(!contains(value)) throw new IllegalArgumentException("Value not found: " + value);
        int idx = hashFunction(value);

        Pair<Node<Integer>,Node<Integer>> bucket = buckets.get(idx);
        Node<Integer> prev = null;
        Node<Integer> curr = bucket.head;

        if(curr.data == value){
            if(curr.next == null){
                bucket.head = null;
                bucket.tail = null;
            }
            else{
                bucket.head = bucket.head.next;
            }
            size--;
            return;
        }
        while(curr != null){
            if(curr.data == value){
                prev.next = curr.next;
                if(curr.next == null){
                    bucket.tail = prev;
                }
                size--;
                break;
            }
            prev = curr;
            curr = curr.next;
        }
    }
    public void display(){
        for(int i = 0 ; i < capacity ; i++){
            Node<Integer> temp = buckets.get(i).head;
            System.out.print(i + " --> ");
            while(temp != null){
                System.out.print(temp.data + " --> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }
    public int size(){
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
}
```
