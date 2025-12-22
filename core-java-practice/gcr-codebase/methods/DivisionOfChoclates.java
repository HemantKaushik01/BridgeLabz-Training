package methods;

import java.util.Scanner;

public class DivisionOfChoclates {
	public static int[] findRemainderAndQuotient(int number, int divisor) {
		int[] remainderAndQuotient = new int[2];
		remainderAndQuotient[0] = number / divisor;
		remainderAndQuotient[1] = number % divisor;
		return remainderAndQuotient;
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.print("Number of choclates : ");
		int numberOfChoclates = input.nextInt();
		System.out.print("Number of children : ");
		int numberOfChildren = input.nextInt();
		int[] result = findRemainderAndQuotient(numberOfChoclates, numberOfChildren);
		System.out.println("The number of chocolates each child gets is " + result[0]
				+ " and the number of remaining chocolates is " + result[1]);

	}
}