package com.librarymangement;

import java.util.*;
//import java.util.Observer;
interface Observer {
    void update(String message);
}
 class LibraryCatalog  {
	private static LibraryCatalog instance;
	private List<Book> books = new ArrayList<>();
	private List<Observer> observers = new ArrayList<>();
	private LibraryCatalog() {}
	public static synchronized LibraryCatalog getInstance() {
		if(instance == null) instance = new LibraryCatalog();
		return instance;
	}
	public void addBook(Book book) {
		books.add(book);
		newBook(book.getTitle());
	}
	public void addObserver(Observer obs) {
		observers.add(obs);
	}
	public void removeObserver(Observer obs) {
		observers.remove(obs);
	}
	private void newBook(String bookName) {
		for(Observer obs : observers) {
			obs.update("New book available: "+bookName);
		}
	}
	

}
