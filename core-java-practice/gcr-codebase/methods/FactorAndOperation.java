package methods;

import java.util.Scanner;

class FactorsAndOperation {

	public static int[] factors(int number) {
		int size = 0;
		for (int i = 1; i < number; i++) {
			if (number % i == 0) {
				size++;
			}
		}
		int[] array = new int[size];
		int idx = 0;
		for (int i = 1; i < number; i++) {
			if (number % i == 0) {
				array[idx] = i;
				idx++;
			}
		}
		return array;
	}

	public static int sumOfFactors(int[] array) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		return sum;
	}

	public static int productOfFactors(int[] array) {
		int product = 1;
		for (int i = 0; i < array.length; i++) {
			product *= array[i];
		}
		return product;
	}

	public static int sumOfSquaresOfFactor(int[] array) {
		int sumOfSquare = 0;
		for (int i = 0; i < array.length; i++) {
			sumOfSquare += Math.pow(array[i], 2);
		}
		return sumOfSquare;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number :");
		int number = input.nextInt();
		int[] factorArray = factors(number);
		int sumOfFactor = sumOfFactors(factorArray);
		int productOfFactor = productOfFactors(factorArray);
		int sumOfSquareFactor = sumOfSquaresOfFactor(factorArray);
		System.out.println("Factors of number are :");
		for (int i = 0; i < factorArray.length; i++) {
			System.out.print(factorArray[i] + " ");
		}

		System.out.println("\nSum of factors is " + sumOfFactor);
		System.out.println("Product of factors is " + productOfFactor);
		System.out.println("Sum of sqaures of factors is " + sumOfSquareFactor);

	}
}