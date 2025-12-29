
import java.util.Scanner;
public class Employee {
    String name;
    String designation;
    final int id; 

    static String companyName = "India Pvt Ltd";
    static int totalEmployees = 0;

    public Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++;
    }

 
    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    public void displayDetails() {
        if (this instanceof Employee) {
            System.out.println("Company Name: " + companyName);
            System.out.println("Employee ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Designation: " + designation);
        } else {
            System.out.println("Invalid Employee object.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        sc.nextLine();

        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Employee  "+(i+1) );

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("ID: ");
            int id = sc.nextInt();
            sc.nextLine(); 

            System.out.print("Designation: ");
            String designation = sc.nextLine();

            employees[i] = new Employee(name, id, designation);
        }

        System.out.println("\nThe company name is :  " + companyName );

        for (Employee e : employees) {
            System.out.println("\nEmployee Details :=>  ");
            e.displayDetails();
        }

        System.out.println("");
        displayTotalEmployees();

    }
}
