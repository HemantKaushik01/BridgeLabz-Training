package methods;

import java.util.Scanner;
public class SignOfNumber{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a numbers : ");
		int number = input.nextInt();
		SignOfNumber obj = new SignOfNumber();
		System.out.println(  obj.sign(number));
	}
	public int sign(int number){
		
		if(number>0){
			return 1;
		}
		else if(number<0){
			return -1;

		}
		else{
			
		        return 0;
		}

	}
}
