``` java
class Employee {
    protected String name;
    protected String emailAddress;
    protected String phoneNumber;
    protected String department;
    protected String address;
    protected int yearOfBirth;
    protected float salary;

    Employee(){
        System.out.println("Employee Constructor , created by omar");
    }


    public Employee(String name,String emailAddress,String phoneNumber,String department,String address,int yearOfBirth,float salary) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.department = department;
        this.address = address;
        this.yearOfBirth = yearOfBirth;
        this.salary = salary;
        System.out.println("Employee Parametrized Constructor");
    }
}
```
``` java
public class Developer extends Employee {
    private String projectName;

    Developer() {}
    
    Developer(String name,String emailAddress,String phoneNumber,String department,String address,int yearOfBirth,float salary,String ProjectName) {
        super(name,emailAddress,phoneNumber,department,address,yearOfBirth,salary);
        this.projectName = ProjectName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

     @Override
    public String toString() {
        return "Developer{" +
                "projectName='" + projectName + '\'' +
                ", name='" + name + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", department='" + department + '\'' +
                ", address='" + address + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", salary=" + salary +
                '}';
    }
}

```
``` java
public class Main {
    public static void main(String[] args) {
        Developer dev = new Developer("Ahmed","Ahmed@gmail.com","01059464846","IT","cairo",2001,3000,"OOP");
        System.out.println(dev.toString()); 

    }
}
```
## output
```{text}
Employee Parametrized Constructor
Developer{projectName='OOP', name='Ahmed', emailAddress='Ahmed@gmail.com', phoneNumber='01059464846', department='IT', address='cairo', yearOfBirth=2001, salary=3000.0}
```


