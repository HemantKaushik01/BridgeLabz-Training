package methods;

import java.util.Scanner;

public class SmallestAndLargest {
	public static int[] findSmallestAndLargest(int number1, int number2, int number3) {
		int[] smallestAndLargest = new int[2];
		int smallest = Math.min(number1, number2);
		smallest = Math.min(smallest, number3);
		int largest = Math.max(number1, number2);
		largest = Math.max(largest, number3);
		smallestAndLargest[0] = smallest;
		smallestAndLargest[1] = largest;
		return smallestAndLargest;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter three numbers : ");
		int number1 = input.nextInt();
		int number2 = input.nextInt();
		int number3 = input.nextInt();
		int[] result = findSmallestAndLargest(number1, number2, number3);
		System.out.println("Smallest number among these 3 numbers is " + result[0]);
		System.out.println("Largest number among these 3 numbers is " + result[1]);

	}

}