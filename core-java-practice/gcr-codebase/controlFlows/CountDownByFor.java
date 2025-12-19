package controlFlows;

import java.util.Scanner;
class CountDownByFor{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a count down numbers : ");
		int counter = input.nextInt();
		
		for(int i=counter;i>0;i--){
				System.out.println(i);
		}
					
	}
}
