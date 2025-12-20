package arrays;

import java.util.*;
class MultiplicationTable{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number : "); 
		int number = input.nextInt();
		int arr[]=new int[10];
		for(int i=1;i<=10;i++){
			arr[i-1]=number*i;
		}
		System.out.println("Print the multiplication array : ");
		for(int i=0;i<10;i++){
			System.out.println(number +" * " + (i+1)  +  " = " +  arr[i]);
		}
	}
}