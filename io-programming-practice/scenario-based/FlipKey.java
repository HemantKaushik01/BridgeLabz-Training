import java.util.Scanner;

public class FlipKey {

    public static String CleanseAndInvert(String str) {
        if (str == null || str.length() < 6) {
            return "";
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z'))) {
                return "";
            }
        }

        str = str.toLowerCase();
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if ((int) ch % 2 != 0) {
                result = result + ch;
            }
        }

        String reversed = "";
        for (int i = result.length() - 1; i >= 0; i--) {
            reversed = reversed + result.charAt(i);
        }


        String finalResult = "";
        for (int i = 0; i < reversed.length(); i++) {
            char ch = reversed.charAt(i);
            if (i % 2 == 0) {
                finalResult = finalResult + Character.toUpperCase(ch);
            } else {
                finalResult = finalResult + ch;
            }
        }

        return finalResult;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the word: ");
        String str = sc.nextLine();

        String output = CleanseAndInvert(str);

        if (output.equals("")) {
            System.out.println("Invalid Input");
        } else {
            System.out.println("The generated key is :" + output);
        }

    }
}
