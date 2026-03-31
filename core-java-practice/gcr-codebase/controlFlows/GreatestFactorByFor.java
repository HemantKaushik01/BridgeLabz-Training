package controlFlows;

import java.util.Scanner;
class GreatestFactorByFor{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a number for greatest factor: ");
		int number = input.nextInt();
		
		int counter =number-1;
		for(int i= counter;i>=1;i--){
			if(number%i==0){
				counter=i;
				 break;
			}
		}
		
		System.out.println("The greatestFactor of number: " +number+ " is " +counter);			
			
	}
}
