package grc_codebase;

public class ProfitLoss {

	public static void main(String[] args) {
		int cp = 129;
		int sp = 191;
		
		
		float profit= sp-cp;
		float profitPercentage = (profit/cp)*100;
		System.out.print("The Cost Price is INR "+ cp+ " and Selling Price is INR "+sp+"\n The Profit is "+profit+" and ProfitPercentage "
				+ profitPercentage);
		
		

	}

}
