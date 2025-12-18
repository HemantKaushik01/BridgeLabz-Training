package grc_codebase;
import java.util.*;
public class KmToMilesUserInput {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the distance in KM: ");
		double km = input.nextDouble();
		
		double miles = km*0.621371;
		System.out.print("Converted miles is "+miles);
		
	}
}
