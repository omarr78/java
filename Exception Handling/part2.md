## Finally block
- **finally** block in Java can be used to put `cleanup` code
such as **closing a file**, **closing connection**,
etc.
- Rule: For each try block there can be zero or more catch
blocks, but `only one finally block`.
- A **finally** block is always get executed whether the exception
has occurred or not.
## Example code
``` java
try{
    int [] arr = new int[5];
    arr[7] = 5;
}catch(ArrayIndexOutOfBoundsException e){
    System.out.println(e.getMessage());
    return;
}
finally {
    System.out.println("finally");
}
System.out.println("Rest of code");
```
## output
```{text}
Index 7 out of bounds for length 5
finally
```
## Example code
```java
public class Main {
  public static void main(String[] args) {
      System.out.println(getNum());
  }
  static int getNum(){
      try{
          return 1;
      }
      catch(Exception e){
          return 2;
      }
      finally{
          return 3;
      }
  }
}
```
## output
```{text}
3
```
#### Execution Flow:
1. **`try` block executes**:
   - `return 1;` is encountered, but **Java does not immediately return**.
   - Instead, it **remembers** that `1` should be returned **after** `finally` executes.

2. **`finally` block executes**:
   - `return 3;` is encountered.
   - Since `finally` always runs (unless `System.exit()` is called), this **overrides** the previous `return 1;`.

3. **Result**:
   - The method returns `3`, **not** `1`.

> Note:
> 
> The finally block will not be executed if the program exits (either
by calling **System.exit()** or by causing a **fatal error** that causes the
process to abort).

---

## There are three main categories of exceptional conditions:
### Checked exceptions (Compile-time exceptions)
- A checked exception is an exception that is checked (notified) by
the compiler at compilation-time, these are also called as compile
time exceptions. These exceptions cannot simply be ignored, the
programmer should take care of (handle) these exceptions.
### Unchecked exceptions (Runtime exceptions)
- An unchecked exception is an exception that occurs at the time of
execution. These are also called as Runtime Exceptions. These include
programming bugs, such as logic errors or improper use of an API.
Runtime exceptions are ignored at the time of compilation.
### Errors
- Errors represent serious and usually irrecoverable conditions like a
library incompatibility, infinite recursion, or memory leaks.

![JAVA Exception Handling](https://github.com/user-attachments/assets/a63807a9-8501-430c-b1fe-766e5e5ac697)

# Difference Between Exception and Error

Both **Exception** and **Error** are subclasses of the Java `Throwable` class (`java.lang` package).

| Basis of Comparison | Exception | Error |
|---------------------|----------|-------|
| **Classification**  | Can be **checked** (compile-time) or **unchecked** (runtime). | All errors are **unchecked** (runtime). |
| **When it occurs**  | Occurs at **compile time** (checked) or **runtime** (unchecked). | Occurs only at **runtime**. |
| **Causes** | Mainly caused by the **application itself** (e.g., invalid input, file not found). | Caused by the **environment** (e.g., `OutOfMemoryError`, `StackOverflowError`). |
| **Recoverable?** | Can be **recovered** using `try-catch` blocks. | **Not recoverable** should not try to catch it (handling is usually impossible). |
| **Example** | `IOException`, `NullPointerException`, `ArrayIndexOutOfBoundsException` | `OutOfMemoryError`, `StackOverflowError`, `NoClassDefFoundError` |

## How to handle **Checked Exception**
- The code below shows the `FileInputStream` method from the `java.io` package with a red line underneath.
``` java 
public class CheckedException { 
public void readFile() {
    String fileName = "file does not exist";
    File file = new File(fileName);
        FileInputStream stream = new FileInputStream(file); //Unhandled checked exception
    } 
}
```
## The red line is because this method throws a checked exception and the compiler is forcing us to handle it. You can do this in one of two ways

1- Try Catch
``` java
public class CheckedException { 
  public void readFile() {
      String fileName = "file does not exist"; 
      File file = new File(fileName);
      //Using try-catch block to handle the exception
      try {
          FileInputStream stream = new FileInputStream(file); 
          } catch (FileNotFoundException e) {
                          e.printStackTrace();
          }
  }
}

```
2- Throws
- We use the keyword throws to throw the exception up the stack to the calling method to handle

``` java
public class CheckedException {
  //Throwing the exception up the stack using throws keyword
  public void readFile() throws FileNotFoundException {
      String fileName = "file does not exist";
      File file = new File(fileName);
      FileInputStream stream = new FileInputStream(file);
  }
}

```




## try with resources
``` java
try (FileInputStream fin = new FileInputStream(filePath)) {
    System.out.println("file content: ");
    int r = 0;
    while ((r = fin.read()) != -1) {
        System.out.print((char) r);
    }
} catch (FileNotFoundException e) {
    System.out.println(e);
} catch (IOException e) {
    System.out.println(e);
}
```
- `FileInputStream fin = new FileInputStream(filePath)` opens a file stream
- This will automatically close the stream when done without needs of **finally**

---

# Throw keyword
- The throw keyword is used to create a custom exception or error.
- The throw keyword in Java is used to explicitly throw an exception
from a method or any block of code. We can throw either checked
or unchecked exception.

## Example on (trow an unchecked Excpetion)
``` java
public class Main {
    public static void main(String[] args) {
        int s = getSize();
        int[] arr = new int[s];
    }

    static int getSize() {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        if (size < 1) throw new IllegalArgumentException("size must be positive");
        return size;
    }
}
```
## Example on (trow an checked Excpetion)
``` java
public void openFile() throws FileNotFoundException {
    String fileName = "file.txt";
    File file = new File(fileName);
    if (!file.exists()) {
        throw new FileNotFoundException("file not found");
    }
}
```
----
