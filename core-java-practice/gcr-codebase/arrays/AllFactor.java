package arrays;

import java.util.Scanner;
class AllFactor{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a number for factor: ");
		int number = input.nextInt();
		int count=0;
		for(int i=1;i<number;i++){
			if(number%i==0){
				count++;
			}
		}
		int idx=0;
		int arr[] = new int[count];
		for(int i=1;i<number;i++){
			if(number%i==0){
				arr[idx]=i;
				idx++;
			}
		}
		System.out.println("All factor of this number " +number+ " is : ");
		for(int i=0;i<count;i++){
			System.out.print(arr[i]+" ");
		}			
			
	}
}