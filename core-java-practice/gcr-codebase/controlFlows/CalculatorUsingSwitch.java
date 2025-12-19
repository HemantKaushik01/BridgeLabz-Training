package controlFlows;

import java.util.Scanner;
public class CalculatorUsingSwitch{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the First number : ");
		int first = input.nextInt();
		System.out.print("Enter the Second number : ");
		int second = input.nextInt();
		input.nextLine();
		System.out.print("Enter the operation to be performed(+,-,*,/) : ");
		String op = input.nextLine();

		switch (op){
		case "+" :
			System.out.println("Addition of " + first + " and " + second + " is " + (first+second));
			break;

		case "-" :
			System.out.println("Subtraction of " + first + " and " + second + " is " + (first-second));
			break;
			
		case "*" :
			System.out.println("Multiplication of " + first + " and " + second + " is " + (first*second));
			break;

		case "/" :
			System.out.println("division of " + first + " and " + second + " is " + (first/second));
			break;

		default :
			System.out.print("Invalid Operator");
		}

	}
}