package controlFlows;

import java.util.Scanner;
public class BmiCalculator{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter your weight(in kg) : ");
		double weight = input.nextDouble();
		System.out.print("Enter your height(in cm) : ");
		double height = input.nextDouble();
		height /= 100;
		double bmi = weight / (height*height);
		if(bmi <= 18.4){
			System.out.println("According to given data your BMI is " + bmi + " and you are underweight ");
		}
		else if(bmi >= 18.5 && bmi <=24.9){
			System.out.println("According to given data your BMI is " + bmi + " and you are Normal ");
		}
		else if(bmi >= 25 && bmi <= 39.9){
			System.out.println("According to given data your BMI is " + bmi + " and you are Overweight ");
		}
		else{
			System.out.println("According to given data your BMI is " + bmi + " and you are Obese ");
		}
	}
}