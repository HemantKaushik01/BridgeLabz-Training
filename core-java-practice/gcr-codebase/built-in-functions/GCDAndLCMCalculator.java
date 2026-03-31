import java.util.Scanner;

class GCDAndLCMCalculator {

	static Scanner input = new Scanner(System.in);

	static int inputNumber() {
		int number = input.nextInt();
		return number;
	}

	static int LCM(int number1, int number2) {
		int lcm = Math.max(number1, number2);
		while (true) {
			if (lcm % number1 == 0 && lcm % number2 == 0) {
				break;
			}
			lcm++;
		}
		return lcm;
	}

	static int GCD(int number1, int number2) {
		int gcd = Math.min(number1, number2);
		while (gcd > 0) {
			if (number1 % gcd == 0 && number2 % gcd == 0) {
				break;
			}
			gcd--;
		}
		return gcd;
	}

	public static void main(String[] args) {
		System.out.print("Enter Two Numbers : ");
		int number1 = inputNumber();
		int number2 = inputNumber();
		int lcmResult = LCM(number1, number2);
		int gcdResult = GCD(number1, number2);
		System.out.println("LCM of " + number1 + " and " + number2 + " is " + lcmResult);
		System.out.println("GCD of " + number1 + " and " + number2 + " is " + gcdResult);
	}

}