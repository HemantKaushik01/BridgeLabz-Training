package string;

import java.util.Scanner;

class CheckLowerCase {

	static String lowerCaseUsingCharAt(String str) {
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			if ((int) (str.charAt(i)) < 97) {
				int ascii = (int) str.charAt(i) + 32;
				char ch = (char) ascii;
				result += ch;
			} else {
				result += str.charAt(i);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter String:");
		String str = input.nextLine();
		String newStr = lowerCaseUsingCharAt(str);
		str = str.toLowerCase();

		if (str.equals(newStr)) {
			System.out.println("Both method return same or identical String that is :" + newStr);
		} else {
			System.out.println("Invalid");
		}

	}
}