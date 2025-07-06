# Java Interfaces: Marker & Generic


## 1- Marker (Tagged) Interface

### Definition:

A **Marker Interface** is an interface **with no methods or fields**, used to **signal capability** or behavior to the **JVM or compiler**.

> Acts like a “flag” or “tag” to enable special treatment.

### Also Known As:

* Tagged Interface
* Signature Interface
* Ability Interface

### How It Works

```java
class MyClass implements Serializable {
    // No special methods needed
}

public class Main {
    public static void main(String[] args) {
        MyClass obj = new MyClass();

        if (obj instanceof Serializable) {
            System.out.println("Object can be serialized");
            // Safe to serialize
        }
    }
}
```

### Common Marker Interfaces:

| Interface      | Purpose                               |
| -------------- | ------------------------------------- |
| Serializable   | Enables object serialization          |
| Cloneable      | Enables object cloning                |
|  Remote        | Allows remote method invocation (RMI) |

---


## 2- Generic Interfaces

### Definition:

A **Generic Interface** uses **type parameters** to create reusable, type-safe contracts that work with various data types.

```java
interface Box<T> {
    void put(T item);
    T get();
}
```

### Benefits:

* **Type Safety**: Prevents type mismatch errors
* **No Casting**: Eliminates need for manual casting
* **Code Reuse**: Same logic applies to different types

---

### Common Type Letters:

| Letter  | Meaning               |
| ------- | --------------------- |
| `T`     | Type (general)        |
| `E`     | Element (collections) |
| `K`     | Key (maps)            |
| `V`     | Value (maps)          |
| `N`     | Number                |
| `S,U,V` | 2nd, 3rd, 4th types   |

---

### Example: Single-Type Generic Box

```java
interface Box<T> {
    void put(T item);
    T get();
}

class StringBox implements Box<String> {
    private String content;

    public void put(String item) { this.content = item; }
    public String get() { return content; }
}

class NumberBox implements Box<Integer> {
    private Integer content;

    public void put(Integer item) { this.content = item; }
    public Integer get() { return content; }
}
```

```java
public class Main {
    public static void main(String[] args) {
        Box<String> stringBox = new StringBox();
        stringBox.put("Hello Generics!");
        System.out.println(stringBox.get());  // Output: Hello Generics!

        Box<Integer> numberBox = new NumberBox();
        numberBox.put(42);
        System.out.println(numberBox.get() * 2);  // Output: 84
    }
}
```
---

### Example: Generic Pair Interface (Two Type Params)

```java
interface Pair<K, V> {
    K getKey();
    V getValue();
    void setKey(K key);
    void setValue(V value);
}

class SimplePair<K, V> implements Pair<K, V> {
    private K key;
    private V value;

    public SimplePair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() { return key; }
    public V getValue() { return value; }

    public void setKey(K key) { this.key = key; }
    public void setValue(V value) { this.value = value; }
}
```

```java
public class Main {
    public static void main(String[] args) {
        Pair<String, Integer> nameAge = new SimplePair<>("Alice", 30);
        System.out.println(nameAge.getKey() + " is " + nameAge.getValue() + " years old");

        Pair<Integer, Boolean> idStatus = new SimplePair<>(101, true);
        System.out.println("ID " + idStatus.getKey() + " is active: " + idStatus.getValue());
    }
}
```

---

### 🧠 Summary

| Concept           | Key Feature                              |
| ----------------- | ---------------------------------------- |
| Marker Interface  | No methods, used as a capability tag     |
| Generic Interface | Type-safe, reusable with different types |


---

