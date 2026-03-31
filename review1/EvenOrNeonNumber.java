import java.util.Scanner;

public class EvenOrNeonNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int num = sc.nextInt(); 
        EvenOrNeonNumber obj = new EvenOrNeonNumber();
        if (obj.isEven(num)) {
            System.out.println(num  + " is an Even number");
        } else {
            System.out.println(num + " is an Odd number");
        }

        if(obj.isNeon(num)) {
            System.out.println(num + " is a Neon number");
        } else {
            System.out.println(num + " is not a Neon number");
        }
        
    }
    public boolean isEven(int num) {
        return num % 2 == 0;
    }
    public boolean isNeon(int num) {
        int sq = num * num;
        int sum = 0;
        while (sq > 0) {
            sum += sq % 10;
            sq /= 10;
        }
        return sum == num;
    }
}
