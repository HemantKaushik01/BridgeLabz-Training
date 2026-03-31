package com.in.addressbook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddressBookSystem {
	Map<String,AddressBook> addressBooks ;
	Map<String,List> cityPersonMap;
	Map<String, List> statePersonMap;
	public AddressBookSystem() {
		this.addressBooks = new HashMap<>();
		this.cityPersonMap = new HashMap<>();
		this.statePersonMap  = new HashMap<>();
	}

	public void addAddressBook(AddressBook addressBook) {
		String addressBookName = addressBook.getAddressBookName();
		if(!addressBooks.containsKey(addressBookName)) {
			
			addressBooks.put(addressBookName,addressBook );
			
		}
		else {
			System.out.print("This address Book is already present");
		}
		
	}
	public void addToCityMap(Contacts contact) {
		String city = contact.getCity();
		if(cityPersonMap.containsKey(city)) {
			cityPersonMap.get(city).add(contact);
		}
		else {
			List<Contacts> contactList = new ArrayList<>();
			contactList.add(contact);
			cityPersonMap.put(city, contactList);
			
		}
		
	}
	public void addToStateMap(Contacts contact) {
	    String state = contact.getState();

	    if (statePersonMap.containsKey(state)) {
	        statePersonMap.get(state).add(contact);
	    } else {
	        List<Contacts> contactList = new ArrayList<>();
	        contactList.add(contact);
	        statePersonMap.put(state, contactList);
	    }
	}

	public AddressBook getAddressBook(String addressBookName) {
		if(addressBooks.containsKey(addressBookName)) {
			return addressBooks.get(addressBookName);
		}
		System.out.print("This name addtessBook is not present/avaliable");
		return null;
		
	}
	public void searchPersonByCity(String cityName) {
		System.out.println("//////////////// Search by city");
		List<Contacts> list = cityPersonMap.get(cityName);

	    if (list == null || list.isEmpty()) {
	        System.out.println("No contacts found in " + cityName);
	        return;
	    }

	    for(Contacts contact: list) {
	    	contact.displayContect();
	    }
		
	}
	public void searchPersonByState(String cityName) {
		System.out.println("//////////////// Search by state");

		List<Contacts> list = statePersonMap.get(cityName);

	    if (list == null || list.isEmpty()) {
	        System.out.println("No contacts found in " + cityName);
	        return;
	    }

	    for(Contacts contact: list) {
	    	contact.displayContect();
	    }
		
	}
	public int countByCity(String city) {
	    return cityPersonMap.getOrDefault(city, List.of()).size();
	}

	public int countByState(String state) {
	    return statePersonMap.getOrDefault(state, List.of()).size();
	}

}
