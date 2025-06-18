
##  What is Dependency Injection?

**Dependency Injection** is a design pattern used to achieve **Inversion of Control (IoC)** — instead of a class creating its own dependencies (objects that a class needs) 
, the object doesn’t control its dependencies, someone else does **(like a framework)**.

>  Example: Instead of `new Service()`, the framework injects `Service` into your class.

This makes code:

* Easier to test
* Loosely coupled
* More maintainable

---

##  What is Loose Coupling?

**Loose coupling** means that classes **know as little as possible about each other**. They **depend on abstractions** (interfaces), not concrete implementations.

> Opposite: **Tight coupling** = Class A directly creates and depends on Class B, making it hard to test, extend, or modify without breaking things.

---
## Example for Dependency Injection Design Pattern

Imagine you're building an application that sends notifications to users.
You want to make the notification system flexible so you can change the
notification provider (email, SMS, etc..)
without modifying the core application logic.

## 🧱 Problem: Tight Coupling Example (No DI, Bad Practice)

```java

public class EmailProvider {
    public void sendNotification(String message,String recipient) {
        // ...
    }
}
public class NotificationService {
    private EmailProvider emailProvider = new EmailProvider();

    public void sendNotification(String message, String recipient) {
        emailProvider.sendNotification(message, recipient);
    }
}

```

### ❌ Problems:

* `NotificationService` is tightly coupled to `EmailProvider`.
* Cannot replace `EmailProvider` with, say, `SMSProvider`.
* Testing `NotificationService` in isolation is challenging as it directly uses `EmailProvider`.

---

## ✅ Solution: Loose Coupling with DI (Best Practice)

### Step 1: Create an Interface (Abstraction)

```java

// Interface for different notification providers
public interface NotificationProvider{
    void sendNotification(String message,String recipient);
}

```

### Step 2: Implement the Interface

```java

// Concrete implementations
public class EmailProvider implements NotificationProvider {
    @Override
    public void sendNotification(String message,String recipient) {
        // Send email logic
    }
}

public class SMSProvider implements NotificationProvider{
    @Override
    public void sendNotification(String message,String recipient){
        // Send SMS logic
    }
}

```

### Step 3: Inject the Dependency (Constructor Injection)

```java

// Dependency is injected via constructor
public class NotificationService {
    private NotificationProvider notificationProvider;
    // inject dependency
    NotificationService(NotificationProvider notificationProvider){
        this.notificationProvider = notificationProvider;
    }
    public void sendNotification(String email,String recipient) {
        notificationProvider.sendNotification(email,recipient);
    }
}

```

### Step 4: Use It (Manual DI in Java)

```java

public class Main {
    public static void main(String[] args) {
        // You decide which implementation to inject
        NotificationService notificationService1 = new NotificationService(new EmailProvider());
        NotificationService notificationService2 = new NotificationService(new SMSProvider());
    }
}

```

---

## Benefits of Dependency Injection

| Benefit           | Explanation                                                                                                   |
| ------------------| --------------------------------------------------------------------------------------------------------------|
| **Loose Coupling**| NotificationService no longer depends on a specific implementation, making it adaptable to different providers|
|  **Flexible**     | You can change the notification provider at runtime by configuring the injection mechanism.                   |
|  **Testable**     | You can easily inject mock providers for testing NotificationService in isolation.                            |
|  **Maintainable** | Change in one class doesn't break others                                                                      |
|  **Reusable**     | Components are independent and reusable                                                                       |

---

## Types of Dependency Injection

There are mainly three types of dependency injection, that are
Constructor Injection, Setter Injection and Interface Injection.

Let's understand these three approaches to dependency injection using an example with the implementation.

```{text}
You are building a Vehicle Management System for a car rental service.
The system needs to manage cars and their engines. Each car should have an engine type,
and the system should ensure that the car has all necessary components when it's instantiated.
```

---

### 1. Constructor Injection

With Constructor Injection, dependencies are provided to a class through its constructor when the object is created.
This is the most common form of DI because it makes dependencies clear, mandatory, and immutable after the object is constructed.



``` java
engine.start();
class Engine {
    public void start() {
        System.out.println("Engine started");
    }
}
​
class Car {
    private Engine engine;  // Declaring a dependency on Engine
​
    // Constructor Injection: Dependency is provided through the constructor
    public Car(Engine engine) {
        this.engine = engine;  // Engine dependency is injected via constructor
    }
​
    public void drive() {
        engine.start();  // Using the injected Engine dependency
        System.out.println("Car is driving");
    }
}
​
public class Main {
    public static void main(String[] args) {
        Engine engine = new Engine();  // Create Engine object (dependency)
​
        // Injecting Engine dependency when creating Car
        Car car = new Car(engine);  // Pass the Engine instance to the constructor
        car.drive();  // Call the drive method to use the Engine
    }
}
```
```output
Engine started
Car is driving
```

#### Engine Class:
  Defines a simple class with a `start()` method to simulate starting an engine.
#### Car Class:
It has a dependency on Engine (i.e., Car needs an Engine to drive).
The Car class's constructor takes an Engine object as a parameter.
This is where the constructor injection happens—Engine is passed in when Car is created.
Inside the `drive()` method, the Car uses the engine to call `engine.start()`.
#### Main Method:
A new Engine is created and passed to the Car constructor. This injects the dependency into Car.
Then, the `drive()` method of Car is called, which uses the injected Engine to start the car and print the output.

---

### 2. Setter Injection
Setter Injection involves providing the dependency via a setter method after the object is created.
This approach is more flexible than constructor injection because it allows dependencies to be set or changed after object creation.


``` java

class Engine {
    public void start() {
        System.out.println("Engine started");
    }
}
​
class Car {
    private Engine engine;  // Declaring a dependency on Engine
​
    // No constructor injection here. Using setter to inject dependency
    public void setEngine(Engine engine) {
        this.engine = engine;  // Injecting dependency via setter method
    }
​
    public void drive() {
        engine.start();  // Using the injected Engine dependency
        System.out.println("Car is driving");
    }
}
​
public class Main {
    public static void main(String[] args) {
        Engine engine = new Engine();  // Create Engine object (dependency)
​
        // Create a Car object without providing the Engine immediately
        Car car = new Car();
​
        // Inject the Engine dependency using the setter method
        car.setEngine(engine);  // Set the dependency via the setter method
        car.drive();  // Call the drive method to use the Engine
    }
}
```

``` output
Engine started
Car is driving

```


#### Engine Class:

This is the same as in Constructor Injection. It has a `start()` method to simulate engine behavior.

#### Car Class:

Instead of passing the Engine dependency via the constructor,
it has a setter method `setEngine()` to allow the Engine to be injected after the object is created.
In the `drive()` method, the Car uses the engine dependency to call `start()`.


#### Main Method:

The Engine is created first, then a Car object is created.
The `setEngine()` method is called to inject the Engine dependency into the Car.
After the dependency is injected, `car.drive()` is called to use the engine.


--- 

### 3. Interface Injection
Interface Injection requires the class to implement an interface that provides a method for receiving the dependency.
This is less commonly used in Java, but it allows for more flexibility and decoupling.


``` java

class Engine {
    public void start() {
        System.out.println("Engine started");
    }
}
​
// Define an interface for injecting dependencies
interface EngineInjector {
    void injectEngine(Engine engine);  // Method to inject the Engine dependency
}
​
class Car implements EngineInjector {
    private Engine engine;  // Declaring a dependency on Engine
​
    // Implement the injectEngine method to set the Engine dependency
    @Override
    public void injectEngine(Engine engine) {
        this.engine = engine;  // Dependency injected through the interface method
    }
​
    public void drive() {
        engine.start();  // Using the injected Engine dependency
        System.out.println("Car is driving");
    }
}
​
public class Main {
    public static void main(String[] args) {
        Engine engine = new Engine();  // Create Engine object (dependency)
​
        Car car = new Car();  // Create Car object
        car.injectEngine(engine);  // Inject dependency via the injectEngine() method
        car.drive();  // Call the drive method to use the Engine
    }
}
```

``` output

Engine started
Car is driving

```

#### Engine Class:

This class has a `start()` method to simulate starting the engine.

#### EngineInjector Interface:

This interface defines a method injectEngine(Engine engine) which must be implemented by any class that wants to receive an Engine dependency.

#### Car Class:

The Car class implements the EngineInjector interface, meaning it must provide an implementation for the `injectEngine()` method.
In the `injectEngine()` method, the Car accepts the Engine and sets it.
The `drive()` method uses the injected Engine to call `start()`.

#### Main Method:

A new Engine object is created.
A Car object is created, and the `injectEngine()` method is used to inject the Engine dependency.
Finally, the `drive()` method is called on Car, which uses the injected Engine.


---
