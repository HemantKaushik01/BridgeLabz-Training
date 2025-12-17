import java.util.Scanner;
public class PerimeterOfRectangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of the rectangle: ");
        double len = sc.nextDouble();
        System.out.print("Enter the breadth of the rectangle: ");
        double bre = sc.nextDouble();
        double perimeter = 2*(len+bre);
        System.out.println("The perimeter of the rectangle is: " + perimeter);
    }
}
