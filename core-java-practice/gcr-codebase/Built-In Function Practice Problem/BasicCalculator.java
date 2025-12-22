import java.util.Scanner;
class BasicCalculator{

static Scanner input = new Scanner(System.in);

static int addition(int number1, int number2){
return (number1 + number2);
}

static int subtraction(int number1, int number2){
return Math.abs(number1 - number2);
}

static int multiplication(int number1, int number2){
return (number1*number2);
}

static double division(int number1 , int number2){
return (number1/number2);
}

public static void main(String[] args){
System.out.print("For addition enter (+) | For subtraction enter (-) | For multiplication (*) | For division (/) :");
char operation = input.next().charAt(0);
System.out.print("Enter numbers to perform operation on: ");
int number1 = input.nextInt();
int number2 = input.nextInt();
double result;



switch (operation){
case '+' :
	result = addition(number1,number2);
	System.out.println("Addition of these number is "+result);
	break;
case '-' :
	result = subtraction(number1,number2);
	System.out.println("Subtraction of these number is "+result);
	break;
case '*' :
	result = multiplication(number1,number2);
	System.out.println("Multiplication of these number is "+result);
	break;
case '/' :
	result = division(number1,number2);
	System.out.println("Division of these number is "+result);
	break;
default :
	System.out.println("Invalid operation...");
}

}
}