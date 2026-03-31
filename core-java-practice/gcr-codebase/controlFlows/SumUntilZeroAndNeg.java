package controlFlows;

import java.util.Scanner;
class SumUntilZeroAndNeg{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a numbers by the user : ");
		double total =0.0;
		double userInput= input.nextDouble();
		while(userInput>0){
			total+=userInput;
			userInput=input.nextDouble();
		}
		
		System.out.print("Sum of values enter by user until zero : "+ total);
	}
}
