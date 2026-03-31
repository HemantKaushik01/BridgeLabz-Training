package string;

import java.util.Scanner;

class VowelsAndConsonants {
	static int[] vowelConsonants(String str) {
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
		int vowelCounter = 0;
		int consonantCounter = 0;
		int[] vowelAndConsonantsCount = new int[2];
		for (int i = 0; i < newStr.length(); i++) {
			if (newStr.charAt(i) == 'a' || newStr.charAt(i) == 'e' || newStr.charAt(i) == 'i' || newStr.charAt(i) == 'o'
					|| newStr.charAt(i) == 'u') {
				vowelCounter++;
				System.out.println((i + 1) + "the character of String is vowel ");
			}
			else {
				consonantCounter++;
				System.out.println((i + 1) + "the character of String is consonant ");
			}
		}
		vowelAndConsonantsCount[0] = vowelCounter; 
		vowelAndConsonantsCount[1] = consonantCounter; 
		return vowelAndConsonantsCount;

	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter string: ");
		String str = input.nextLine();
		int[] result = vowelConsonants(str);
		System.out.println("Number of vowels in given string is :" + result[0]);
		System.out.println("Number of consonants in given string is :" + result[1]);
	}

}