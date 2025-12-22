package methods;

import java.util.Scanner;

public class BMICalculator {

	static double bmiCalculation(double weight, double height) {
		height = height / 100.0;
		double bmi = weight / (height * height);
		return bmi;
	}

	static String[] bmiStatus(double teamMembersData[][]) {
		String[] statusBMI = new String[10];
		for (int i = 0; i < 10; i++) {
			if (teamMembersData[i][2] <= 18.4) {
				statusBMI[i] = "Underweight";
			} else if (teamMembersData[i][2] >= 18.5 && teamMembersData[i][2] <= 24.9) {
				statusBMI[i] = "Normal";
			} else if (teamMembersData[i][2] >= 25.0 && teamMembersData[i][2] <= 39.9) {
				statusBMI[i] = "Overweight";
			} else {
				statusBMI[i] = "Obese";
			}
		}
		return statusBMI;
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		double[][] teamMembersData = new double[10][3];

		for (int i = 0; i < 10; i++) {
			System.out.print("Enter the weight of " + (i + 1) + "th member (in kg):");
			teamMembersData[i][0] = input.nextDouble();
			System.out.print("Enter the height of " + (i + 1) + "th member (in cm):");
			teamMembersData[i][1] = input.nextDouble();

			teamMembersData[i][2] = bmiCalculation(teamMembersData[i][0], teamMembersData[i][1]);

		}
		String[] resultStatus = bmiStatus(teamMembersData);
		for (int i = 0; i < resultStatus.length; i++) {
			System.out.println("BMI status of " + (i + 1) + "Th person is " + resultStatus[i]);
		}

	}
}