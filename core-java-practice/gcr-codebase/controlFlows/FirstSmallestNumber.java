package controlFlows;

import java.util.Scanner;
class FirstSmallestNumber{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the three numbers : ");
		int number1 = input.nextInt();
		int number2 = input.nextInt();
		int number3 = input.nextInt();
		if(number1<number2 && number1<number3){
			System.out.print( "Is the first number the smallest? : True");
		}
		else{
			System.out.print( "Is the first number the smallest? : False");
		}
		
	}
}