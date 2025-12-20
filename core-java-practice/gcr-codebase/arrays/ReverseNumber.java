package arrays;

import java.util.Scanner;

class ReverseNumber {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number for reverse :");
		int number = input.nextInt();
		int count = 0;
		int temporary = number;
		while (temporary > 0) {
			int reminder = temporary % 10;
			count++;
			temporary /= 10;
		}
		temporary = number;
		int[] array = new int[count];
		int idx = 0;
		while (temporary > 0) {
			int reminder = temporary % 10;
			array[idx] = reminder;
			idx++;
			temporary /= 10;
		}
		System.out.print("The reverse number is: ");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
		}

	}
}