package grc_codebase;
import java.util.*;
public class SquareSide {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the Parameter of square: ");
		float parameter =input.nextFloat();
		
		float side = parameter/4;
		System.out.print("The length of the side is "+ side+" whose perimeter is "+parameter);
		

	}

}
