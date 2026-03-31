package com.in.addressbook;

import java.util.*;

public class AddressBookMain{
	 private static final Scanner sc = new Scanner(System.in);
	 private static final AddressBookSystem system = new AddressBookSystem();
	 public static void main(String[] args) {

	        System.out.println("!!!!!!!! Welcome to Address Book !!!!!!!");
	        
	        boolean exit = false;
	        while(!exit) {
	        	showMenu();
	        	System.out.print("Enter your Choice: ");
	        	int choice = sc.nextInt();
	        	sc.nextLine();
	        	switch (choice) {

                case 1:
                    addAddressBook();
                    break;

                case 2:
                    addContact();
                    break;

                case 3:
                    editContact();
                    break;

                case 4:
                    deleteContact();
                    break;

                case 5:
                    sortByName();
                    break;

                case 6:
                    sortByCity();
                    break;

                case 7:
                    sortByState();
                    break;

                case 8:
                    sortByZip();
                    break;

                case 9:
                    displayAddressBook();
                    break;

                case 10:
                    searchByCity();
                    break;

                case 11:
                    searchByState();
                    break;

                case 12:
                    countByCity();
                    break;

                case 13:
                    countByState();
                    break;

                case 0:
                    exit = true;
                    break;

                default:
                    System.out.println("❌ Invalid choice");
	        	}
	        }
	}
	private static void showMenu() {
	        System.out.println("\n---------------- MENU ----------------");
	        System.out.println("1. Add Address Book");
	        System.out.println("2. Add Contact");
	        System.out.println("3. Edit Contact");
	        System.out.println("4. Delete Contact");
	        System.out.println("5. Sort Contacts By Name");
	        System.out.println("6. Sort Contacts By City");
	        System.out.println("7. Sort Contacts By State");
	        System.out.println("8. Sort Contacts By Zip");
	        System.out.println("9. Display Address Book");
	        System.out.println("10. Search Person By City");
	        System.out.println("11. Search Person By State");
	        System.out.println("12. Count By City");
	        System.out.println("13. Count By State");
	        System.out.println("0. Exit");
	        System.out.println("--------------------------------------");
	    }
	private static void addAddressBook() {
		System.out.print("Enter Address Book Name: ");
		String name = sc.nextLine();
		AddressBook book = new AddressBook(name);
		system.addAddressBook(book);

        System.out.println("✅ Address Book added");
	}
	 private static void addContact() {
	        AddressBook book = getBook();
	        if (book == null) return;

	        Contacts contact = readContact();
	        book.addContact(contact);

	        system.addToCityMap(contact);
	        system.addToStateMap(contact);

	        System.out.println("✅ Contact added");
	    }
	  private static void editContact() {
	        AddressBook book = getBook();
	        if (book == null) return;

	        System.out.print("First Name: ");
	        String fn = sc.nextLine();
	        System.out.print("Last Name: ");
	        String ln = sc.nextLine();

	        System.out.print("New Address: ");
	        String address = sc.nextLine();
	        System.out.print("City: ");
	        String city = sc.nextLine();
	        System.out.print("State: ");
	        String state = sc.nextLine();
	        System.out.print("Zip: ");
	        int zip = sc.nextInt();
	        System.out.print("Phone: ");
	        int phone = sc.nextInt();
	        sc.nextLine();
	        System.out.print("Email: ");
	        String email = sc.nextLine();

	        book.editContact(fn, ln, address, city, state, zip, phone, email);
	        System.out.println("✅ Contact updated");
	    }
	  private static void deleteContact() {
	        AddressBook book = getBook();
	        if (book == null) return;

	        System.out.print("First Name: ");
	        String fn = sc.nextLine();
	        System.out.print("Last Name: ");
	        String ln = sc.nextLine();

	        book.deleteContact(fn, ln);
	        System.out.println("✅ Contact deleted");
	    }
	  private static void sortByName() {
	        AddressBook book = getBook();
	        if (book == null) return;

	        book.sortByName();
	        book.displayAddressBook();
	    }
	  private static void sortByCity() {
	        AddressBook book = getBook();
	        if (book == null) return;

	        book.sortByCity();
	        book.displayAddressBook();
	    }

	    private static void sortByState() {
	        AddressBook book = getBook();
	        if (book == null) return;

	        book.sortByState();
	        book.displayAddressBook();
	    }

	    private static void sortByZip() {
	        AddressBook book = getBook();
	        if (book == null) return;

	        book.sortByZip();
	        book.displayAddressBook();
	    }
	    private static void displayAddressBook() {
	        AddressBook book = getBook();
	        if (book != null) {
	            book.displayAddressBook();
	        }
	    }
	    private static void searchByCity() {
	        System.out.print("Enter City: ");
	        system.searchPersonByCity(sc.nextLine());
	    }

	    private static void searchByState() {
	        System.out.print("Enter State: ");
	        system.searchPersonByState(sc.nextLine());
	    }
	    private static void countByCity() {
	        System.out.print("Enter City: ");
	        String city = sc.nextLine();
	        System.out.println("Count = " + system.countByCity(city));
	    }

	    private static void countByState() {
	        System.out.print("Enter State: ");
	        String state = sc.nextLine();
	        System.out.println("Count = " + system.countByState(state));
	    }
	    private static AddressBook getBook() {
	        System.out.print("Enter Address Book Name: ");
	        String name = sc.nextLine();
	        AddressBook book = system.getAddressBook(name);
	        if (book == null) {
	            System.out.println("❌ Address Book not found");
	        }
	        return book;
	    }
	    private static Contacts readContact() {

	        System.out.print("First Name: ");
	        String fn = sc.nextLine();
	        System.out.print("Last Name: ");
	        String ln = sc.nextLine();
	        System.out.print("Address: ");
	        String address = sc.nextLine();
	        System.out.print("City: ");
	        String city = sc.nextLine();
	        System.out.print("State: ");
	        String state = sc.nextLine();
	        System.out.print("Zip: ");
	        int zip = sc.nextInt();
	        System.out.print("Phone: ");
	        long phone = sc.nextLong();
	        sc.nextLine();
	        System.out.print("Email: ");
	        String email = sc.nextLine();

	        return new Contacts(fn, ln, address, city, state, zip, phone, email);
	    }
	

}














































//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class AddressBookMain {
//	public void showMenu() {
//		System.out.println("1. For adding the New Address Book");
//		System.out.println("2. For adding new Contect in existing AddressBook");
//		System.out.println("3. For edit Contact");
//		System.out.println("4. Get Contact By Name");
//		System.out.println("5. Sort By Name");
//		System.out.println("6. Sort By City");
//		System.out.println("7. Sort By State");
//		System.out.println("8. Sort By Zip");
//		
//		System.out.println("9. Get Address Book");
//		System.out.println("10. Search Person By City");
//		System.out.println("11. Search Person By State");
//		System.out.println("12. Count By City");
//		System.out.println("13. Count by State");
//	}
//	public void userInputHandler() {
//		Scanner sc = new Scanner(System.in);
//	}
//	public static void main(String[] args) {
//		System.out.println("!!!!!!!! Welcome to Address Book !!!!!!!");
//		AddressBook addressBook1 = new AddressBook("AddressGLA");
//		Contacts contact0 = new Contacts("hemant", "kaushik", "Goverdhan", "Goverdhan", "U.P", 281502, 1876543210,
//				"hemantkaushik@gmail.com");
//		Contacts contact1 = new Contacts("hemant1", "kaushik1", "Near-Goverdhan", "mathura", "U.P", 281502,
//				1876543210, "hemantkaushik@gmail.com");
//		Contacts contact2 = new Contacts("hemant2", "kaushik2", "Near-Goverdhan", "Goverdhan", "M.P", 281502,
//				1876543210, "hemantkaushik@gmail.com");
//		addressBook1.addContact(contact0);
//		addressBook1.addContact(contact1);
//		addressBook1.addContact(contact2);
//		addressBook1.editContact("hemant1", "kaushik1", "mathura", "mathura", "M.P", 281511, 1876542222,
//				"kaushik@gmail.com");
//		addressBook1.deleteContact("hemant2", "kaushik2");
//		addressBook1.displayAddressBook();
//		
//		// Add Address book in ABS
//		AddressBookSystem addressBookSystem = new AddressBookSystem();
//		addressBookSystem.addAddressBook(addressBook1);
//		addressBookSystem.addToCityMap(contact0);
//		addressBookSystem.addToCityMap(contact1);
//		addressBookSystem.addToCityMap(contact2);
//		addressBookSystem.addToStateMap(contact0);
//		addressBookSystem.addToStateMap(contact1);
//		addressBookSystem.addToStateMap(contact2);
//		addressBookSystem.searchPersonByCity("mathura");
//		addressBookSystem.searchPersonByCity("Goverdhan");
//		addressBookSystem.searchPersonByState("U.P");
//
//		
//
//		
//
//
//	}
//}
