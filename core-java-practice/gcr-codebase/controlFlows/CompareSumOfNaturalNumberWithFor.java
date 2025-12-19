package controlFlows;

import java.util.Scanner;
class CompareSumOfNaturalNumberWithFor{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a numbers : ");
		int number = input.nextInt();
		
		if(number>0){
			int sumByFormula=number*(number+1)/2;
			int sumByForLoop=0;
			for(int i=1;i<=number;i++){
				sumByForLoop+=i;
			}
			if(sumByFormula == sumByForLoop)
			System.out.print( "The sum of " + sumByForLoop +" natural numbers is : " +number +" Comparison is true");

			
				
			
		}
		else{
			System.out.print( "The number "+number+" is not a natural number");
		}
		
	}
}
