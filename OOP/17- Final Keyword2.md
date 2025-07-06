## `final` Keyword (Final Parameters, Final Methods, Final Classes, Final Objects)

## 1- Final Parameters

### Purpose:

* Prevents the method from modifying the parameter.
* Ensures data passed to methods remains unchanged.

### Example:

```java
void printMessage(final String message) {
    // message = "New Message"; // Compile-time Error
    System.out.println(message);
}
```

Use case: Useful in large methods to prevent accidental reassignment of input data.

---

## 2- Final Methods

### Purpose:

* Prevents method **overriding** in subclasses.
* Protects core functionality in base classes.

### Example:

```java
class Parent {
    final void display() {
        System.out.println("This method cannot be overridden.");
    }
}

class Child extends Parent {
    // Cannot override final method
    // void display() { } // Compile-time Error
}
```

Use case: Locking utility or security methods from being altered in subclasses.

---
## 3- Final Classes

### Purpose:

* Prevents the class from being extended.
* Used for creating **immutable or utility** classes.

### Example:

```java
final class ImmutableClass {
    private final int value;

    public ImmutableClass(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

// Cannot inherit from a final class
// class SubClass extends ImmutableClass { } // Error
```

Use case: `String`, `Math`, and `Wrapper classes` in Java are `final` for consistency and safety.

---


## 4- Final Objects

### Purpose:

* Prevents reassignment of the object reference.
* **Note**: The object’s internal state **can still be modified** unless the object itself is immutable.

### Example:

```java
final Person person = new Person("Alice");

// person = new Person("Bob"); // Compile-time Error

// Allowed: modifying internal fields (if not final)
person.setName("Bob");
```

Use case: Keeps object reference constant — especially useful in multi-threaded environments.

---

## Performance & Optimization Note

* **JVM optimizations** can be applied to final entities (especially `final static`) because their values are known at compile time.
* **Inlining**, **caching**, and **constant folding** are common techniques.
* Final structures reduce bugs and clarify developer intent.

---
