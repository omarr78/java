package org.example;

import java.util.Arrays;

public class LinearProbing {
    private static final int EMPTY = Integer.MIN_VALUE;
    private static final int EXIST_BEFORE = Integer.MIN_VALUE + 1;

    private int []table;
    private int capacity;
    private int size;
    private final double loadFactor = 0.75;

    public LinearProbing(int capacity) {
        this.capacity = capacity;
        this.table = new int[capacity];
        Arrays.fill(table, EMPTY);
        this.size = 0;
    }

    public int hashFunction(int value){
        return Math.abs(value % capacity);
    }
    private void rehash() {
        int[] oldTable = table;
        capacity*=2;
        table = new int[capacity];
        Arrays.fill(table, EMPTY);
        size = 0;
        for(int value : oldTable){
            if(value != EMPTY && value != EXIST_BEFORE){
                insert(value);
            }
        }
    }
    public void insert(int value){
        //Checks if the value being inserted is one of special markers.
        if(value == EMPTY || value == EXIST_BEFORE){
            throw new IllegalArgumentException("Invalid value");
        }

        if((double) size / capacity >=  loadFactor){
            rehash();
        }

        int idx = hashFunction(value);
        int firstPosFound = -1;

        while(table[idx] != EMPTY){
            if(table[idx] == value){
                return; // value already Exist (no duplicates)
            }
            if(table[idx] == EXIST_BEFORE && firstPosFound == -1){
                firstPosFound = idx;
            }
            idx = (idx + 1 )% capacity;
        }
        if(firstPosFound != -1){
            table[firstPosFound] = value;
        }
        else{
            table[idx] = value;
        }
        size++;
    }
    public boolean contains(int value){
        int idx = hashFunction(value);
        int startIdx = idx;
        do{
            if(table[idx] == value)return true;
            if(table[idx] == EMPTY)return false;
            idx = (idx + 1)%capacity;
        }while(idx != startIdx);
        return false;
    }

    public void remove(int value){
        int idx = hashFunction(value);
        int startIdx = idx;
        do{
            if(table[idx] == value){
                table[idx] = EXIST_BEFORE;
                size--;
                return;
            }
            if(table[idx] == EMPTY){
                throw new IllegalArgumentException("Value not found: " + value);
            }
            idx = (idx + 1)%capacity;
        }while (idx != startIdx);
        throw new IllegalArgumentException("Value not found: " + value);
    }

    public void display(){
        for(int i = 0 ; i < capacity ; i++){
            if(table[i] != EMPTY && table[i] != EXIST_BEFORE){
                System.out.print(table[i] + " ");
            }
        }
    }
}
