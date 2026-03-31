package arrays;

import java.util.Scanner;

class BmiCalculator2D {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		double[][] personData = new double[number][3];
		String[] weightStatus = new String[number];

		for (int i = 0; i < number; i++) {

			System.out.print("Enter your weight(in kg) : ");
			double weight = input.nextDouble();
			if (weight < 0) {
				System.out.println("data is negative , please re-enter");
				weight = input.nextDouble();
			}

			System.out.print("Enter your height(in cm) : ");
			double height = input.nextDouble();
			if (height < 0) {
				System.out.println("data is negative , please re-enter");
				height = input.nextDouble();
			}

			height /= 100;
			double bmi = weight / (height * height);
			personData[i][0] = weight;
			personData[i][1] = height;
			personData[i][2] = bmi;
			if (bmi <= 18.4) {
				weightStatus[i] = "Underweight";
			} else if (bmi >= 18.5 && bmi <= 24.9) {

				weightStatus[i] = "Normal";

			} else if (bmi >= 25 && bmi <= 39.9) {

				weightStatus[i] = "Overweight";

			} else {

				weightStatus[i] = "Obese";

			}
		}
		for (int i = 0; i < number; i++) {
			System.out.println(
					"weight : " + personData[i][0] + " height : " + personData[i][1] + " BMI : " + personData[i][2]);
			System.out.println("WeightStatus of a person : " + weightStatus[i]);
		}

	}
}