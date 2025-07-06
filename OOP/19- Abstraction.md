# Java Abstraction (with Examples & Rules)

### What is Abstraction?

Abstraction is the concept of **hiding internal implementation** details and exposing only the **essential features** of an object.

---

## Example: Abstract Class & Method

We want to model different shapes (like `Circle`, `Square`) with a **common method** `calculateArea()`.

### Abstract Class

```java
abstract class Shape {
    // Abstract method (no implementation)
    public abstract double calculateArea();

    // Concrete method (shared behavior)
    public void display() {
        System.out.println("This is a shape.");
    }
}
```

### Concrete Subclass: Circle

```java
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}
```

### Explanation:

* `Shape` defines an abstract method `calculateArea()`.
* `Circle` implements the method.
*  Cannot instantiate `Shape`:
  `Shape shape = new Shape(); // Error`

---


## Why Do Abstract Classes Have Constructors?

Although **abstract classes cannot be instantiated**, they **can have constructors** because:

### 1. For Initializing Common Fields

```java
abstract class Animal {
    String name;

    public Animal(String name) {  // Constructor
        this.name = name;
    }

    public abstract void makeSound();
}
```


### 2. For Constructor Chaining in Subclasses

```java
class Dog extends Animal {
    public Dog(String name) {
        super(name); // Calls Animal's constructor
    }

    @Override
    public void makeSound() {
        System.out.println("Bark!");
    }
}
```

When `Dog` is created, the `Animal` constructor runs first.

---



## Polymorphism with Abstract Classes

> Abstract class reference can point to subclass objects ➜ **Runtime Polymorphism**

```java
abstract class Vehicle {
    public abstract void move();
}

class Car extends Vehicle {
    public void move() {
        System.out.println("Car drives on road.");
    }
}

class Boat extends Vehicle {
    public void move() {
        System.out.println("Boat sails on water.");
    }
}
```

```java
public class Main {
    public static void main(String[] args) {
        Vehicle vehicle1 = new Car();   // Polymorphism
        Vehicle vehicle2 = new Boat();  // Polymorphism

        vehicle1.move();  // Output: Car drives on road.
        vehicle2.move();  // Output: Boat sails on water.
    }
}
```

`Vehicle` reference can hold any subclass — enabling **flexible design**.

---

## Rules for Abstract Classes & Methods

| Rule                                                   |  Example                                      | Why?                                                     |
| ------------------------------------------------------ | --------------------------------------------- | ---------------------------------------------------------- |
| 1. Abstract methods **cannot** be `private`            | `private abstract void demo();`               | Private methods can't be inherited or overridden           |
| 2. Abstract classes **cannot** be `final`              | `final abstract class Test {}`                | Final prevents inheritance, but abstract needs subclassing |
| 3. Class with abstract methods **must** be abstract    | `class Test { abstract void demo(); }`        | Compilation error if not declared `abstract`               |
| 4. Abstraction applies **only** to classes and methods | Variables or constructors can't be `abstract` or `static methods` | Only classes & methods support abstraction                 |
                                                            
---

### Valid Use Examples:

```java
abstract class Animal { }          // Abstract class

abstract class Animal {
    abstract void eat();          // Abstract method
}

abstract class Animal {
    abstract void eat();  // Valid
}

```

You **cannot** write:

```java
abstract int x = 10;              //  Invalid
abstract Animal();                //  Constructor can't be abstract
```

---

