package secnario_Based;
import java.util.*;
public class FitnessTrackerBMI {
	public static void main(String[] args) {
		Scanner  sc = new Scanner(System.in);
		System.out.println("BMI Fitness Tracker");
		System.out.print("Please enter your height in CM for calculate BMI: ");
		int height= sc.nextInt();
		System.out.print("Please enter your weight in Kg for calculate BMI: ");
		int weight= sc.nextInt();
		
		double BMI = weight/(height*height);
		if(BMI<18.50) {
			System.out.print("Your BMI is Underweight");
			
		}
		else if(BMI>18.50 && BMI<25) {
			System.out.print("Your BMI is Normal");
			
		}
		else {
			System.out.print("Your BMI is Overweight");
		}
	}
}
