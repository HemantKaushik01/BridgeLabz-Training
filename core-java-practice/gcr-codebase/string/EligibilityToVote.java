package string;

import java.util.*;
public class EligibilityToVote{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int students[] = new int[10];
		System.out.println("Enter the age of 10 students : ");
		for(int i=0;i<10;i++){
			students[i] = input.nextInt();
		}
		String[][] eligibility=  checkEligibility(students);
		for(int i=0;i<10;i++){
			System.out.println("Is the student is eligible to vote with age :(" +eligibility[i][0] + ") True/false ? " +eligibility[i][1]); 
                } 
	}
	public static String[][] checkEligibility(int arr[]){
		String[][] eligibility = new String[10][2];
		for(int i=0;i<10;i++){
			if(arr[i]>=18){
				eligibility[i][0]=String.valueOf(arr[i]);
				eligibility[i][1]="true";
			}
			else{
				eligibility[i][0]=String.valueOf(arr[i]);
				eligibility[i][1]="false";
			}
		}
		return eligibility;
	}
}
				
				