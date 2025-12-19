package controlFlows;

import java.util.Scanner;
public class MultipleBelow100For{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a number for multiple: ");
		int number = input.nextInt();
		int counter = number-1;
		if(number>0 && number<100){
			System.out.println("The number is positive ");

		for(int i=counter;i>0;i--){
			if(number%i==0){
				System.out.print(i +" ");
			}
			
		 }
		}
		else{
			System.out.print("The number is nagative");
		}			
			
	}
}
