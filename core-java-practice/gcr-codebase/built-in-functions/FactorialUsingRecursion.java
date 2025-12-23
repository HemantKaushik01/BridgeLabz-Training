import java.util.Scanner;
class FactorialUsingRecursion{

static Scanner input = new Scanner(System.in);

static int inputNumber(){
System.out.print("Enter Number: ");
int number = input.nextInt();
return number;
}

static int factorial(int number){
if(number<=1){
return 1;
}
factorial(number-1);
return number*factorial(number-1);

}

public static void main(String[] args){
int number = inputNumber();
int result = factorial(number);
System.out.println("Factorial of "+number + " is " + result);
}



}