package regex;
import java.util.regex.*;
public class ExtractDates {

	public static void main(String[] args) {
		 String regex = "\\b\\d{2}/\\d{2}/\\d{4}\\b"; 
	        Pattern pattern = Pattern.compile(regex);
	        String input = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020";
	        
	        Matcher matcher = pattern.matcher(input);
	        System.out.println("Matched dates: ");
	        while (matcher.find()) {
	            System.out.print( matcher.group()+", ");
	        }

	}

}
