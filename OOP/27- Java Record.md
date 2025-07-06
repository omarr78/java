# Java Records (JDK 14+)

## What is a Record?

A simpler way to define immutable data classes in Java.
Automatically generates equals(), hashCode(), toString(), and getter methods.

  
```java
public record Person(String name, int age) { }
```

## Why Use Records?

| Benefit                    | Description                                                   |
| -------------------------- | ------------------------------------------------------------- |
|  Less Boilerplate         | No need to write constructors, getters, or overrides manually |
|  Immutability by Default | Fields are final and private                                  |
|  Cleaner Code            | Focus on data, not code noise                                 |
|  Easier Maintenance      | Smaller code footprint = fewer bugs                           |

---

## Before vs. After Records

### Traditional Java Class (Before)

```java
public final class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }

    @Override
    public boolean equals(Object o) { ... }

    @Override
    public int hashCode() { ... }

    @Override
    public String toString() { ... }
}
```

---

### With Records (After)

```java
public record Person(String name, int age) { }
```

Saves 10+ lines of boilerplate, keeping focus on logic.

---
## Customizing Records

You can still add:

* Custom **constructors**
* **Methods**
* **Static fields or blocks**


### Example:

```java
public record Person(String name, int age) {
    public Person {
        if (age < 0) throw new IllegalArgumentException("Age cannot be negative!");
    }

    public String greet() {
        return "Hello, " + name;
    }
}
```

---

## Limitations of Records

|   Limitation                              | Description                                      |
| ----------------------------------------- | ------------------------------------------------ |
| Cannot extend classes                     | But can **implement interfaces**                 |
| All fields are final                      | Values are **immutable** after creation          |
| No instance-level mutable state           | Not suitable for changing internal fields        |
| No explicit field declaration inside body | All fields must be declared in the record header |

---

## When to Use

| Use Case            | Recommendation |
| ------------------- | -------------- |
| Simple data carrier |  Use Record    |
| Immutable DTOs      |  Use Record    |
| Complex behavior    |  Use Class     |
| Inheritance needed  |  Use Class     |
| Mutable fields      |  Use Class     |

**Summary**: Use **records** when you want **clean, immutable, value-based classes**. They’re great for data modeling, REST DTOs, or simple storage structures.

---

