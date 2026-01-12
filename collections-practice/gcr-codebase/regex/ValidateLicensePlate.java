package regex;
import java.util.regex.*;
import java.util.*;
public class ValidateLicensePlate {

	public static void main(String[] args) {
		String regex = "^[A-Z]{2}[0-9]{4}$";
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the license plate number: ");
		String licensePlateNumber = sc.next();
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(licensePlateNumber);
		if(matcher.find()) {
			System.out.println("The license plate number is validate: "+matcher.group());
		}
		else {
			System.out.println("The license plate number is unvalidate: "+licensePlateNumber);

		}

	}

}
