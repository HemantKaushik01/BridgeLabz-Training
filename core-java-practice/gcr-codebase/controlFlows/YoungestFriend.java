package controlFlows;

import java.util.Scanner;
class YoungestFriend{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter age and height of first friend: " );
		int age1=input.nextInt();
		int height1 = input.nextInt();
		System.out.println("Enter age and height of second friend: " );
		int age2=input.nextInt();
		int height2 = input.nextInt();
		System.out.println("Enter age and height of third friend: " );
		int age3=input.nextInt();
		int height3 = input.nextInt();

		if(age1< age2 && age1 <age3){
			
			System.out.println("The smallest age of friend " +age1);
		}
		else if(age2< age1 && age2 <age3){
			
			System.out.println("The smallest age of friend " +age2);
		}
		else {
			System.out.println("The smallest age of friend " +age3);
		}

        if(height1> height2 && height1 > height3){
        	
        	System.out.println("The largest height of friend : " +height1);
		}
		else if(height2 > height1 && height2 > height3){
			System.out.println("The largest height of friend : " +height2);
		}
		else {
			System.out.println("The largest height of friend : " +height3);
		}
					
			
	}
}
