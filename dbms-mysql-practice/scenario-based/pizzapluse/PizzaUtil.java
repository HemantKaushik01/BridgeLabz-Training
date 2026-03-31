package com.pizzapluse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class PizzaUtil  {
	List<String> pizzaTypeList = new  ArrayList<>(Arrays.asList("Margherita","Pepperoni","Veggie","BBQ Chicken"));

	public boolean validOrderId(String orderId)throws InvalidPizzaOrderException {
		String regex = "^PZ-\\d{3}$";
		boolean match = Pattern.matches(regex,orderId);
		if(!match) {
			throw new InvalidPizzaOrderException("The order ID <orderId> is invalid");
			
		}
		return true;
	}
	public boolean validatePizzaType(String pizzaType)throws InvalidPizzaOrderException {
		if(!pizzaTypeList.contains(pizzaType)) {
			throw new InvalidPizzaOrderException("The pizza type <Pizaa type> is invalid");

		}
		return true;
	}
	public boolean validateQuantity(int quantity)throws InvalidPizzaOrderException {
		if(quantity<0  || quantity>50 ) {
			throw new InvalidPizzaOrderException("The quantity<quntity> is invalid");
		}
		return true;
	}
	public double calculateFinalBill(String pizzaType, double basePrice, int quantity) throws InvalidPizzaOrderException  {
		if(basePrice<200) {
			throw new InvalidPizzaOrderException("Invalid base price for <prizza type");
		}
		double baseCost = basePrice*quantity;
		double toppingPercent=25; // default BBQ Chicken
		if(pizzaType.equals("Margherita")) {
			toppingPercent=10;
		}
		else if(pizzaType.equals("Pepperoni")) {
			toppingPercent=20;
			
		}
		else if(pizzaType.equals("Veggie")) {
			toppingPercent = 15;
		}
		double toppingCharge = (baseCost*toppingPercent)/100;
		double finalBill = baseCost+toppingCharge+100; // deliveryFee=100;
		return finalBill;
	}
}
