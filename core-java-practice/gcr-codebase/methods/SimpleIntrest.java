package methods;

import java.util.Scanner;

public class SimpleIntrest {
	private static double simpleIntrest(int principal, float rate, float time) {
		double simpleIntrest = (principal * rate * time) / 100.0;
		return simpleIntrest;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Principal: ");
		int principal = input.nextInt();
		System.out.print("Rate: ");
		float rate = input.nextFloat();
		System.out.print("Time in years: ");
		float time = input.nextFloat();

		double SI = simpleIntrest(principal, rate, time);
		System.out.println("The Simple Interest is " + SI + " for Principal " + principal + " , Rate of Interest "
				+ rate + " and Time " + time);
	}
}