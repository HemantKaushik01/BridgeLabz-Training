package com.jsonprectice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.util.Iterator;
import java.util.Map;

public class MergeTwoJson {

	public static void main(String[] args) {

		try {
			ObjectMapper mapper = new ObjectMapper();

			JsonNode userJson = mapper.readTree(new File("user.json"));

			JsonNode addressJson = mapper.readTree(new File("address.json"));

			ObjectNode finalJson = mapper.createObjectNode();

			Iterator<Map.Entry<String, JsonNode>> userFields = userJson.fields();

			while (userFields.hasNext()) {
				Map.Entry<String, JsonNode> entry = userFields.next();
				finalJson.set(entry.getKey(), entry.getValue());
			}

			Iterator<Map.Entry<String, JsonNode>> addressFields = addressJson.fields();

			while (addressFields.hasNext()) {
				Map.Entry<String, JsonNode> entry = addressFields.next();
				finalJson.set(entry.getKey(), entry.getValue());
			}

			System.out.println(finalJson.toPrettyString());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
