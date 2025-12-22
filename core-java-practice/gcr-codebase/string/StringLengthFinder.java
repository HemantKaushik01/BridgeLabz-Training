package string;

import java.util.Scanner;

public class StringLengthFinder {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.next();
        int custom = findLength(input);
        int builtIn = input.length();
        System.out.println("Length using custom method: " + custom);
        System.out.println("Length using built-in length() method: " + builtIn);
    }

    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            return count;
        }
    }
}