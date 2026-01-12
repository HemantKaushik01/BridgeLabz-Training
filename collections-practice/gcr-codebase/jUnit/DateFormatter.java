package jUnit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {
	public String formatDate(String inputDate) throws ParseException {
		SimpleDateFormat input = new SimpleDateFormat("yyyy-MM-dd");
		
		SimpleDateFormat output = new SimpleDateFormat("dd-MM-yyyy");
		
		Date date = input.parse(inputDate);
		return output.format(date);
	}
}
