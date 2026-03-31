package controlFlows;

import java.util.Scanner;
public class NumberOfDigits{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the Number : ");
		int number = input.nextInt();
		int count = 0;
		int originalNumber = number;
		while(originalNumber != 0){
			count ++;
			originalNumber /= 10;
		}
		System.out.print(number + " have " + count + " digits");
	}
}