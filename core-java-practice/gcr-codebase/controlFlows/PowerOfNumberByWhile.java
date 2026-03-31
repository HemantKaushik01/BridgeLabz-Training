package controlFlows;

import java.util.Scanner;
public class PowerOfNumberByWhile{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number : ");
		int number = input.nextInt();
		System.out.print("Enter power of a number : ");
		int power = input.nextInt();
		int result=1;
		int counter =0;
		while(counter!=power){
			result*=number;
			counter++;
			}
		System.out.println("The power  of number is: " +result);			
			
	}
}
