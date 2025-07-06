
# Java Casting: Upcasting and Downcasting

In Java, we have **two types of casting**:

1. **Upcasting**
2. **Downcasting**

---

##  Now Let’s first understand the definitions:

### 1. Upcasting

> Assigning a **child class object** to a **parent class reference**.

```java
Animal animal = new Dog(); // Animal is a parent class reference, pointing to a Dog object
```

    
* The reference `animal` can **access only**:
    * Methods/variables from the **parent class**
    * **Overridden methods** from the child class
* **Upcasting gives us the flexibility to access the parent class members, but it is not possible to access all the child class members using this feature.**
* **Safe and error-free at runtime**
* **Can be done implicitly** casting — no need to write:
  `Animal animal = (Animal) new Dog();`

#### Memory Reference Example:

```java
Dog myDog = new Dog();  // Creates a Dog object in memory
Animal myAnimal = myDog; // Both references point to THE SAME OBJECT
```

    Before assignment:
          
      myDog → [Dog object at 0x1000]
      myAnimal → null
    
    After assignment:
      
      myDog → [Dog object at 0x1000]
                 ↑
      myAnimal ──┘

---


### 2. Downcasting

> Assigning a **parent reference** (which points to a child object) to a **child class reference**.


```java
Dog myDog = (Dog) animal;
```

* Now this child class reference myDog Can access **all child and parent methods**.
* Must be done **explicitly**
* **Potentially unsafe**
* Can throw `ClassCastException`
* Use `instanceof` for **type safety**

```java
if (animal instanceof Dog) {
    Dog dog = (Dog) animal;
    dog.growl();
}
```
``` text
For example, if we have two classes, say (Animal) and (Dog) which extends (Animal) class. Now for upcasting,
every Dog will be a Animal but for downcasting,
every Animal may not be a Dog because there may be some Animals which can be Cat, Camel, etc.
Hence downcasting is not always safe, and we explicitly write the class names before doing downcasting.
So that it won’t give an error at compile time but it may throw ClassCastExcpetion at run time,
if the parent class reference is not pointing to the appropriate child class.
To get rid of ClassCastException we can use instanceof operator to check right type of class reference in case of down casting.
```

---

## Why Do We Need Upcasting in Java?


### Example:

```java
public class Animal {
    String name;
    public void makeNoise() {
        System.out.println("I'm just an animal");
    }
}

public class Dog extends Animal {
    @Override
    public void makeNoise() {
        System.out.println("woof woof!");
    }
    public void growl() {
        System.out.println("Grrrr");
    }
}

public class Cat extends Animal {
    @Override
    public void makeNoise() {
        System.out.println("mew mew mew mew");
    }
}
```

---

### Main Class Example 1: Upcasting in Action

```java
public class Main {
    public static void main(String[] args) {
        Animal animal = new Dog();
        doAnimalStuff(animal); // woof woof!

        Dog dog = new Dog();
        doAnimalStuff(dog); // woof woof!

        Cat cat = new Cat();
        doAnimalStuff(cat); // mew mew mew mew
    }

    public static void doAnimalStuff(Animal animal) {
        animal.makeNoise();
    }
}
```

---

### Main Class Example 2: Downcasting with `instanceof`

```java
public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat();
        doAnimalStuff(cat); // mew mew mew mew

        Dog dog = new Dog();
        doAnimalStuff(dog);
        // woof woof!
        // Grrrr
    }

    public static void doAnimalStuff(Animal animal) {
        animal.makeNoise();

        if (animal instanceof Dog) {
            Dog dog = (Dog) animal;
            dog.growl();
        }
    }
}
```

---

## Polymorphic Arrays

### let's take an example :

```java
// base class

class Animal {
    private String name;
    
    public Animal(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void makeSound() {
        System.out.println("Some generic animal sound");
    }
    
    public void eat() {
        System.out.println(name + " is eating");
    }
}

// Derived classes

class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }
    
    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Woof!");
    }
    
    public void fetch() {
        System.out.println(getName() + " is fetching the ball");
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
    
    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Meow!");
    }
    
    public void climb() {
        System.out.println(getName() + " is climbing a tree");
    }
}

class Bird extends Animal {
    public Bird(String name) {
        super(name);
    }
    
    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Tweet!");
    }
    
    public void fly() {
        System.out.println(getName() + " is flying");
    }
}

```

--- 

### Main Class: `Zoo`

``` java
public class Zoo {
    public static void main(String[] args) {
        // Create a polymorphic array of Animals
        Animal[] animals = new Animal[5];
        
        // Populate with different animal types (upcasting happens automatically)
        animals[0] = new Dog("Rex");
        animals[1] = new Cat("Whiskers");
        animals[2] = new Bird("Tweety");
        animals[3] = new Dog("Buddy");
        animals[4] = new Cat("Mittens");
        
        // Process all animals polymorphically
        System.out.println("=== All animals making sounds ===");
        for (Animal animal : animals) {
            animal.makeSound(); // Dynamic polymorphism - calls appropriate version
        }
        
        System.out.println("\n=== All animals eating ===");
        for (Animal animal : animals) {
            animal.eat(); // Inherited from Animal, same for all
        }
        
        // Accessing derived-class specific methods
        System.out.println("\n=== Special behaviors ===");
        for (Animal animal : animals) {
            if (animal instanceof Dog) {
                Dog dog = (Dog) animal; // Downcasting
                dog.fetch();
            } else if (animal instanceof Cat) {
                Cat cat = (Cat) animal; // Downcasting
                cat.climb();
            } else if (animal instanceof Bird) {
                Bird bird = (Bird) animal; // Downcasting
                bird.fly();
            }
        }
        
        // Count each animal type
        System.out.println("\n=== Animal census ===");
        int dogs = 0, cats = 0, birds = 0;
        for (Animal animal : animals) {
            if (animal instanceof Dog) dogs++;
            else if (animal instanceof Cat) cats++;
            else if (animal instanceof Bird) birds++;
        }
        System.out.println("Dogs: " + dogs + ", Cats: " + cats + ", Birds: " + birds);
    }
}
```

### 🖨️ Output

```
=== All animals making sounds ===
Rex says: Woof!
Whiskers says: Meow!
Tweety says: Tweet!
Buddy says: Woof!
Mittens says: Meow!

=== All animals eating ===
Rex is eating
Whiskers is eating
Tweety is eating
Buddy is eating
Mittens is eating

=== Special behaviors ===
Rex is fetching the ball
Whiskers is climbing a tree
Tweety is flying
Buddy is fetching the ball
Mittens is climbing a tree

=== Animal census ===
Dogs: 2, Cats: 2, Birds: 1
```

---

## Key Takeaways About Polymorphic Arrays

* **Array Declaration**:

  * `Animal[] animals` can hold any subclass of `Animal`

* **Upcasting**:

  * Happens **automatically** when assigning `new Dog()`, `new Cat()`, etc.

* **Polymorphic Calls**:

  * `animal.makeSound()` will call the **appropriate** overridden version

* **Downcasting**:

  * Required to access **subclass-specific methods** (e.g., `fetch()`, `climb()`)

* **Runtime Type Checking**:

  * Use `instanceof` to check actual object type safely

* **Uniform Processing**:

  * Handle all animals in a **single loop**

* **Flexibility**:

  * Easy to **extend** the system (e.g., add `Elephant`) with minimal code changes

---
