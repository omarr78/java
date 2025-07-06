# 1. Constructors in Anonymous Classes

-  **Does an anonymous class have a constructor?**
-  Anonymous classes do **not have explicit constructors** that you can define.
-  Anonymous classes have **no name**, so you **cannot define a named constructor**.

 **However**:
- They **implicitly call the superclass constructor** (parameterized or non-parameterized), and **it runs first**.
- You can use **instance initializer blocks** to perform initialization.
- Cannot use **static initializer blocks**.

---

# 2. Adding Extra Methods in Anonymous Classes

-  **Can we add extra methods in anonymous classes and access them using `var`?**
-  **Yes**, you can add extra methods.
-  You can **access them only** if you use `var` (Java 10+) — which infers the exact anonymous class type.

### Example:

```java
var obj = new Object() {
    public void extraMethod() {
        System.out.println("Extra method");
    }
};

obj.extraMethod();  Works with var
````

---

# 3. Limitations of the `var` Keyword

### Cannot use `var` for:

* **Class member variables**:

  ```java
  class Test {
    var x = 10;  Compile error
  }
  ```

* **Generic type parameters**:

  ```java
  ArrayList<var> list = new ArrayList<>();   Error
  var<Integer> list = new ArrayList<>();     Error
  var list = new ArrayList<String>();        Valid
  ```

* **Method parameters**:

  ```java
   void method(var param) {}  Compile error
  ```

* **Declaration without initialization**:

  ```java
   var x;       Error - cannot infer type
   x = 10;
  ```

* **Initialization with `null`**:

  ```java
   var x = null;  Error - cannot infer type
  ```

* **Return types**:

  ```java
   var method() { return 10; }  Compile error
  ```

---

# 4. Anonymous Class Behavior

## 1- Accessing Local Variables

*  Anonymous classes can access local variables **only if they are final or effectively final**.  (Java 8+)
*  Cannot modify such variables inside the anonymous class.

### Example:

```java
void method() {
    int d = 5; // effectively final
    Runnable r = new Runnable() {
        @Override
        public void run() {
            System.out.println(d);  Access
            d = 10;  Compile error
        }
    };
}
```

---

## 2- Method Context

*  Anonymous classes can be used in:

  * Static methods
  * Instance methods
  * Constructors
  * Initializer blocks

---

## 3- Accessing Superclass Members

*  Anonymous classes can access:

  * All **accessible members** of their superclass/interface
  * **Final/effectively final** local variables from enclosing scope
  * **Members of enclosing class** (if it's a non-static anonymous class)

### Example:

```java
class Super {
    protected int value = 10;
}

public class Test {
    public static void main(String[] args) {
        Super s = new Super() {
            void print() {
                System.out.println(value);  Access superclass member
            }
        };
    }
}
```

---

## 4- Static Members in Anonymous Classes

*  Cannot use:

  * Static blocks
  * Static methods
  * Static variables

*  Can declare **static final constants**:

```java
var obj = new Object() {
    // static { }  Error
    // static void method() {}  Error
    // static int x = 10;  Error

    static final int CONSTANT = 100;  Valid
};
```

---
## 5- Using Instance Variables in Lambda Expressions


``` java
// Java Program Illustrating Lambda Expression with Instance Variables 


// Interface 
interface MyInterface { 
    void myFunction(); 
} 

// Main class 
class GFG { 
    // Custom initialization
    int data = 170; 

    // Main driver method 
    public static void main(String[] args) { 
        // Creating object of this class 
        GFG gfg = new GFG(); 

        // Creating object of interface 
        MyInterface intFace = () -> { 
            System.out.println("Data: " + gfg.data); 
            gfg.data += 500; 
            System.out.println("Data after modification: " + gfg.data); 
        }; 

        // Using the lambda expression
        intFace.myFunction(); 

        // Modifying the instance variable
        gfg.data += 200; 
        System.out.println("Final Data: " + gfg.data); 
    } 
}


```
Output
``` {text}
Data: 170
Data after modification: 670
Final Data: 870
```


 Note:

* Lambda expressions in Java **can access and modify instance variables**.
* This is different from **local variables**, which must be **final or effectively final** when used inside lambdas.
