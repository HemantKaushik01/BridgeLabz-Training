package methods;

import java.util.Scanner;
class SumOfNaturalNumber{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a numbers : ");

		int number = input.nextInt();


		SumOfNaturalNumber sum =new SumOfNaturalNumber();
		System.out.print("Sum of natural numbers : "+sum.fun(number));
	}
	public int fun(int number){
		if(number>0){
			int sum=number*(number+1)/2;
			return sum;
		}
		else{
			System.out.println( "The number "+number+" is not a natural number");
			return 0;
		}
		
	}
}
