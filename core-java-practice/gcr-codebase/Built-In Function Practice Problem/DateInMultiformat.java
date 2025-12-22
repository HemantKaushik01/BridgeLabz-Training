import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.*;

public class DateInMultiformat {
    public static void main(String[] args) {
	Scanner input =new Scanner(System.in);
	System.out.println("Enter date in (yyyy-MM-dd)  : ");
	String dateString = input.next();
	DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	LocalDate date = LocalDate.parse(dateString, inputFormatter);



        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("EEE, MMM dd, yyyy");

	System.out.println("new updated date is (yyyy-MM-dd) : "+ date.format(formatter1));
	System.out.println("new updated date is (yyyy/MM/dd) : "+ date.format(formatter2));
	System.out.println("new updated date is (EEE, MMM dd, yyyy) : "+ date.format(formatter3));

	

	
	

            }
}