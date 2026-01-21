package com.jsonprectice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import java.io.File;

import java.io.InputStream;

public class EmailValidator {

	public static void main(String[] args) {
		try {
			ObjectMapper mapper = new ObjectMapper();

			JsonNode schemaNode = mapper.readTree(new File("schema.json"));

			JsonSchemaFactory factory = JsonSchemaFactory.byDefault();

			JsonSchema schema = factory.getJsonSchema(schemaNode);

			JsonNode jsonNode = mapper.readTree(new File("user.json"));

			ProcessingReport report = schema.validate(jsonNode);

			if (report.isSuccess()) {
				System.out.println("Email is valid");
			} else {
				System.out.println("Email is invalid");
				System.out.println(report);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
