package secnario_Based;

import java.util.Arrays;
import java.util.Scanner;

public class TextFormatter {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the Pagragraph ");
		String para = input.nextLine();
		TextFormatter formatter = new TextFormatter();

		para = para.trim();

		if (para.length() == 0) {
			System.out.print("Paragraph is empty ");
		} else {

			formatter.formatter(para);
		}

	}

	public void formatter(String para) {
		Scanner input = new Scanner(System.in);
		String word[] = para.split("\\s+");
		System.out.println("The number of words in this paragraph: " + word.length + "\n");
		String max = "";
		int longestWord = 0;
		for (int i = 0; i < word.length; i++) {
			if (max.length() < word[i].length()) {
				max = word[i];
				longestWord = i;
			}

		}
		System.out.println("LongestWord in this paragraph :" + word[longestWord] + "\n");
		System.out.print("Enter the word to repalce: ");
		String wordToReplace = input.next();
		System.out.print("Enter replacement Word : ");
		String replacementWord = input.next();
		for (int i = 0; i < word.length; i++) {
			word[i] = word[i].replace(wordToReplace, replacementWord);
		}
		String paragraph = String.join(" ", word);
		System.out.println("Paragraph after replace the word: ");
		System.out.println(paragraph);

		return;
	}

}
