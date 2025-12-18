package grc_codebase;
import java.util.*;
public class UniversityFeesUserInput {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the fee of University: ");
		int fee = sc.nextInt();
		System.out.print("Enter the discount percent of fee: ");
		float discountPercentage = sc.nextFloat();
		float discount = fee/discountPercentage;
		float discountedFee = fee- discount;
		System.out.println("The discount amount is INR "+ discount+" and final dicounted fee is INR "+discountedFee) ;
	}
}
