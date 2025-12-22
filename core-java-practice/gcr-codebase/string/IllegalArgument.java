package string;

import java.util.Scanner;
public class IllegalArgument {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.next();
        handleException(input);
      
    }

    public static void generateException(String text) {
        String result = text.substring(5, 2);  
        System.out.println("Generated substring: " + result);
    }

    public static void handleException(String text) {
        try {
            String result = text.substring(5, 2);  
            System.out.println("Generated substring: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught Illegal Argument Exception: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught Runtime Exception: " + e.getMessage());
        }
    }
}