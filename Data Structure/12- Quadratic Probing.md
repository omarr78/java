# Quadratic Probing:

Quadratic probing is an open addressing scheme in computer programming for resolving hash collisions in hash tables.
Quadratic probing operates by taking the original hash index and adding successive values of an arbitrary quadratic polynomial until an open slot is found.

`> H + 1^2, H + 2^2, H + 3^2, H + 4^2 ... H + k^2`

`> (hash(key) + i^2) % table_size`

![quadratic](https://github.com/user-attachments/assets/81aaf220-bb7b-45f0-9ac7-51b866b05671)

## prime capacity -> guaranteed to check at least half of the slots (⌈capacity/2⌉

- Quadratic Probing Example and Probe Sequence Demonstration

For a hash table with:
- `capacity = 7` (prime number)
- `hash(key) = 0`

The quadratic probing sequence calculates indices as:  
`index = (hash + i²) % capacity` where `i = 0, 1, 2,...`

```java
// Java-style pseudocode
int capacity = 7;
int hash = 0;

for (int i = 0; i < capacity; i++) {
    int index = (hash + i * i) % capacity;
}
```

### Output Sequence:
| Probe (i) | Calculation      | Index |
|-----------|-----------------|-------|
| 0         | (0 + 0²) % 7    | 0     |
| 1         | (0 + 1²) % 7    | 1     |
| 2         | (0 + 2²) % 7    | 4     |
| 3         | (0 + 3²) % 7    | 2     |
| 4         | (0 + 4²) % 7    | 2     |
| 5         | (0 + 5²) % 7    | 4     |
| 6         | (0 + 6²) % 7    | 1     |

- The sequence checks **4 unique slots** (0, 1, 4, 2) before repeating

## Implementation

```java

package org.example;

import java.util.Arrays;

public class QuadraticProbing {
    private static final int EMPTY = Integer.MIN_VALUE;
    private static final int EXIST_BEFORE = Integer.MIN_VALUE + 1;

    private int[] table;
    private int capacity;
    private int size;
    private final double loadFactor = 0.5;

    public QuadraticProbing(int capacity) {
        this.capacity = nextPrime(capacity);
        this.table = new int[capacity];
        Arrays.fill(table, EMPTY);
        this.size = 0;
    }

    public int hashFunction(int value) {
        return Math.abs(value % capacity);
    }

    private int nextPrime(int n) {
        while (!isPrime(n)) {
            n++;
        }
        return n;
    }

    private boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }

    private void rehash() {
        int[] oldTable = table;
        capacity = nextPrime(capacity * 2);
        table = new int[capacity];
        Arrays.fill(table, EMPTY);
        size = 0;
        for (int value : oldTable) {
            if (value != EMPTY && value != EXIST_BEFORE) {
                insert(value);
            }
        }
    }

    public void insert(int value) {
        //Checks if the value being inserted is one of special markers.
        if (value == EMPTY || value == EXIST_BEFORE) {
            throw new IllegalArgumentException("Invalid value");
        }

        if ((double) size / capacity >= loadFactor) {
            rehash();
        }

        int hash = hashFunction(value);
        int firstPosFound = -1;

        for (int i = 0; i < capacity; i++) {
            int idx = (hash + i * i) % capacity;
            if (table[idx] == EMPTY) {
                if (firstPosFound != -1) {
                    table[firstPosFound] = value;
                } else {
                    table[idx] = value;
                }
                size++;
                return;
            }
            if (table[idx] == value) {
                return; // duplicate
            }
            if (table[idx] == EXIST_BEFORE && firstPosFound == -1) {
                firstPosFound = idx;
            }
        }
        throw new IllegalStateException("Table is full");
    }


    public boolean contains(int value) {
        int hash = hashFunction(value);

        for(int i = 0; i < capacity; i++) {
            int idx = (hash + i*i) % capacity;
            if(table[idx] == value) {
                return true;
            }
            if(table[idx] == EMPTY) {
                return false;
            }
        }
        return false;
    }

    public void remove(int value) {
        int hash = hashFunction(value);

        for(int i = 0; i < capacity; i++) {
            int idx = (hash + i*i) % capacity;
            if(table[idx] == value) {
                table[idx] = EXIST_BEFORE;
                size--;
                return;
            }
            if(table[idx] == EMPTY) {
                throw new IllegalArgumentException("Value not found: " + value);
            }
        }
        throw new IllegalArgumentException("Value not found: " + value);
    }

    public void display() {
        for (int i = 0; i < capacity; i++) {
            if (table[i] != EMPTY && table[i] != EXIST_BEFORE) {
                System.out.print(table[i] + " ");
            }
        }
    }
}
```
