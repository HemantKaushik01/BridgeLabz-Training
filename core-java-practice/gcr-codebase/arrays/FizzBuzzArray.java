package arrays;

import java.util.Scanner;

class FizzBuzzArray {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter The number :");
		int number = input.nextInt();
		String[] array = new String[number + 1];
		if (number > 0) {
			for (int i = 0; i <= number; i++) {
				if (i % 3 == 0) {
					array[i] = "Fizz";
				} else if (i % 5 == 0) {
					array[i] = "Buzz";
				} else if (i % 3 == 0 && i % 5 == 0) {
					array[i] = "FizzBuzz";
				} else {
					array[i] = "" + i;
				}
			}
		}

		for (int i = 0; i < array.length; i++) {
			System.out.print("Position " + (i + 1) + " = " + array[i] + " ,");
		}
	}
}