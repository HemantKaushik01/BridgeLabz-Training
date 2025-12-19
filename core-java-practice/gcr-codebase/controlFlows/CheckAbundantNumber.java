package controlFlows;

import java.util.Scanner;
public class CheckAbundantNumber{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number : ");
		int number = input.nextInt();
		int sum = 0;
		for(int i=1; i< number ;i++){
			if(number % i == 0){
				sum += i;
			}
		}
		if(sum > number){
			System.out.println(number + " is a Abundant Number ");
		}
		else{
			System.out.println(number + " is not a Abundant Number ");
		}

	}
}