package arrays;

import java.util.Scanner;

class BmiAndWeightStatus {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter number of person : ");
		int persons = input.nextInt();
		double[] weight = new double[persons];
		double[] height = new double[persons];
		double[] bmi = new double[persons];
		String[] weightStatus = new String[persons];

		for (int i = 0; i < persons; i++) {
			System.out.print("Enter your weight(in kg) : ");
			weight[i] = input.nextDouble();
			System.out.print("Enter your height(in cm) : ");
			height[i] = input.nextDouble();
		}

		for (int i = 0; i < persons; i++) {
			height[i] /= 100;
			double calculation = weight[i] / (height[i] * height[i]);
			bmi[i] = calculation;

			if (bmi[i] <= 18.4) {
				weightStatus[i] = "Underweight";
			} else if (bmi[i] >= 18.5 && bmi[i] <= 24.9) {
				weightStatus[i] = "Normal";
			} else if (bmi[i] >= 25 && bmi[i] <= 39.9) {
				weightStatus[i] = "Overweight";
			} else {
				weightStatus[i] = "Obese";
			}
		}

		for (int i = 0; i < persons; i++) {
			System.out.println("According to given height = " + height[i] + " weight = " + weight[i] + " BMI will be : "
					+ bmi[i] + " and weight status is " + weightStatus[i]);
		}

	}
}