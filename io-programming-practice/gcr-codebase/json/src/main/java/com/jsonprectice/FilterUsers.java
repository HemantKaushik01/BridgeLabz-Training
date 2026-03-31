package com.jsonprectice;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FilterUsers {
	public static void main(String[] args) {
		try{
			
			ObjectMapper mapper = new ObjectMapper();

			 List<User> users = mapper.readValue(
					 new File("user.json"),
	                    new TypeReference<List<User>>() {}
	            );
			 
			 for(int i=0;i<users.size();i++) {
				 User user = users.get(i);
				 if(user.getAge()>25) {
					 System.out.println("User Name: "+ user.getName()+", Age:  "+user.getAge());
				 }
			 }
			 } catch (Exception e) {
			 }
		
	}
}
