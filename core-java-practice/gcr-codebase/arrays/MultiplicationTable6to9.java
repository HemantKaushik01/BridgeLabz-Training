package arrays;
import java.util.Scanner;
class MultiplicationTable6to9{
	public static void main(String[] args){
	 	Scanner input = new Scanner(System.in);
		System.out.println("Enter a number for multiplication table: ");
		int number = input.nextInt();
		int arr[] = new int[4];
		for(int i=0;i<4;i++){
			arr[i] = (i+6)*number;
			
		}
		System.out.println("Print the table from 6 to 9 of a number : ");
		for(int i=0;i<4;i++){
			System.out.println(number+"*"+(i+6)+" = "+arr[i] );
		}
						
			
	}
}