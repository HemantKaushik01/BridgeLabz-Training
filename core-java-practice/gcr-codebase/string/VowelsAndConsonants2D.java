package string;

import java.util.Scanner;
class VowelsAndConsonants2D {
	static String[][] vowelConsonants(String str) {
		String newStr = "";
		for (int i = 0; i < str.length(); i++) {
			if ((int) (str.charAt(i)) < 97) {
				int ascii = (int) str.charAt(i) + 32;
				char ch = (char) ascii;
				newStr += ch;
			}
			else {
				newStr += str.charAt(i);
			}
		}
		String[][] vowelAndConsonants = new String[newStr.length()][2];
		for (int i = 0; i < newStr.length(); i++) {
			if (newStr.charAt(i) == 'a' || newStr.charAt(i) == 'e' || newStr.charAt(i) == 'i' || newStr.charAt(i) == 'o'
					|| newStr.charAt(i) == 'u') {
				vowelAndConsonants[i][0] = "" + newStr.charAt(i);
				vowelAndConsonants[i][1] = "Vowel";
			}
			else {
				vowelAndConsonants[i][0] = "" + newStr.charAt(i);
				vowelAndConsonants[i][1] = "Consonants";
			}
		}
		return vowelAndConsonants;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter string: ");
		String str = input.nextLine();
		String[][] result = vowelConsonants(str);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i][0] + "           " + result[i][1]);

		}

	}

}