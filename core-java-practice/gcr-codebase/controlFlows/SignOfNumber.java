package controlFlows;

import java.util.Scanner;
class SignOfNumber{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a numbers : ");
		int number = input.nextInt();
		
		if(number>0){
			System.out.print( "The number is positive number");
		}
		else if(number<0){
			System.out.print( "The number is negtive number");

		}
		else{
			
		        System.out.print( "The number is zero");
		}

	}
}
