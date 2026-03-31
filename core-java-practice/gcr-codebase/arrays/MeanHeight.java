package arrays;
import java.util.*;
class MeanHeight{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		double arr[] = new double[11];
		double sum =0.0;
		System.out.println("Enter the height of each player in football team (no. of players 11)  : "); 
		for(int i=0;i<11;i++){
			arr[i] = input.nextDouble();
			sum+=arr[i];
		}
		double mean =sum/11;
		System.out.print("Mean height of the football team is : " + sum);
			
					
		
	}
}