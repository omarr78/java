# Relationships Between Classes in Java OOP

In object-oriented programming (OOP), relationships between classes define how objects interact with each other.
Java supports **three main types of relationships**:

1. **Association**
2. **Aggregation** (Weak *Has-A* Relationship)
3. **Composition** (Strong *Has-A* Relationship)

---


## 1. Association

Association represents a **general relationship** between two classes where one class uses another.
It can be:

* One-to-One
* One-to-Many
* Many-to-One
* Many-to-Many

### Example: Teacher and Student (Many-to-Many Relationship)

```java
class Teacher {
    private String name;
    Teacher(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}

class Student {
    private String name;
    Student(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}

public class AssociationExample {
    public static void main(String[] args) {
        Teacher teacher1 = new Teacher("Mr. Smith");
        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");

        System.out.println(teacher1.getName() + " teaches " + student1.getName() + " and " + student2.getName());
    }
}
```

#### Explanation:

* `Teacher` and `Student` are independent classes.
* They **interact** but can **exist independently**.


---

## 2. Aggregation (Weak "Has-A" Relationship)

Aggregation is a **specialized form of Association** where one class *"has"* another,
but **both can exist independently** — it represents a **whole-part** relationship.

### Example: Department and Professor

```java
class Professor {
    private String name;
    Professor(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Professor{" + "name='" + name + '\'' + '}';
    }
}

class Department {
    private String name;
    private List<Professor> professor;

    public Department(String name, List<Professor> professor) {
        this.name = name;
        this.professor = professor;
    }

    @Override
    public String toString() {
        return "Department{" + "name='" + name + '\'' + ", professor=" + professor + '}';
    }
}

public class AggregationExample {
    public static void main(String[] args) {
        Professor p1 = new Professor("Omar");
        Professor p2 = new Professor("Ahmed");
        List<Professor> professors = new ArrayList<>();
        professors.add(p1);
        professors.add(p2);
        Department d1 = new Department("Computer Science", professors);

        System.out.println(d1);
    }
}
```

#### Explanation:

* `Department` **has** `Professor` objects.
* If `Department` is deleted, `Professor` objects **still exist**.

---

## 3. Composition (Strong "Has-A" Relationship)

Composition is a **stronger form of Aggregation** where the **child object cannot exist** without the parent.
If the parent is destroyed, the child is also destroyed.

### Example: Car and Engine

```java
class Engine {
    private String type;
    Engine(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }
}

class Car {
    private String model;
    private Engine engine; // Composition (Car owns Engine)

    Car(String model, String engineType) {
        this.model = model;
        this.engine = new Engine(engineType); // Engine created inside Car
    }

    public void displayDetails() {
        System.out.println("Car: " + model + ", Engine: " + engine.getType());
    }
}

public class CompositionExample {
    public static void main(String[] args) {
        Car car = new Car("Toyota Camry", "V6");
        car.displayDetails();
    }
}
```

#### Explanation:

* `Car` **owns** an `Engine`.
* If `Car` is destroyed, `Engine` is also **destroyed**.

---

## Summary

| Relationship | Description                                 | Independence  |
| ------------ | ------------------------------------------- | ------------- |
| Association  | General relationship (objects interact)     | ✅ Independent |
| Aggregation  | Weak *has-a* (whole-part)                   | ✅ Independent |
| Composition  | Strong *has-a* (cannot live without parent) | ❌ Dependent   |

---
