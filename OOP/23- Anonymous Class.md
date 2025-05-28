### Anonymous classes : 
allow you to declare and instantiate a class at the same time.
They're useful when you need to create a one-time use class that doesn't need a name.

### 1.  Using Anonymous Class with Concrete Class
``` java
public class Greeter {
    public void greet() {
        System.out.println("Hello World");
    }
}

public class Main {
    public static void main(String[] args) {
        // Anonymous class extending Greeter
        Greeter greeter = new Greeter(){
            @Override
            public void greet() {
                System.out.println("Hello from anonymous class");
            }
            public void greetInSpanish(){
                System.out.println("Hola");
            }
        };
        greeter.greet(); // Calls the overridden method
        greeter.greetInSpanish(); // Won't compile - Greeter type doesn't have this method
    }
}
```

**you can call just one time** 

``` java
public class Main {
    public static void main(String[] args) {
        // Anonymous class extending Greeter
        new Greeter(){
            @Override
            public void greet() {
                System.out.println("Hello from anonymous class");
            }
        }.greet();
    }
}
```
---

### 2. Implementing Interface with Anonymous Class (and Lambda)
  * Anonymous classes are commonly used to implement interfaces. **`Since Java 8`** ,
  * lambda expressions provide a more concise way to implement functional interfaces (interfaces with a single abstract method).

``` java
interface Calculator {
  int calculate(int a, int b);
}

public class Main {
  public static void main(String[] args) {
      // Anonymous class implementing Calculator
      Calculator adder = new Calculator() {
          @Override
          public int calculate(int a, int b) {
              return a + b;
          }
      };
      
      System.out.println("Sum: " + adder.calculate(5, 3));
  }
}
```
**With Lambda Expression: For interfaces with a single abstract method (functional interfaces), you can use lambdas:**

``` java
  // With arguments
  Calculator multiplier = (a, b) -> a * b;
  System.out.println("Product: " + multiplier.calculate(5, 3));
  
  // Without arguments
  Runnable runner = () -> System.out.println("Running in anonymous Runnable");
  new Thread(runner).start();
  
  // With multiple statements (requires curly braces)
  Calculator complexCalc = (a, b) -> {
      int result = a * a + b * b;
      return result;
  };
```
---

### 3. Anonymous Class as Method Argument

``` java
public interface Show {
  public void print();
}

public class Main {

  public static void print(Show show){
      show.print();
  }
  public static void main(String[] args) {
      print(new Show() {
          @Override
          public void print() {
              System.out.println("Hello World");
          }
      });
  }
}
```

### Common use cases:

* Event listeners in Swing/GUI programming
* Thread creation with Runnable
* Comparator implementations for sorting
* Callbacks in asynchronous programming
      
      

