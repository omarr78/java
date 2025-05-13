## What is an Exception?
- An exception is an unwanted or unexpected event, which
occurs during the execution of a program i.e at run time, that
disrupts the normal flow of the program's instructions.
## An exception can occur for many different reasons:
- A user has entered an invalid data.
- A file that needs to be opened cannot be found.
- A network connection has been lost in the middle of communications.

## **Code Example**
```java
try {
    int[] arr = new int[5];  // Creates an array of size 5 (indices 0-4)
    arr[10] = 7 / 0;         // This line will throw an exception
    System.out.println("break"); // This line will NOT execute
} catch (ArrayIndexOutOfBoundsException | ArithmeticException ex) {
    System.out.println(ex);  // Catches and prints the exception
} catch (Exception ex) {
    System.out.println(ex);  // Catches any other exception
}
System.out.println("rest of the code");  // This will execute after handling
```

---

### **1. `try` Block Execution**
- `int[] arr = new int[5];`  
- `arr[10] = 7 / 0;`  
  → This line has **two potential exceptions**:
  1. **`ArrayIndexOutOfBoundsException`** (since index `10` is out of bounds).
  2. **`ArithmeticException`** (division by zero: `7 / 0`).

- **Which Exception is Thrown First?**  
  Java evaluates expressions **left-to-right**, so:
  - First, it checks `arr[10]` → **`ArrayIndexOutOfBoundsException`** is thrown immediately.
  - The division (`7 / 0`) **never happens** because the exception occurs first.

- **`System.out.println("break");`**  
  → This line **never executes** because an exception was thrown before it.

---

### **2. `catch` Block Handling**
- The exception is *thrown by the JVM* when you try to access `arr[10]` (invalid index)
- The exception object is automatically created by the JVM with specific details about the error
- `e.getMessage()` will return a helpful message like "Index 7 out of bounds for length 5"
- The exception is caught by the appropriate `catch` block:
```java
catch (ArrayIndexOutOfBoundsException | ArithmeticException ex) {
    System.out.println(ex);  // Prints the exception details
}
```
- Since the thrown exception is `ArrayIndexOutOfBoundsException`, this block catches it.
- The `|` (pipe) symbol allows **multi-catch** (handling multiple exceptions in one block).
- `System.out.println(ex);` prints the exception, e.g.:
  ```
  java.lang.ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 5
  ```

- The second `catch (Exception ex)` block is **not executed** because the first `catch` already handled the exception.

---

### **3. After Exception Handling**
```java
System.out.println("rest of the code");
```
- This line **executes normally** because the exception was caught and handled.
- Output:
  ```
  java.lang.ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 5
  rest of the code
  ```

---


