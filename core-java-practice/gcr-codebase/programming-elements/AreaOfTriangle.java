package grc_codebase;
import java.util.*;
public class AreaOfTriangle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the base of triangle in cm: ");
		float base = sc.nextFloat();
		System.out.print("Enter the height of triangle in cm: ");
		float height = sc.nextFloat();
		
		float areaInCm = base*height/2;
		double areaInInches = (double)(base/2.54)*(height/2.54)*0.5;
		
		System.out.print("Area of triangle in Cm square "+ areaInCm+ " or in Inches " + areaInInches);
		

	}

}
