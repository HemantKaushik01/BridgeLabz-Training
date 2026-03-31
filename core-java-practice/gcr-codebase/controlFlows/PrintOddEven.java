package controlFlows;

import java.util.Scanner;

public class PrintOddEven {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number =input.nextInt();
        for(int i=1;i<=number;i++){
        	if(i%2==0){
        		System.out.println("The number is even : "+i);
        	}
        	else{
			System.out.println("The number is odd : "+i);
        	}
        }
    }
}
