package arrays;

import java.util.*;
public class SignOfArrayElement{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int arr[] =new int[5];
		System.out.print("Enter the number of array : "); 
		
		for(int i=0;i<5;i++){
			arr[i] = input.nextInt();
			if(arr[i] > 0){
				System.out.println( "The number " + arr[i]+" is positive ");
				if(arr[i]%2==0){
					System.out.println( "The number " + arr[i]+ " is even ");
				}				
				else{
					System.out.println( "The number " + arr[i]+ " is odd ");	
				}
			}
			else if(arr[i] ==0){
				System.out.println( "The number " + arr[i]+ " is zero ");
			}
			else{
			       System.out.println( "The number " + arr[i]+ " is Negative ");
			}
		}
		if(arr[0] > arr[4]){
			System.out.println( "The first element is greater than last element ");
		}
		else if(arr[0] <arr[4]){
			System.out.println( "The last element is greater than first element ");
		}
		else{
			System.out.println("Both are equal");
		}

		

	}
}