package com.in.addressbook;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class AddressBook {
	private String addressBookName;
	public List<Contacts> contacts;
	
	
	public String getAddressBookName() {
		return addressBookName;
	}


	public List<Contacts> getContacts() {
		return contacts;
	}


	public AddressBook(String addressBookName) {
		this.addressBookName = addressBookName;
		this.contacts=new ArrayList<>();
	}
	

	public void addContact(Contacts contact) {
		contacts.add(contact);
	}
	public void editContact(String firstName, String lastName, String address, String city, String state, int zip, int phone,
			String email) {
		for(int i=0;i<contacts.size();i++) {
			if(contacts.get(i).getFirstName()==firstName && contacts.get(i).getLastName()==lastName) {
				contacts.get(i).setAddress(address);
				contacts.get(i).setCity(city);
				contacts.get(i).setState(state);
				contacts.get(i).setZip(zip);
				contacts.get(i).setPhone(phone);
				contacts.get(i).setEmail(email);
			}
		}
	}
	// 🔹 Sort by First Name (Alphabetically)
	public void sortByName() {
        Collections.sort(contacts,
                Comparator.comparing(Contacts::getFirstName));
    }
	 public void sortByCity() {
	        Collections.sort(contacts,
	                Comparator.comparing(Contacts::getCity));
	    }

	    // 🔹 Sort by State
	    public void sortByState() {
	        Collections.sort(contacts,
	                Comparator.comparing(Contacts::getState));
	    }

	    // 🔹 Sort by Zip
	    public void sortByZip() {
	        Collections.sort(contacts,
	                Comparator.comparing(Contacts::getZip));
	    }
	public void deleteContact(String firstName,String lastName) {
		for(int i=0;i<contacts.size();i++) {
			if(contacts.get(i).getFirstName()==firstName && contacts.get(i).getLastName()==lastName) {
				contacts.remove(i);
			}
		}
			
	}

	public void displayAddressBook(){
		System.out.println(addressBookName);
		for(int i=0;i<contacts.size();i++) {
		contacts.get(i).displayContect();
		}

		
	}
}
