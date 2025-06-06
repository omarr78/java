# Access Level Modifiers in Java

Access level modifiers are fundamental constructs in Java that determine the visibility and accessibility of class members (fields, methods, constructors). They play a crucial role in promoting encapsulation.

## Types of Access Level Modifiers

### Public
- Members declared `public` are visible and accessible from anywhere in your program (project).
- Use this modifier for elements that need to be widely used.

### Private
- Members declared `private` are only visible and accessible within the class where they are defined.
- This promotes encapsulation by restricting direct access to internal data, encouraging the use of public methods to control interactions with the class.

### Protected
- Members declared `protected` are visible and accessible within the class where they are defined, its subclasses in the same package, and subclasses in different packages (but not directly from other classes in different packages).
- This modifier is useful for creating a base class (superclass) with protected members that can be accessed and potentially overridden by its subclasses, promoting code reuse and inheritance.

### Default (Package-Private)
- Members declared without any access modifier are visible and accessible within the same package (the package containing the class definition).

## Data Hiding
- Data hiding is a software development technique specifically used in object-oriented programming (OOP) to hide internal object details (data members).
- Data hiding ensures restricted data access to class members and protects object integrity by preventing unintended or intended changes.

## Encapsulation
- Encapsulation is a mechanism of wrapping the data (variables) and code acting on the data (methods) together as a single unit.
- In encapsulation, the variables of a class will be hidden from other classes and can be accessed only through the methods of their current class.

### How to Achieve Encapsulation in Java
1. Declare the variables of a class as `private`.
2. Provide public `setter` and `getter` methods to modify and view the variables' values.
