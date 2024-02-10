package questiontwo;

import java.util.Scanner;

public class TestEmployee {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for employee information
        System.out.print("Enter employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter employee first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter employee last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter employee salary: ");
        int salary = scanner.nextInt();

        // Create employee object
        Employee employee = new Employee(id, firstName, lastName, salary);

        // Test methods
        System.out.println("Employee information:");
        System.out.println("ID: " + employee.getId());
        System.out.println("First Name: " + employee.getFirstName());
        System.out.println("Last Name: " + employee.getLastName());
        System.out.println("Full Name: " + employee.getName());
        System.out.println("Salary: " + employee.getSalary());
        System.out.println("Annual Salary: " + employee.getAnnualSalary());

        System.out.println("Raise salary by 10%: New Salary: " + employee.raiseSalary(10));

        System.out.println("Updated Employee information:");
        System.out.println(employee);
    }
}
