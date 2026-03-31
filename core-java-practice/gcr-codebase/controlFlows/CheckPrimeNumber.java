package controlFlows;

import java.util.Scanner;
public class CheckPrimeNumber{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number : ");
		int number = input.nextInt();
		Boolean isPrime = true;
		for(int i=2; i<number ;i++){
			if(number % i == 0){
				isPrime = false;
				break;
			}
		}
		System.out.println(number + " Is a Prime Number ? " + isPrime);
	}
}