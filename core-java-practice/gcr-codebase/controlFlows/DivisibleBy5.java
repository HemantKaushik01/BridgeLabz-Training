package controlFlows;

import java.util.Scanner;
class DivisibleBy5{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number: ");
		int number = input.nextInt();
		if(number%5==0){
			System.out.print(" Is the number " + number + " divisible by 5 " +true);
		}
 		else{
			System.out.print(" Is the number " + number + " divisible by 5 " +false);
		}
	}
}