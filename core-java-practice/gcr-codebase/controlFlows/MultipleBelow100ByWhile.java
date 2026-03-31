package controlFlows;

import java.util.Scanner;
public class MultipleBelow100ByWhile{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a number for multiple: ");
		int number = input.nextInt();
		int counter = number-1;
		if(number>0 && number<100){
			System.out.println("The number is positive ");

		while(counter>1){
			if(number%counter==0){
				System.out.print(counter +" ");
			}
			counter--;
		}
		}
		else{
			System.out.print("The number is nagative");
		}			
			
	}
}
