
# Working with Objects in Java

## 1. Passing Objects to Methods

In Java, when you pass an object to a method, you are **passing the reference to that object**.

* The method receives a **copy of the reference**, not a copy of the object itself.
* So, **modifying the object inside the method will affect the original object**.

```java
class Dog {
    String name;

    Dog(String name) {
        this.name = name;
    }
}

public class Main {
    public static void main(String[] args) {
        Dog myDog = new Dog("Buddy");
        System.out.println("Before method call: " + myDog.name); // Output: Buddy

        changeName(myDog);
        System.out.println("After method call: " + myDog.name); // Output: Max
    }

    public static void changeName(Dog dog) {
        dog.name = "Max";
    }
}
```

---

## 2. Passing by Value vs. Passing by Reference

* **Java is always pass-by-value**.
* For **primitive types**, the value itself is passed.
* For **objects**, the reference is passed **by value**, meaning both the original and the method refer to the same object.

```java
class ClassName {
    int x;

    ClassName(int x) {
        this.x = x;
    }
}

public class Main {
    static void changeNumber(int x) {
        x += 10;
    }

    static void changeNumber2(ClassName c) {
        c.x += 10;
    }

    public static void main(String[] args) {
        int x = 10;
        changeNumber(x);
        System.out.println(x); // 10

        ClassName c = new ClassName(10);
        changeNumber2(c);
        System.out.println(c.x); // 20
    }
}
```

---

## 3. Returning Objects from Methods

* Methods can **return objects**, either newly created or modified ones.
* This is useful for object construction or method chaining.

```java
class Dog {
    String name;

    Dog(String name) {
        this.name = name;
    }
}

public class Main {
    public static void main(String[] args) {
        Dog myDog = createDog("Buddy");
        System.out.println("Dog's name: " + myDog.name); // Output: Buddy
    }

    public static Dog createDog(String name) {
        Dog newDog = new Dog(name);
        return newDog;
    }
}
```

---

## 4. Comparing Objects

* The `==` operator compares **object references**, not contents.
* Use the `.equals()` method or custom logic to compare **contents** of objects.

```java
class ClassName {
    int x;

    ClassName(int x) {
        this.x = x;
    }

    void isEqual(ClassName c) {
        System.out.println(this.x == c.x ? "equal" : "not equal");
    }
}

public class Main {
    public static void main(String[] args) {
        ClassName c1 = new ClassName(100);
        ClassName c2 = new ClassName(100);

        c1.isEqual(c2); // equal
        System.out.println(c1 == c2 ? "equal" : "not equal"); // not equal
    }
}
```

---
