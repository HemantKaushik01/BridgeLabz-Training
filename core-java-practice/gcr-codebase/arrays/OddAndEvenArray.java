package arrays;

import java.util.Scanner;

class OddAndEvenArray {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter Number :");
		int number = input.nextInt();
		if (number < 1) {
			System.err.println("Invalid Number");
			System.exit(0);
		}
		int[] odd = new int[number / 2 + 1];
		int[] even = new int[number / 2 + 1];
		int oddidx = 0;
		int evenidx = 0;
		for (int i = 1; i <= number; i++) {
			if (i % 2 == 0) {
				even[evenidx] = i;
				evenidx++;
			} else {
				odd[oddidx] = i;
				oddidx++;
			}
		}

		System.out.println("Odd number Array");
		for (int i = 0; i < oddidx; i++) {
			System.out.print(odd[i] + " ");
		}

		System.out.println("\nEven number Array");
		for (int i = 0; i < evenidx; i++) {
			System.out.print(even[i] + " ");

		}

	}
}