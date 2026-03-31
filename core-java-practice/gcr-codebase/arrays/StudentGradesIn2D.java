package arrays;

import java.util.Scanner;
class StudentsGradesIn2D {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter number of students : ");
		int students = input.nextInt();
		int[][] totalMarks = new int[students][3];
		double[] percentage = new double[students];
		char[] grades = new char[students];
		for (int i = 0; i < students; i++) {
			System.out.print("Enter marks of " + (i + 1) + "th in Physics(out of 100) : ");

			int physics = input.nextInt();
			if (physics < 0) {
				System.out.print("Enter the positive value for physics marks : ");
				physics = input.nextInt();

			}

			System.out.print("Enter marks of " + (i + 1) + "th in Chemistry(out of 100) : ");
			int chemistry = input.nextInt();
			if (chemistry < 0) {
				System.out.print("Enter the positive value for chemistry marks : ");
				chemistry = input.nextInt();

			}

			System.out.print("Enter marks of " + (i + 1) + "th in Maths(out of 100) : ");

			int math = input.nextInt();
			if (math < 0) {
				System.out.print("Enter the positive value for maths marks : ");
				math = input.nextInt();
			}
			totalMarks[i][0] = physics;
			totalMarks[i][1] = chemistry;
			totalMarks[i][2] = math;
			percentage[i] = ((physics + chemistry + math) / 300.0) * 100;
			if (percentage[i] >= 80) {
				grades[i] = 'A';
			}
			else if (percentage[i] >= 70 && percentage[i] <= 79) {
				grades[i] = 'B';
			}
			else if (percentage[i] >= 60 && percentage[i] <= 69) {
				grades[i] = 'C';
			}
			else if (percentage[i] >= 50 && percentage[i] <= 59) {
				grades[i] = 'D';
			}
			else if (percentage[i] >= 40 && percentage[i] <= 49) {
				grades[i] = 'E';
			}
			else {
				grades[i] = 'R';
			}
		}
		for (int i = 0; i < students; i++) {

			System.out.println((i + 1) + "th Students have physics marks " + totalMarks[i][0] + ", chemistry marks "
					+ totalMarks[i][1] + ", math marks " + totalMarks[i][2] + " and percentage is " + percentage[i]
					+ "and grade is " + grades[i]);

		}
	}
}