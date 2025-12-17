import java.util.Scanner;
public class CalculateSI {
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        System.out.print("Enter Principal amount:  ");
        double p = obj.nextDouble();
        System.out.print("Enter Rate of Interest:  ");
        double r= obj.nextDouble();
        System.out.print("Enter Time in years:  ");
        double t= obj.nextDouble();
        double si =(p*r*t) / 100;
        System.out.println("Simple Interest is: " + si);
    }
}
