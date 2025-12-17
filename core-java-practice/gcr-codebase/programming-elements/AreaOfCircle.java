import java.util.*;
public class AreaOfCircle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the radius of the circle: ");
        double r = sc.nextInt();
        double a = 3.14* r * r;
        System.out.println("The area of the circle with radius " + r + " is: " + a);
    }
}
