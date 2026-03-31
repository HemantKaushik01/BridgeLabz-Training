package controlFlows;

import java.util.Scanner;
class GreatestFactorByWhile{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a number for greatest factor: ");
		int number = input.nextInt();
		int counter =number-1;
		while(number%counter !=0){
			counter--;
			}
		System.out.println("The greatestFactor of number: " +number+ " is " +counter);			
			
	}
}
