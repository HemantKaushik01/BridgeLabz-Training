package com.pizzapluse;

public class InvalidPizzaOrderException extends Exception{
	public InvalidPizzaOrderException(String massage) {
		super(massage);
	}
}