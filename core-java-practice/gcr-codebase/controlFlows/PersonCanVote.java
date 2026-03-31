package controlFlows;

import java.util.Scanner;
class PersonCanVote{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter age of the person : ");
		int age=input.nextInt();
		if(age>=18){
			System.out.print("The person age is " + age + " and can vote.");
		}
		else{
			
			System.out.print("The person age is " + age + " and cannot vote.");
		}

		
	}
}
