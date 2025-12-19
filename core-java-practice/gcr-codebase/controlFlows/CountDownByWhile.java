package controlFlows;

import java.util.Scanner;
class CountDownByWhile{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a count down numbers : ");
		int counter = input.nextInt();
		while(counter>=1){
			System.out.println(counter--);
		
		}
					
	}
}
