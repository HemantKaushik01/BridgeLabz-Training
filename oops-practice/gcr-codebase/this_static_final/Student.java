import java.util.Scanner;

public class Student {
    String name;
    final int rollNumber;
    String grade;
    static String universityName = "GLA University";
    static int totalStudents = 0;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++;
    }

    public static void displayTotalStudents() {
        System.out.println("Total students enrolled: " + totalStudents);
    }

    public void displayStudentDetails() {
        if (this instanceof Student) {
            System.out.println("University: " + universityName);
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Name: " + name);
            System.out.println("Grade: " + grade);
        } else {
            System.out.println("Invalid Student object.");
        }
    }

    public void updateGrade(String newGrade) {
        if (this instanceof Student) {
            this.grade = newGrade;
            System.out.println("Grade updated for Roll Number " + rollNumber);
        } else {
            System.out.println("Grade update failed: not a valid Student.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Student " + (i + 1));
            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Roll Number: ");
            int roll = sc.nextInt();
            sc.nextLine();

            System.out.print("Grade: ");
            String grade = sc.nextLine();

            students[i] = new Student(name, roll, grade);
        }

        System.out.println(" Student Records ");
        for (Student s : students) {
            s.displayStudentDetails();
            System.out.println("");
        }

        System.out.print("\nDo you want to update any grades? (yes/no): ");
        String choice = sc.nextLine();
        if (choice.equalsIgnoreCase("yes")) {
            System.out.print("Enter roll number to update: ");
            int rollUpdate = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter new grade: ");
            String newGrade = sc.nextLine();

            boolean found = false;
            for (Student s : students) {
                if (s.rollNumber == rollUpdate) {
                    s.updateGrade(newGrade);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("No student found with roll number " + rollUpdate);
            }
        }

        System.out.println();
        displayTotalStudents();
     
    }
}
