import java.util.*;
public class CelsiusToFahrenheit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Temperature in celsius: ");
        double c = sc.nextDouble();
        double f = (c * 9/5) + 32;
        System.out.println(c + " degrees Celsius is equal to " + f + " degrees Fahrenheit");
    }
}