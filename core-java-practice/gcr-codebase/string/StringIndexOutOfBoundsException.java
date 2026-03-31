package string;

import java.util.Scanner;
public class StringIndexOutOfBoundsException{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.next();
        handleException(input);

    }

    public static void generateException(String text) {
        System.out.println("Character at invalid index: " + text.charAt(text.length()));
    }
    public static void handleException(String text) {
        try {
            System.out.println("Character at invalid index: " + text.charAt(text.length()));
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            System.out.println("Caught String Index Out Of Bounds Exception: " + e.getMessage());
        }
    }
}