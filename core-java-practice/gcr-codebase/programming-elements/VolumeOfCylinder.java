import java.util.*;
public class VolumeOfCylinder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the radius of the cylinder: ");
        double r = input.nextDouble();
        System.out.print("Enter the height of the cylinder: ");
        double h = input.nextDouble();
        double v = 3.14 * r * r * h;
        System.out.println("The volume of the cylinder is: " + v);
    }
}
