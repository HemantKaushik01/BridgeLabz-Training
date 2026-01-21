package com.jsonprectice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CsvToJson {

    public static void main(String[] args) {

        try {
            ObjectMapper mapper = new ObjectMapper();

            ArrayNode jsonArray = mapper.createArrayNode();

            InputStream input =
                    CsvToJson.class
                            .getClassLoader()
                            .getResourceAsStream("users.csv");

            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(input));

            String headerLine = reader.readLine();
            String[] headers = headerLine.split(",");

            String line;
            while ((line = reader.readLine()) != null) {

                String[] values = line.split(",");

                ObjectNode jsonObject = mapper.createObjectNode();

                for (int i = 0; i < headers.length; i++) {
                    jsonObject.put(headers[i], values[i]);
                }
                jsonArray.add(jsonObject);
            }

            System.out.println(
                    mapper.writerWithDefaultPrettyPrinter()
                          .writeValueAsString(jsonArray)
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
