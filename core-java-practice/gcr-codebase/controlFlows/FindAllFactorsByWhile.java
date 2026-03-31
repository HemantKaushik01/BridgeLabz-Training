package controlFlows;

import java.util.Scanner;
class FindAllFactorByWhile{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a number for factor: ");
		int number = input.nextInt();
		int counter = number-1;
		while(counter>0){
			if(number%counter==0){
				System.out.print(counter +" ");
			}
			counter--;
		}			
			
	}
}
