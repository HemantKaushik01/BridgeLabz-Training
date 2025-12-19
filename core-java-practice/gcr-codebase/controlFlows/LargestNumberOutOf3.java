package controlFlows;

import java.util.Scanner;
class LargestNumberOutOf3{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the three numbers : ");
		int number1 = input.nextInt();
		int number2 = input.nextInt();
		int number3 = input.nextInt();
		if(number1>number2 && number1>number3){
			System.out.println( "Is the first number the largest? : True");
			System.out.println( "Is the second number the largest? : False");
			System.out.println( "Is the third number the largest? : False");

		}
		else if(number2>number1 && number2>number3){
			System.out.println( "Is the first number the largest? : False");
			System.out.println( "Is the second number the largest? : True");
			System.out.println( "Is the third number the largest? : False");

		}
		else{
			System.out.println( "Is the first number the largest? : False");
			System.out.println( "Is the second number the largest? : False");
			System.out.println( "Is the third number the largest? : True");
		}
			
		
	}
}