package methods;

import java.util.Scanner;

public class Rounds {
	private static double roundToComplete(float distanceInKm, int perimeterInM) {
		double round = (distanceInKm * 1000) / perimeterInM;
		return round;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Side 1 of Triangular Park: ");
		int side1InM = input.nextInt();
		System.out.print("Side 2 of Triangular Park: ");
		int side2InM = input.nextInt();
		System.out.print("Side 3 of Triangular Park: ");
		int side3InM = input.nextInt();
		int perimeter = side1InM + side2InM + side3InM;
		float distanceInKm = 5;
		double result = roundToComplete(distanceInKm, perimeter);
		System.out.println("The total number of rounds the athlete will run is " + result + " to complete 5 km");

	}

}