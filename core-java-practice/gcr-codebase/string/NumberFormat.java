package string;

import java.util.Scanner;

public class NumberFormat {

    public static void generateException(String text) {

        int number = Integer.parseInt(text);   
        System.out.println("Converted number: " + number);
    }


    public static void handleRuntimeException(String text) {
        try {
            int number = Integer.parseInt(text);
            System.out.println("Parsed number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("java get NumberFormatException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("java get RuntimeException: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String userInput = input.nextLine();

        try {
            generateException(userInput);  
        }catch (NumberFormatException e){
		System.out.println("Handling Exception ");
		 handleRuntimeException(userInput);
		
	}
	 catch (Exception e) {
            System.out.println("Exception caught in main: " + e.getMessage());
        }

        
       
    }
}
