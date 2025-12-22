package secnario_Based;
import java.util.*;
public class CoffeeCounterChronicles {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		do {
			
			System.out.println("which type of coffee you want to choose:");
			System.out.println("Coffee Name:     Coffee Price:\n"
					+ "Espresso      $20\n"
					+ "Latte         $25\n"
					+ "Cappuccino    $50");
			String type= sc.next();
			System.out.print("Enter the quantity of coffee: ");
			int quantity=sc.nextInt();
			int total;
			int gst;
			switch(type.toLowerCase()) {
				case "espresso":
					total = 20*quantity;
					System.out.println("The total price of coffee: "+total);
					System.out.println("The GST rate on coffee is 5%");
					 gst = (total*5)/100;
					System.out.println("The final Bill: "+ total+gst);
					System.out.println();
					break;
				
				case "latte":
					 total = 25*quantity;
					System.out.println("The total price of coffee: "+total);
					System.out.println("The GST rate on coffee is 5%");
					 gst = (total*5)/100;
					System.out.println("The final Bill: "+ total+gst);
					System.out.println();
					break;
				
				case "cappuccino":
					 total = 50*quantity;
					System.out.println("The total price of coffee: "+total);
					System.out.println("The GST rate on coffee is 5%");
					 gst = (total*5)/100;
					 total=total+gst;
					System.out.println("The final Bill: "+ (total));
					System.out.println();
					break;
				default:
					System.out.print("Sorry, This coffee is not available");
				}
			System.out.println("Choose the option: ");
			System.out.println("If more customer for Coffee enter: 1");
			System.out.println("If no more coustomer and exit enter: 2");
			int flag=sc.nextInt();
			if(flag==2) {
				break;
			}
				
			}while(true);
		System.out.print("Thank you for comming ");
			
			
	}
	
}
