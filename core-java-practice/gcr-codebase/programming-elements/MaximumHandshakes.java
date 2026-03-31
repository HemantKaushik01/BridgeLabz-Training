package grc_codebase;
import java.util.*;
public class MaximumHandshakes {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of Students: ");
		int numberOfStudents = input.nextInt();
		int maximumHandshakes = (numberOfStudents*(numberOfStudents-1))/2;
		
		System.out.print("The Maximum number of Handshales is: "+maximumHandshakes);

	}

}
