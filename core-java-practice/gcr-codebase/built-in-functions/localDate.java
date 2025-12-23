import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.*;

public class localDate {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter date in (yyyy-MM-dd)  : ");
		String dateString = input.next();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse(dateString, formatter);
		date = date.plusDays(07);
		date = date.plusMonths(01);
		date = date.plusYears(02);
		date = date.minusWeeks(03);
		System.out.println("new updated date is : " + date);

	}
}