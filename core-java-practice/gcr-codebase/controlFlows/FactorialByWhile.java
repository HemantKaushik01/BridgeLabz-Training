package controlFlows;

import java.util.Scanner;
class FactorialByWhile{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int multi=1;
		System.out.print("Enter a numbers by the user : ");
		
		int number =input.nextInt();
		while(number>=1){
			multi*=number;
			number--;
		}
		
		
		System.out.print("factorial of the number" + number + " is "+ multi);			
			
	}
}
