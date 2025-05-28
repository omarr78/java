## Example on interface 

**we have two interfaces (Movable , SelfDriving)**

**Movable**

```{text}
+ moveUp() : void
+ moveDown() : void
+ moveLeft() : void
+ moveRight() : void
```
**SelfDriving**

```{text}
+ destination (String) : void
+ drive () : void
```

**and Car Class that implements two interfaces**

``` java
public interface Movable {
    void moveUp();
    void moveDown();
    void moveLeft();
    void moveRight();
}

public interface SelfDrivable {
    void destination(String d);
    void drive();
}


public class Car implements SelfDrivable, Movable {
    private int x,y;

    public Car() {}
    public Car(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void moveUp() {
        y++;
    }

    @Override
    public void moveDown() {
        y--;
    }

    @Override
    public void moveLeft() {
        x--;
    }

    @Override
    public void moveRight() {
        x++;
    }

    @Override
    public void destination(String d) {
        System.out.println("Destination: " + d);
    }

    @Override
    public void drive() {
        System.out.println("Drive");
    }
}
```

---

## Default Methods in Interfaces (java 8)

```text
Why We Need Default Methods? 
When new methods are added to interfaces, all implementing classes would break.
Default methods allow adding new functionality without breaking existing implementations. 
```

**Basic Example of Default Method**

```java
interface Vehicle {
    // Regular abstract method
    void start();
    
    // Default method
    default void honk() {
        System.out.println("Vehicle is honking!");
    }
}

class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car is starting");
    }
    
    // honk() is inherited as-is, but can be overridden
    // @Override
    // public void honk() {
    //    System.out.println("car is honking");
    // }
    
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.start();  // Output: Car is starting
        car.honk();   // Output: Vehicle is honking!
    }
}
```
---

## Conflict Resolution Scenarios

### Scenario 1: Class Implements Two Interfaces with Identical Default Methods

``` java
interface InterfaceA {
    default void show() {
        System.out.println("InterfaceA show");
    }
}

interface InterfaceB {
    default void show() {
        System.out.println("InterfaceB show");
    }
}

class MyClass implements InterfaceA, InterfaceB {
    // COMPILATION ERROR: Duplicate default methods named show
    // Must override to resolve ambiguity
    
    @Override
    public void show() {
        // Can choose one implementation or provide new one
        InterfaceA.super.show();  // Explicitly call InterfaceA's version
        // or
        System.out.println("MyClass implementation");
    }
}
```

### Scenario 2: Class Implements Two Interfaces - One Default, One Abstract

``` java
interface InterfaceC {
    default void display() {
        System.out.println("InterfaceC default display");
    }
}

interface InterfaceD {
    void display();  // abstract method
}

class AnotherClass implements InterfaceC, InterfaceD {
    // Must implement display() because InterfaceD's abstract method
    // takes precedence over InterfaceC's default method
    
    @Override
    public void display() {
        System.out.println("AnotherClass implementation");
        // Can still access InterfaceC's default if needed:
        // InterfaceC.super.display();
    }
}
```

### Scenario 3: Class Inheritance vs Interface Default Method

```java
class ParentClass {
    public void print() {
        System.out.println("ParentClass print");
    }
}

interface Printable {
    default void print() {
        System.out.println("Printable default print");
    }
}

class ChildClass extends ParentClass implements Printable {
    // No conflict - class method takes precedence over interface default
}

public class Main {
    public static void main(String[] args) {
        ChildClass cc = new ChildClass();
        cc.print();  // Output: ParentClass print
    }
}
```

### Practical Example with Multiple Scenarios

``` java
interface Flyable {
    default void travel() {
        System.out.println("Flying through the air");
    }
}

interface Swimmable {
    default void travel() {
        System.out.println("Swimming through water");
    }
}

class Animal {
    public void travel() {
        System.out.println("Walking on land");
    }
}

// Scenario 1: Implements two interfaces with conflicting defaults
class Duck implements Flyable, Swimmable {
    @Override
    public void travel() {
        // Choose which default to use or provide new implementation
        if (Math.random() > 0.5) {
            Flyable.super.travel();
        } else {
            Swimmable.super.travel();
        }
    }
}

// Scenario 2: Extends class and implements interface with same method
class Frog extends Animal implements Swimmable {
    // Animal's travel() takes precedence over Swimmable's default
}

public class Main {
    public static void main(String[] args) {
        Duck duck = new Duck();
        duck.travel();  // Will randomly choose flying or swimming
        
        Frog frog = new Frog();
        frog.travel();  // Output: Walking on land (from Animal)
        
        // But we can still upcast to access interface default
        Swimmable swimFrog = frog;
        swimFrog.travel();  // Output: Swimming through water
    }
}
```

---
### Static Methods in Interfaces allowed

> **Note:** Static methods were introduced in interfaces starting with Java 8,
> alongside default methods. This addition further enhanced the capabilities of interfaces in Java.

