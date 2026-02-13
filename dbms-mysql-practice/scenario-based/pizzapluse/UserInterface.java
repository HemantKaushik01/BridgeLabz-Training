package com.pizzapluse;

import java.util.Scanner;



public class UserInterface {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("========Welcome Pizza Billing========= \n");
		System.out.print("Available pizza types are:"
				+ "\n Margherita"
				+ "\n Pepperoni"
				+ "\n Veggie"
				+ "\n BBQ Chicken");
		System.out.println("Enter the order Detail in this format:"
				+ "\n orderId:pizzaType:basePrice:quantity");
		String str[] = sc.nextLine().split(":");
		PizzaUtil pizzaUtil = new PizzaUtil();
		try {
			pizzaUtil.validOrderId(str[0]);
			pizzaUtil.validatePizzaType(str[1]);
			pizzaUtil.validateQuantity(Integer.parseInt(str[3]));
			double finalBill = pizzaUtil.calculateFinalBill(str[1],Integer.parseInt(str[2]), Integer.parseInt(str[3]));
			System.out.print("Total bill for"+str[1]+" pizzas:"+finalBill);
		}
		catch (InvalidPizzaOrderException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("Invalid input");
		}
	}
}
