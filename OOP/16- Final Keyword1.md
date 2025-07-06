# `final` Keyword

The `final` keyword is a **non-access modifier** used to **restrict modification** of:

* Variables
* Parameters
* Methods
* Classes

Once declared as `final`, an entity **can only be assigned once** — it becomes **immutable**.

---

## Types of `final`

| Type               | Description                                |
| ------------------ | ------------------------------------------ |
| `final` Variables  | Constants that can't be reassigned         |
| `final` Parameters | Parameters whose values can't change       |
| `final` Methods    | Methods that can't be overridden           |
| `final` Classes    | Classes that can't be extended (inherited) |

---

## Declaring a `final` Variable

```java
public class Car {
    final String name;

    // 1. Initialize directly
    // final String name = "BMW";

    // 2. Initialize inside a block
    // {
    //     name = "BMW";
    // }

    // 3. Initialize inside the constructor
    // Car() {
    //     name = "BMW";
    // }
}
```

>  `final` variables **must be initialized once** — afterward, they **cannot be reassigned**.

---


## Execution Order (Initialization Precedence)

1. **Static Initialization Blocks** (run once when the class is loaded)
2. **Instance Initialization Blocks** (run every time an object is created)
3. **Constructors** (run after all initialization blocks)

### Example:

```java
public class Example {
    final int x;
    final int y;
    static int z;

    static {
        z = 30;
        System.out.println("this is the static block 1");
    }

    static {
        z = 50;
        System.out.println("this is the static block 2");
    }

    {
        x = 8;
        System.out.println("this is the block 1");
    }

    {
        y = 10;
        System.out.println("this is the block 2");
    }

    public Example() {
        System.out.println("this is constructor");
    }

    public static void main(String[] args) {
        Example ex = new Example();
    }
}
```

### Output:

```
this is the static block 1  
this is the static block 2  
this is the block 1  
this is the block 2  
this is constructor  
```

---


## `static final` Variables (Constants)

Combining `static` and `final` allows you to create **constants** shared by all instances of a class.

### Characteristics:

* Belongs to the class, not to any object
* Must be initialized either:

  * At declaration, or
  * In a `static` block
* **Cannot** be modified or initialized in a constructor

---

### Example 1: Inline Initialization

```java
class Bike {
    public static final int TIRE = 2;
}
```

### Example 2: Static Block Initialization

```java
class Bike {
    public static final int PEDAL;

    static {
        PEDAL = 5;
    }
}
```

### Rules:

* Must initialize at declaration or inside a static block
* Cannot be initialized in a constructor
* Attempting to reassign or delay initialization will cause a **compile-time error**

---
