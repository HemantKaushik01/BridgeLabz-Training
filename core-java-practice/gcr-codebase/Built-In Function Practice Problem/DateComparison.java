import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.*;

public class DateComparison {
    public static void main(String[] args) {
	Scanner input =new Scanner(System.in);
	System.out.println("Enter first date in (yyyy-MM-dd)  : ");
	String dateString1 = input.next();
	System.out.println("Enter second date in (yyyy-MM-dd)  : ");
	String dateString2 = input.next();
	
	DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	LocalDate date1 = LocalDate.parse(dateString1, inputFormatter);
	LocalDate date2 = LocalDate.parse(dateString2, inputFormatter);
	if(date1.isBefore(date2)){
		System.out.print("Date1 is before to Date2");
	}
	else if(date1.isAfter(date2)){
		System.out.print("Date1 is after to Date2");
	}
	else if(date1.isEqual(date2)){
		System.out.print("Date1 is equal to Date2");
	}




        

	

	
	

            }
}