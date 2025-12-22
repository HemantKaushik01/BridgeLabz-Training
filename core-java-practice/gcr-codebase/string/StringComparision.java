package string;

import java.util.*;

public class StringComparision {

    public static boolean compareUsingCharAt(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first string: ");
        String string1 = input.next();

        System.out.print("Enter the second string: ");
        String string2 = input.next();

        boolean resultCharAt = compareUsingCharAt(string1, string2);

        boolean resultEquals = string1.equals(string2);

        System.out.println("Comparison using charAt(): " + resultCharAt);
        System.out.println("Comparison using equals(): " + resultEquals);

        if (resultCharAt == resultEquals) {
            System.out.println("Both methods produced the same result.");
        } else {
            System.out.println("The results of the two methods differ.");
        }

        
    }
}