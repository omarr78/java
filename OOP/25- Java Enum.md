## Enums (short for enumerations) 

* are a special data type in Java that enable a variable to be a set of predefined constants.
* They were introduced in Java 5 and provide a type-safe way to work with fixed sets of constants.

--- 

### 1. Enum Inside vs Outside Class

- Enum Defined Outside a Class

``` java 

  // Enum defined outside any class (in its own file or with other classes)

  enum Day {
      MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
  }
  
  public class Test {
      public static void main(String[] args) {
          Day today = Day.MONDAY;
          System.out.println("Today is " + today);
      }
  }

```

- Enum Defined Inside a Class

``` java 

  public class Test {
      // Enum defined inside a class
      enum Day {
          MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
      }
      
      public static void main(String[] args) {
          Day today = Day.MONDAY;
          System.out.println("Today is " + today);
      }
  }

```

Key differences:
- Outside class enums can be accessed from anywhere (if public)
- Inside class enums are typically only accessible within that class
- The enum can be made public/private/protected when inside a class

---
  
### 2. Enums with Constructors

- Enums can have constructors, which are called when each enum constant is created.

- Basic Enum Constructor

``` java

  enum Direction {
      NORTH("up"), 
      SOUTH("down"), 
      EAST("right"), 
      WEST("left");
      
      private String direction;
      
      // Constructor is private by default and can only be private
      Direction(String direction) {
          this.direction = direction;
      }
      
      public String getDirection() {
          return direction;
      }
  }
  
  public class Test {
      public static void main(String[] args) {
          Direction dir = Direction.NORTH;
          System.out.println(dir.getDirection()); // Output: up
      }
  }

```
Important points:
- Enum constructors are always private (you can omit the private keyword as it's implicit)
- You cannot instantiate enums using new keyword
- Each constant is initialized with the constructor parameters you provide

--- 

### 3. Abstract Methods in Enums : Enums can have abstract methods, which each constant must implement.

``` java
  enum Operation {
      PLUS {
          public double apply(double x, double y) {
              return x + y;
          }
      },
      MINUS {
          public double apply(double x, double y) {
              return x - y;
          }
      },
      TIMES {
          public double apply(double x, double y) {
              return x * y;
          }
      },
      DIVIDE {
          public double apply(double x, double y) {
              return x / y;
          }
      };
      
      // Abstract method that each constant must implement
      public abstract double apply(double x, double y);
  }
  
  public class Test {
      public static void main(String[] args) {
          double result = Operation.PLUS.apply(5, 3);
          System.out.println("5 + 3 = " + result); // Output: 5 + 3 = 8.0
          
          result = Operation.TIMES.apply(5, 3);
          System.out.println("5 * 3 = " + result); // Output: 5 * 3 = 15.0
      }
  }

  ```

Key points about abstract methods in enums:
- When you declare an abstract method in an enum, each constant must provide an implementation
- This is similar to creating anonymous classes for each constant
- This pattern is often called "constant-specific method implementation"

---

- Enums can implement interfaces but cannot Extend class
- Enums can declare Static and Instance Methods inside it
- there are two classes related to enums 
  - EnumSet
  - EnumMap

