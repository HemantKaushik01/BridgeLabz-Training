package grc_codebase;

public class UniversityFees {
	public static void main(String[] args) {
		int fee = 125000;
		int discountPercentage = 10;
		int discount = fee/discountPercentage;
		int discountedFee = fee- discount;
		System.out.println("The discount amount is INR "+ discount+" and final dicounted fee is INR "+discountedFee) ;
	}
}
