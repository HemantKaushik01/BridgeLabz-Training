package regex;
import java.util.regex.*;
import java.util.*;
public class UserNameValidate {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String regex = "^[a-zA-Z]+[a-zA-Z0-9_]{5,15}$";
		Pattern pattern = Pattern.compile(regex);
		System.out.println("Enter the user name for validation");
		String input = sc.next();
		
		Matcher matcher = pattern.matcher(input);
		
		if(matcher.find()) {
			System.out.println("The UserName is validate: "+matcher.group());
		}
		else {
			System.out.println("The UserName is unvalidate: "+input);

		}

	}

}
