package grc_codebase;
import java.util.*;
public class CentimeterToFeetAndInches {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the Height in centimeter: ");
		double cm= input.nextFloat();
		double inches = cm/2.54;
		double foot = inches/12;
		System.out.print("Your Height in cm is "+ cm +
				" while in feet is "+ foot + " and inches is "+inches);
	}
}
