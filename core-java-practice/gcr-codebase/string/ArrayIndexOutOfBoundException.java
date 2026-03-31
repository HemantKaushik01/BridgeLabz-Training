package string;

import java.util.Scanner;

public class ArrayIndexOutOfBoundException {

       public static void handleException(String[] names) {
        try {
            System.out.println("\nHandling Exception:");
            System.out.println("Accessing names[" + names.length + "]: " + names[names.length]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of names: ");
        int size = input.nextInt();
        input.nextLine(); 
        String[] names = new String[size];
        System.out.print("Enter names ");

        for (int i = 0; i < size; i++) {
            names[i] = input.nextLine();
        }

        handleException(names);
    }
}
