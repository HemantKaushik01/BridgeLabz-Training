package string;

import java.util.Scanner;

class CheckUpperCase {

	static String upperCaseUsingCharAt(String str) {
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			if ((int) (str.charAt(i)) > 96) {
				int ascii = (int) str.charAt(i) - 32;
				char ch = (char) ascii;
				result += ch;
			} else {
				result += str.charAt(i);
			}
		}
		return result;
	}

	static boolean compareStrings(String str1, String str2) {

		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				return false;
			}
		}
		return true;

	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter String:");
		String str = input.nextLine();
		String newStr = upperCaseUsingCharAt(str);
		str = str.toUpperCase();

		if (compareStrings(str, newStr)) {
			System.out.println("Both method return same or identical String that is :" + newStr);
		} else {
			System.out.println("Invalid");
		}

	}
}