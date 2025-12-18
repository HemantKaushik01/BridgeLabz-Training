package grc_codebase;
import java.util.*;
public class DistanceInYardMiles {
	public static void main(String[] args) {
		Scanner input =new Scanner(System.in);
		System.out.print("Enter the distance in feets: ");
		float distanceInFeet = input.nextFloat();
		
		float distanceInYard = distanceInFeet/3;
		float distanceInMile = distanceInYard/1760;
		
		System.out.print("Distance in feet, yard, mile respectivly are "+distanceInFeet+", "+distanceInYard+" and "+distanceInMile);
		
	}
}
