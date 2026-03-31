package com.jsonprectice;

import org.json.JSONArray;
import org.json.JSONObject;

public class StudentObject {

	public static void main(String[] args) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "Rohit");
		jsonObject.put("age", 25);
		JSONArray subjects = new JSONArray();

		subjects.put("English");
		subjects.put("science");
		subjects.put("Maths");
		jsonObject.put("Student", subjects);
		System.out.print(jsonObject.toString());
	}

}
