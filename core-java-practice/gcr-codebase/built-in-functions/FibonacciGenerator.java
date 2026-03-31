import java.util.Scanner;

class FibonacciGenerator {

	static Scanner input = new Scanner(System.in);

	static int inputNumber() {
		System.out.print("Enter number of term :");
		int n = input.nextInt();
		return n;
	}

	static void fibonacci(int n, int first, int second) {
		if (n == 1) {
			System.out.print(first);
		} else if (n == 2) {
			System.out.print(first + " " + second);
		} else {
			for (int i = 1; i <= n; i++) {
				System.out.print(first + " ");
				int temp = first;
				first = second;
				second = temp + second;
			}
		}
	}

	public static void main(String[] args) {
		int n = inputNumber();
		fibonacci(n, 0, 1);
	}

}