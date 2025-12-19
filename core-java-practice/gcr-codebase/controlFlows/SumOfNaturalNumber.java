package controlFlows;

import java.util.Scanner;
class SumOfNaturalNumber{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a numbers : ");
		int number = input.nextInt();
		
		if(number>0){
			int sum=number*(number+1)/2;
			System.out.print( "The sum of " + sum +" natural numbers is : " +number);
		}
		else{
			System.out.print( "The number "+number+" is not a natural number");
		}
		
	}
}
