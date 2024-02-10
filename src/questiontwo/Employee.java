package questiontwo;
import java.util.Scanner;
class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private int salary;

    // Constructor
    public Employee(int id, String firstName, String lastName, int salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    // Getter methods
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public int getSalary() {
        return salary;
    }

    // Setter method
    public void setSalary(int salary) {
        this.salary = salary;
    }

    // Other methods
    public int getAnnualSalary() {
        return salary * 12;
    }

    public int raiseSalary(int percent) {
        double raiseAmount = salary * percent / 100.0;
        salary += raiseAmount;
        return salary;
    }

    @Override
    public String toString() {
        return "Employee[id=" + id + ", name=" + getName() + ", salary=" + salary + "]";
    }
}


