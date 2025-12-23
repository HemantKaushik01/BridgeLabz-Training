import java.util.Scanner;

class CheckPrimeNumber{

static Scanner input = new Scanner(System.in);

static int inputNumber(){
System.out.print("Enter number:");
int num = input.nextInt();
return num;
}

static Boolean isPrime(int number){
boolean flag = false;
for(int i = 2; i < number ;i++){
if(number % i == 0){
flag = true;
break;
}
}
return flag;
}

static void displayIsPrime(boolean flag, int number){
if(flag){
System.out.println(number + " is not a prime number");
}
else{
System.out.println(number + " is a prime number");
}
}


public static void main(String[] args){
int number = inputNumber();
boolean flag = isPrime(number);
displayIsPrime(flag, number);

}

}