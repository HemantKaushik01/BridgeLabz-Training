package controlFlows;

import java.util.Scanner;
class FactorialByFor{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int multi=1;
		System.out.print("Enter a numbers by the user : ");
		int number =input.nextInt();
		for(int i=number;i>=1;i--){
			multi*=i;
		}
		
		System.out.print("factorial of the number" + number + " is "+ multi);			
			
	}
}
