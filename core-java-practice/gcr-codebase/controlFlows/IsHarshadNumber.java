package controlFlows;

import java.util.Scanner;
public class IsHarshadNumber{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the Number : ");
		int number = input.nextInt();
		int sum = 0;
		int originalNumber = number;
		while(originalNumber != 0){
			int reminder = originalNumber % 10;
			sum += reminder;
			originalNumber = originalNumber / 10;
		}
		if(number % sum == 0){
			System.out.println(number + " is a Harshad Number");
		}
		else{
			System.out.println(number + " is not a Harshad Number");
		}
	}
}