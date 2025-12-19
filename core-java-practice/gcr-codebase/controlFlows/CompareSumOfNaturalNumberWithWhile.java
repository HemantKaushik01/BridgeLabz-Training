package controlFlows;

import java.util.Scanner;
class CompareSumOfNaturalNumberWithWhile{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a numbers : ");
		int number = input.nextInt();
		int number1=number;
		
		if(number>0){
			int sumByFormula=number*(number+1)/2;
			int sumByWhileLoop=0;
			while(number>0){
				sumByWhileLoop+=number;
				number--;
			}
			if(sumByFormula == sumByWhileLoop)
			System.out.print( "The sum of " + sumByWhileLoop +" natural numbers is : " +number1 +" Comparison is true");

			
				
			
		}
		else{
			System.out.print( "The number "+number+" is not a natural number");
		}
		
	}
}

