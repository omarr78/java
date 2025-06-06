## Example: Employee payroll management system

``` java
class Employee {
    private String name;
    private float salary;

    public float getSalary() {
        return salary;
    }
    // constructor
    public Employee(String name, float salary) {
        this.name = name;
        this.salary = salary;
    }
}

public class SalariedEmployee extends Employee {
    private float bonus;
    
    // constructor
    public SalariedEmployee(String name, float salary, float bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    @Override
    public float getSalary() {
        return super.getSalary() + bonus;
    }
}

public class DailyEmployee extends Employee {
    private float workDayPrice;
    private int dailyRate;

    public DailyEmployee(String name, float salary, float workDayPrice, int dailyRate) {
        super(name, salary);
        this.workDayPrice = workDayPrice;
        this.dailyRate = dailyRate;
    }

    @Override
    public float getSalary() {
        return this.workDayPrice * this.dailyRate;
    }
}

public class HourlyEmployee extends Employee {
    private float workOutPrice;
    private int hourlyRate;

    public HourlyEmployee(String name, float salary, float workOutPrice, int hourlyRate) {
        super(name, salary);
        this.workOutPrice = workOutPrice;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public float getSalary() {
        return this.workOutPrice * this.hourlyRate;
    }
}

public class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee("ahmed",1000);
        SalariedEmployee e2 = new SalariedEmployee("omar",1000,300);
        DailyEmployee e3 = new DailyEmployee("mo salah",0,50,5);
        HourlyEmployee e4 = new HourlyEmployee("hassan",0,70,5);

        System.out.println(e1.getSalary()); // 1000.0
        System.out.println(e2.getSalary()); // 1300.0
        System.out.println(e3.getSalary()); // 250.0
        System.out.println(e4.getSalary()); // 350.0
    }
}

```
## Can Static Methods Be Overridden in Java?
- No, static methods cannot be overridden in Java.
-  Instead, they are hidden if a subclass declares a static method with the same signature.

## Why Static Methods Cannot Be Overridden? Static vs. Instance Methods
- Instance methods are bound at runtime (dynamic polymorphism).
- Static methods are bound at compile-time (static binding).

## Method Hiding (Not Overriding)
- If a subclass defines a static method with the same signature as the parent's static method, it hides the parent method rather than overriding it.
- The method called depends on the reference type, not the actual object type.

## Example: Static Method Hiding vs. Instance Method Overriding

## 1. Static Method (Hiding)

``` java 

class Parent {
    static void show() {
        System.out.println("Parent's static method");
    }
}

class Child extends Parent {
    static void show() {  // Hides Parent's show(), NOT overriding
        System.out.println("Child's static method");
    }
}

public class Main {
    public static void main(String[] args) {
        Parent p = new Child();
        p.show(); // Calls Parent's show() (because reference is Parent)
        
        Child c = new Child();
        c.show(); // Calls Child's show()
    }
}
```
## Output:
``` {text}
Parent's static method  
Child's static method  
```
## Key Point:
- The method called depends on the reference type (Parent or Child).


## 2. Instance Method (Overriding - For Comparison)

``` java
class Parent {
    void display() {
        System.out.println("Parent's instance method");
    }
}

class Child extends Parent {
    @Override
    void display() {  // Properly overrides Parent's display()
        System.out.println("Child's instance method");
    }
}

public class Main {
    public static void main(String[] args) {
        child p = new Child(); 
        p.display(); // Calls Child's display() (runtime polymorphism)
    }
}
```

## Output:
``` {text}
Child's instance method  
```
## Key Point:
- The method called depends on the actual object (Child).


### Polymorphism means `many forms` and allows objects of different classes to be treated as objects of a common superclass.

### 1. Static Polymorphism (Early Binding/Compile-time Polymorphism)
- Resolved at compile time
- Achieved through method overloading
### 2. Dynamic Polymorphism (Late Binding/Runtime Polymorphism)
- Resolved at runtime
- Achieved through method overriding and inheritance
