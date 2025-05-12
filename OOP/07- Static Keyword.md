# Static Keyword in Java

## Introduction

In Java, the `static` keyword is used to define members (variables, methods, blocks, and nested classes) that belong to the class itself, rather than to any specific instance of the class.

This means that static members are shared across all instances of the class and can be accessed `without creating an object of the class.`

---

## 1. Static Variables

A **static variable** is a class-level variable that is shared among all instances of the class. It is initialized only once, at the start of the program execution, and retains its value throughout the lifetime of the program.

### Key Points

* Static variables are also known as **class variables**.
* They are declared using the `static` keyword.
* Stored in the **method area** of memory.
* Can be accessed using the **class name** directly, without creating an instance.

### Declaration

```java
public class MyClass {
    static int staticVar = 10; // Declaration with explicit initialization
}
```

```java
public class MyClass {
    static int staticVar;
    static {
        staticVar = 20; // Initialization in a static block
    }
}
```

### Benefits

* **Memory Efficiency**: Stored only once in memory, reducing usage.
* **Global Access**: Can be accessed using the class name.
* **Consistency**: All instances share the same value.

### Example

```java
public class Student {
    String id;
    static String year = "2025";
    static int countId = 1;
    String name;
    static String college = "IT";

    Student(String name){
        this.name = name;
        this.id = year + countId++;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
```

```java
public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("John");
        Student s2 = new Student("Jane");
        Student s3 = new Student("Jack");

        System.out.println(s1.toString()); // Student{id='20251', name='John'}
        System.out.println(s2.toString()); // Student{id='20252', name='Jane'}
        System.out.println(s3.toString()); // Student{id='20253', name='Jack'}
    }
}
```

---

## 2. Static Methods

A **static method** belongs to the class rather than any instance. It can be called using the class name without creating an object of the class.

### Key Points

* Can only access **static variables and methods** directly.
* `this` and `super` **cannot** be used in static context.
* Cannot access instance variables or methods directly.
* Commonly used for **utility functions** like `Math.sqrt()`, `Arrays.sort()`.

### Example

```java
class MathUtils {
    static int add(int a, int b) {
        return a + b;
    }

    static int subtract(int a, int b) {
        return a - b;
    }
}
```

```java
public class Main {
    public static void main(String[] args) {
        int sum = MathUtils.add(5, 3);
        System.out.println("Sum: " + sum); // Output: Sum: 8

        int difference = MathUtils.subtract(10, 4);
        System.out.println("Difference: " + difference); // Output: Difference: 6
    }
}
```

---

## 3. Static Blocks

A **static block** is used to initialize static variables or perform some one-time setup tasks when the class is loaded into memory.

### Key Points

* Executed **only once** when the class is loaded.
* Defined using the `static` keyword followed by `{}`.

### Benefits

* **One-Time Initialization**.
* Handles **complex initialization logic**.
* Executed **before constructors**.

### Example Use Case

Used for loading configuration files, initializing DB connections, or complex static variable setup.

```java
class Database {
    static String url;
    static String username;
    static String password;

    static {
        url = "jdbc:mysql://localhost:3306/mydb";
        username = "root";
        password = "password";
        System.out.println("Database configuration loaded.");
    }

    static void connect() {
        System.out.println("Connecting to database with URL: " + url);
    }
}
```

```java
public class Main {
    public static void main(String[] args) {
        Database.connect();
        // Output:
        // Database configuration loaded.
        // Connecting to database with URL: jdbc:mysql://localhost:3306/mydb
    }
}
```

---

## 4. Static Classes

In Java, only **nested classes** can be declared static. A **static nested class** is defined inside another class but does **not** have access to the outer class’s instance variables or methods.

### Key Points

* Can access **only static members** of the outer class.
* Can be **instantiated without** an instance of the outer class.
* Useful for **grouping utility/helper classes** inside a main class.
* Improves **code organization** and encapsulation.

### Code Example 1

```java
public class OuterClass {
    static int outerStaticVar = 10;
    int outerInstanceVar = 20;

    static class InnerClass {
        static void display() {
            System.out.println("Outer static variable: " + outerStaticVar);
            // Cannot access outerInstanceVar
        }
    }
}

public class Main {
    public static void main(String[] args) {
        OuterClass.InnerClass.display();
    }
}
```

### Code Example 2

```java
class OuterClass {
    static int outerStaticVar = 10;
    int outerInstanceVar = 20;

    static class StaticNestedClass {
        void display() {
            System.out.println("Outer static variable: " + outerStaticVar);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        OuterClass.StaticNestedClass nestedObj = new OuterClass.StaticNestedClass();
        nestedObj.display(); // Output: Outer static variable: 10
    }
}
```

### Code Example 3 — All Types of Static

```java
class AppConfig {
    // Static variable
    static String appName;

    // Static block
    static {
        appName = "MyApp";
        System.out.println("AppConfig loaded. App Name: " + appName);
    }

    // Static method
    static void printAppInfo() {
        System.out.println("App Name: " + appName);
    }

    // Static nested class
    static class Logger {
        static void log(String message) {
            System.out.println("[" + appName + "] LOG: " + message);
        }
    }
}
```

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("App Name: " + AppConfig.appName);

        AppConfig.printAppInfo();

        AppConfig.Logger.log("Application started.");
    }
}
```

**Output:**

```
AppConfig loaded. App Name: MyApp
App Name: MyApp
App Name: MyApp
[MyApp] LOG: Application started.
```

---
