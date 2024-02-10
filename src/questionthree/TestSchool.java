package questionthree;

import java.util.ArrayList;
import java.util.List;

public class TestSchool {
    public static void main(String[] args) {
        Teacher teacher1 = new Teacher(1, "John Doe", 2000);
        Teacher teacher2 = new Teacher(2, "Jane Smith", 2500);

        List<Teacher> teachers = new ArrayList<>();
        teachers.add(teacher1);
        teachers.add(teacher2);

        Student student1 = new Student(1, "Alice", 10, 0, 1000);
        Student student2 = new Student(2, "Bob", 11, 0, 1500);

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);

        School school = new School(teachers, students);

        // Pay salary to teachers
        int totalTeacherSalary = teacher1.getSalary() + teacher2.getSalary();
        school.updateTotalMoneySpent(totalTeacherSalary);
        teacher1.receiveSalary(teacher1.getSalary());
        teacher2.receiveSalary(teacher2.getSalary());

        // Pay fees by students
        student1.payFees(500);
        school.updateTotalMoneyEarned(500);
        student2.payFees(1000);
        school.updateTotalMoneyEarned(1000);

        System.out.println("School's financial status:");
        System.out.println("Total money earned: " + school.getTotalMoneyEarned());
        System.out.println("Total money spent: " + school.getTotalMoneySpent());
    }
}

