package controlFlows;

import java.util.Scanner;
class MultiplicationTableByFor{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a number for multiplication table: ");
		int number = input.nextInt();
		for(int i=6;i<=9;i++){
			System.out.print(i*number +" ");
			
		}			
			
	}
}
