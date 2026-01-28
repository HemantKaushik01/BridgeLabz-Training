import java.util.Scanner;
public class LexicalTwist {

    public static void main(String[] args) {

        LexicalTwist obj = new LexicalTwist();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the first word");
        String word1 = sc.nextLine();

        System.out.println("Enter the second word");
        String word2 = sc.nextLine();

        if (word1.contains(" ")) {
            System.out.println(word1 + " is an invalid word");
            return;
        }

        if (word2.contains(" ")) {
            System.out.println(word2 + " is an invalid word");
            return;
        }

        boolean check = obj.checkReverse(word1, word2);
        String newStr = "";

        if (check) {
            
            for (int i = word1.length() - 1; i >= 0; i--) {
                char ch = Character.toLowerCase(word1.charAt(i));
                if ("aeiou".indexOf(ch) != -1) {
                    newStr += "@";
                } else {
                    newStr += ch;
                }
            }
            System.out.println(newStr);

        } else {

            newStr = (word1 + word2).toUpperCase();

            int vowels = 0, consonants = 0;
            String vowelStr = "";
            String consonantStr = "";

            for (int i = 0; i < newStr.length(); i++) {
                char ch = newStr.charAt(i);
                if ("AEIOU".indexOf(ch) != -1) {
                    vowels++;
                    if (!vowelStr.contains(String.valueOf(ch)) && vowelStr.length() < 2) {
                        vowelStr += ch;
                    }
                } else {
                    consonants++;
                    if (!consonantStr.contains(String.valueOf(ch)) && consonantStr.length() < 2) {
                        consonantStr += ch;
                    }
                }
            }

            if (vowels > consonants) {
                System.out.println(vowelStr);
            } else if (consonants > vowels) {
                System.out.println(consonantStr);
            } else {
                System.out.println("Vowels and consonants are equal");
            }
        }

    }

    public boolean checkReverse(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;

        word1 = word1.toLowerCase();
        word2 = word2.toLowerCase();

        int n = word2.length();
        for (int i = 0; i < n; i++) {
            if (word1.charAt(i) != word2.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
