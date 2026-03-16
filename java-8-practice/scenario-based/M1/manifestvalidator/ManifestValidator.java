package manifestvalidator;

import java.util.Scanner;

class Validator{
	public boolean isCodeValid(String code) {
		if(!code.matches("^SHIP-[1-9][0-9]{5}$")) {
			return false;
		}
		String digits = code.substring(5);
		int count =1;
		for(int i=1;i<digits.length();i++) {
			if(digits.charAt(i)==digits.charAt(i-1)) {
				count++;
				if(count > 3) {
					return false;
				}
				
			}
			else {
				count =1;
			}
		}
		return true;
	}
	public boolean isShipmentDate(String date) {
		String []str= date.split("-");
		int year = Integer.parseInt(str[0]);
		int month = Integer.parseInt(str[1]);
		int day = Integer.parseInt(str[2]);
		if(year<2000 || year>2099) {
			return false;
		}
		int amonths[]= {31,28,31,30,31,30,31,31,30,31,30,31};
		if((year%4==0 && year %100 !=0) || year%400==0) {
			amonths[1]=29;
		}
		if(month<1 || month>12) {
			
			return false;
		}
		int aday =amonths[month-1];
		if(day <1 || day>aday) {
			return false;
		}
		return true;
		
	}
	public boolean isModeValid(String mode) {
	    return mode.equals("AIR") ||
	           mode.equals("SEA") ||
	           mode.equals("ROAD") ||
	           mode.equals("RAIL") ||
	           mode.equals("EXPRESS") ||
	           mode.equals("FREIGHT");
	}
	public boolean isWeightValid(String weight) {
		if(!weight.matches("^(0|[1-9]\\d{0,5})(\\.\\d{1,2})?$")) return false;
		
		double w = Double.parseDouble(weight);
		if(w<0 || w>999999.99 ) {
			return false;
		}
		return true;
	}
	public boolean isDeliveryStatus(String status) {
	    return status.matches("DELIVERED|CANCELLED|IN_TRANSIT");
	}
	
}
public class ManifestValidator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Validator obj = new Validator();
		int n= Integer.parseInt(sc.nextLine());
		while(n-->0) {
			String values[] = sc.nextLine().split("\\|");
			if(obj.isCodeValid(values[0]) 
					&& obj.isShipmentDate(values[1])
					&& obj.isModeValid(values[2])
					&& obj.isWeightValid(values[3])
					&& obj.isDeliveryStatus(values[4])) {
				System.out.println("COMPLIANT RECORD");
			}
			else {
				System.out.println("NON-COMPLIANT RECORD");
			}
			
		}
	}
}
