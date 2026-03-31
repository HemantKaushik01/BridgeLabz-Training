package com.jsonprectice;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CensorApp {
	private static String maskTeam(String team) {
		String firstWord = team.split(" ")[0];
		return firstWord + " ***";
	}

	public static void censorJson() throws Exception {

		ObjectMapper mapper = new ObjectMapper();

		InputStream input = CensorApp.class.getClassLoader().getResourceAsStream("ipl.json");

		ArrayNode matches = (ArrayNode) mapper.readTree(input);

		for (JsonNode match : matches) {
			ObjectNode obj = (ObjectNode) match;

			obj.put("team1", maskTeam(obj.get("team1").asText()));
			obj.put("team2", maskTeam(obj.get("team2").asText()));
			obj.put("winner", maskTeam(obj.get("winner").asText()));

			obj.put("player_of_match", "REDACTED");
		}

		mapper.writerWithDefaultPrettyPrinter().writeValue(Paths.get("censored_ipl.json").toFile(), matches);
	}

	public static void censorCsv() throws Exception {

		InputStream input = CensorApp.class.getClassLoader().getResourceAsStream("match_data.csv");

		BufferedReader reader = new BufferedReader(new InputStreamReader(input));

		ArrayList<String> lines = new ArrayList<String>();

		String header = reader.readLine();
		lines.add(header);

		String line;
		while ((line = reader.readLine()) != null) {

			String[] data = line.split(",");

			data[1] = maskTeam(data[1]);
			data[2] = maskTeam(data[2]);
			data[5] = maskTeam(data[5]);
			data[6] = "REDACTED";

			lines.add(String.join(",", data));
		}

		Files.write(Paths.get("censored_ipl.csv"), lines);
	}

	public static void main(String[] args) {
		try {
			censorJson();
			censorCsv();
			System.out.println("IPL data censored successfully!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
