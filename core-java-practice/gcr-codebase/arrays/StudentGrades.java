package arrays;

import java.util.Scanner;

class StudentsGrades {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter number of students : ");
		int students = input.nextInt();
		int[] physicsMarks = new int[students];
		int[] chemistryMarks = new int[students];
		int[] mathMarks = new int[students];

		double[] percentage = new double[students];
		char[] grades = new char[students];
		for (int i = 0; i < students; i++) {
			System.out.print("Enter marks of " + (i + 1) + "th in Physics(out of 100) : ");
			physicsMarks[i] = input.nextInt();
			if (physicsMarks[i] < 0) {
				System.out.print("Enter the positive value for physics marks : ");
				physicsMarks[i] = input.nextInt();
			}
			System.out.print("Enter marks of " + (i + 1) + "th in Chemistry(out of 100) : ");
			chemistryMarks[i] = input.nextInt();
			if (chemistryMarks[i] < 0) {
				System.out.print("Enter the positive value for chemistry marks : ");
				chemistryMarks[i] = input.nextInt();
			}
			System.out.print("Enter marks of " + (i + 1) + "th in Maths(out of 100) : ");
			mathMarks[i] = input.nextInt();
			if (mathMarks[i] < 0) {
				System.out.print("Enter the positive value for maths marks : ");
				mathMarks[i] = input.nextInt();
			}
			percentage[i] = ((physicsMarks[i] + chemistryMarks[i] + mathMarks[i]) / 300.0) * 100;

			if (percentage[i] >= 80) {
				grades[i] = 'A';
			} else if (percentage[i] >= 70 && percentage[i] <= 79) {
				grades[i] = 'B';
			} else if (percentage[i] >= 60 && percentage[i] <= 69) {
				grades[i] = 'C';
			} else if (percentage[i] >= 50 && percentage[i] <= 59) {
				grades[i] = 'D';
			} else if (percentage[i] >= 40 && percentage[i] <= 49) {
				grades[i] = 'E';
			} else {
				grades[i] = 'R';
			}
		}

		for (int i = 0; i < students; i++) {

			System.out.println((i + 1) + "th Students have physics marks " + physicsMarks[i] + ", chemistry marks "
					+ chemistryMarks[i] + ", math marks " + mathMarks[i] + " percentage is " + percentage[i]
					+ "and grade is " + grades[i]);

		}

	}
}