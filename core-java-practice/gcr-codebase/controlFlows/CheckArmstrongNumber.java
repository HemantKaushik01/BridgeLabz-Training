package controlFlows;

import java.util.Scanner;
public class CheckArmstrongNumber{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number : ");
		int number = input.nextInt();
		int sum = 0;
		int originalNumber = number;
		while(originalNumber != 0){
			int reminder = originalNumber % 10 ;
			sum += (reminder*reminder*reminder);
			originalNumber = originalNumber / 10; 
		}

		if(sum == number){
			System.out.println(number + " is a Armstrong number");
		}
		else{
			System.out.println(number + " is not a Armstrong number");
		}

	}
}