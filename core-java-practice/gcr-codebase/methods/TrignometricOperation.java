package methods;

import java.util.Scanner;

public class TrignometricOperation {

	public double[] calculateTrigonometricFunctions(double angle) {

		double radian = angle * 0.0174533;

		double[] trignomtricOperation = new double[3];

		trignomtricOperation[0] = Math.sin(radian);// for Sine

		trignomtricOperation[1] = Math.cos(radian);// for cosine

		trignomtricOperation[2] = Math.tan(radian);// for tangent

		return trignomtricOperation;

	}

	public static void main(String[] args) {

		TrignometricOperation obj = new TrignometricOperation();

		Scanner input = new Scanner(System.in);

		System.out.print("Enter the angle(in degree) : ");

		double angle = input.nextDouble();

		double[] result = obj.calculateTrigonometricFunctions(angle);

		System.out.println("Sine of angle : " + angle + " is " + result[0]);

		System.out.println("Cosine of angle : " + angle + " is " + result[1]);

		System.out.println("Tangent of angle : " + angle + " is " + result[2]);

	}

}