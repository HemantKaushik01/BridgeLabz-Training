package grc_codebase;
import java.util.*;
public class BasicCalculator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number1 and number2 respectily: ");
		float number1 = sc.nextFloat();
		float number2 = sc.nextFloat();
		
		// Addition
		float add = number1+number2;
		
		// substraction
		float sub = number1-number2;
		
		//multipliction
		float mul = number1*number2;
		
		// divison
		float div = number1/number2;
		
		System.out.print("The addition, subtraction, multiplication and division value of 2 numbers "+number1+" and "+number2+" is "+add+", "+sub+", "+mul+", and "+div);
		
	}
}
