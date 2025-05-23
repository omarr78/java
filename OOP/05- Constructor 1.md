## Rules of creating Java Constuctor
- constructor name must be the same as its class name
- constructor must have no explicit return type 
- constructor cannot be (abstract, static, final , synchronized)
- Only one constructor is called when an object is created, depending on the arguments provided.

## Example code
``` java

public class Product {
    public Product(){
        System.out.println("constructor is called");
    }
}

public class Main {
    public static void main(String[] args) {
        Product p = new Product(); // will print "constructor is called"
    }
}
```

## Types of Constructor
- No-Arg Constructor : a constructor that does not accept any arguments.
- Parameterized Constructor : a constructor that accepts arguments.
- Default Constructor : a constructor that is automatically created by Java compiler if it is not explicity defined. 
- the default constructor initializes any uninitialized instance variables with default values:

  | Primitive Type | Default Value |
  |----------------|---------------|
  | boolean        | false         |
  | byte           | 0             |
  | short          | 0             |
  | int            | 0             |
  | long           | 0L            |
  | char           | \u0000        |
  | float          | 0.0f          |
  | double         | 0.0d          |
  | object         | null          |

## Example code
``` java

public class Product {
    private String name;
    private String description;
    private float price;
    private int quantity;
    private float discount;

    public Product(){ // No-Arg Constructor
        this.name = "No Name";
        this.description = "No Description";
        this.price = 0.0f;
        this.quantity = 0;
        this.discount = 0.0f;
    }
    public Product(String name , String description, float price, int quantity, float discount){ //Parameterized Constructor
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
    }
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", discount=" + discount +
                '}';
    }
}


public class Main {
    public static void main(String[] args) {
        Product p1 = new Product();  // No-Arg Constructor
        Product p2 = new Product("camera","Auto focus...",25999,1,5); //Parameterized Constructor
        System.out.println(p1.toString()); // Product{name='No Name', description='No Description', price=0.0, quantity=0, discount=0.0}
        System.out.println(p2.toString()); // Product{name='camera', description='Auto focus...', price=25999.0, quantity=1, discount=5.0}
        
    }
}

```
