package questionfive;

import java.util.Scanner;

public class TestDoctor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter doctor details:");

        System.out.print("Doctor ID: ");
        int doctorId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Doctor Name: ");
        String doctorName = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();

        // Create a Doctor object
        Doctor doctor = new Doctor(doctorId, doctorName, email, phoneNumber);

        // Display doctor details
        System.out.println("\nDoctor details:");
        doctor.display();

        scanner.close();
    }
}

