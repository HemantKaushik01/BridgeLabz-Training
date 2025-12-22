import java.util.Scanner;

class MaximumOfThreeNumbers{

static Scanner input = new Scanner(System.in);

static int inputNumber(){
int num = input.nextInt();
return num;
}

static int maximumNumber(int num1 , int num2, int num3){
int maximum = Math.max(num1, num2);
maximum = Math.max(maximum, num3);
return maximum;
}

public static void main(String[] args){
System.out.print("Enter Three numbers : ");
int number1 = inputNumber();
int number2 = inputNumber();
int number3 = inputNumber();

int result = maximumNumber(number1, number2, number3);

System.out.println("Maximum Number between given Three number is : "+result);
}

}