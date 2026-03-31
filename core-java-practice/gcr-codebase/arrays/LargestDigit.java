package arrays;

import java.util.Scanner;
import java.util.*;

class LargestDigit {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the 10 numbers  :");
		int number = input.nextInt();
		int maxDigit = 10;
		int[] array = new int[maxDigit];
		int temporary = number;
		int idx = 0;
		while (temporary > 0) {
			int reminder = temporary % 10;
			array[idx] = reminder;
			idx++;
			temporary = temporary / 10;
		}

		int largest = 0;
		int secondLargest = -1;
		for (int i = 0; i < array.length - 1; i++) {
			if (largest < array[i]) {
				secondLargest = largest;
				largest = array[i];
				
			}
		}

		System.out.println("The largest element of array is " + largest);
		System.out.println("The second largest element of array is " + secondLargest);
	}
}