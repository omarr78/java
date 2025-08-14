## What Is the Singleton Pattern?

The **Singleton** is a **creational design pattern**, It ensures that:

1. **Only one instance** of a class exists throughout the application.
2. There is a **global access point** to that instance.

<img width="317" height="211" alt="Singleton-Pattern-Java" src="https://github.com/user-attachments/assets/1f67b971-6091-48c9-bab5-010810d6eb45" />


---

## Why and When to Use It

### **Why use Singleton?**

* **Controlled access**: Useful when exactly one object coordinates actions across the system (e.g., logging, configuration).
* **Resource management**: Prevents conflicts over shared resources like database connections or print queues.
* **Global accessibility**: Simplifies client access via a single, central instance.
* **Lazy initialization**: The instance can be created only when needed.

### **When should you use it?**

* When **only one instance** is required globally.
* When **multiple modules need access** to the same single resource.

---

## Key Components of a Singleton Class

1. **Private static variable** to hold the single instance.
2. **Private constructor** to prevent external instantiation.
3. **Public static method**, often named `getInstance()` or `Instance`, to retrieve/create the instance.
4. **Thread-safety measures** (if needed), such as synchronization or double-checked locking.

---

## Example Code – Java (with lazy initialization & thread safety)

```java
public class Singleton {
    private static Singleton instance;
    private Singleton() { }
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
```


---
