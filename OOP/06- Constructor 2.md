## Constructor Chaining
- when a constructor calls another constructor of the same class then this is called constructor chaining

## Example code
```java
    public Product(String name , String description, float price, int quantity, float discount){
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
        System.out.println("constructor 2");
    }
    public Product(String name , String description, float price, int quantity, float discount, String color){
        this(name, description, price, quantity, discount); // chaining constructor
        this.color = color;
        System.out.println("constructor 1");
    }
    public class Main {
      public static void main(String[] args) {
        Product p1 = new Product("camera","Auto focus...",25999,1,5,"red");
    }
```
## output
```{text}
constructor 2
constructor 1
```

## Copy constructor 
- A Copy constructor in java class is a constructor that creates an object using another object of the same java class

## Example code
``` java
    public Product(String name , String description, float price, int quantity, float discount){
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
        System.out.println("constructor 2");
    }
    public Product(String name , String description, float price, int quantity, float discount, String color){
        this(name, description, price, quantity, discount);
        this.color = color;
        System.out.println("constructor 1");
    }
    public Product(Product obj){  // copy constructor
        this(obj.name, obj.description, obj.price, obj.quantity, obj.discount, obj.color);
    }
    public static void main(String[] args) {
        Product p1 = new Product("camera","Auto focus...",25999,1,5,"red");
        Product p2 = new Product(p1);
        System.out.println(p2.toString()); // Product{name='camera', description='Auto focus...', price=25999.0, quantity=1, discount=5.0, color='red'}
    }
```
> **Note**
>
> If you need to write any constructor, then you must write a no-argument constructor like:  `Product()`  If you do not do that, `Product p1 = new Product();` will give you an error.

### Finalizers

In Java, when we create an object of the class, it occupies some space in the memory (heap).  
If we do not delete these objects, they remain in the memory and occupy unnecessary space, which is not ideal from a programming perspective.

Java provides a **garbage collector** that works similarly to a destructor.  

Key points about garbage collection:
- The garbage collector is a program (thread) that runs on the JVM.
- It automatically deletes unused objects (objects that are no longer referenced) and frees up memory.
- The programmer does not need to manage memory manually.
- Manual memory management can be error-prone, vulnerable, and may lead to memory leaks.

**Destructor** → In Java, this is known as a **finalizer** (though generally discouraged in modern Java).
