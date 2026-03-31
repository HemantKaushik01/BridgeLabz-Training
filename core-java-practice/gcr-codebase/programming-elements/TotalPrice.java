package grc_codebase;
import java.util.*;
public class TotalPrice {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the unitPrice of an item: ");
		int unitPrice = sc.nextInt();
		System.out.print("Enter the quantity of items: ");
		int quantity = sc.nextInt();
		// Calculate total price
		int totalPrice = unitPrice*quantity;
		
		System.out.print("The total purchase price is INR "+totalPrice+" if the quantity "+ quantity+" and unit price is INR "+ unitPrice);
	}
}
