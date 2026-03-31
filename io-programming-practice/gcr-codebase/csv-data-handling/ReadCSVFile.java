package io_programming_practice;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSVFile {
    public static void main(String[] args) {
    	String path = "src/main/java/io_Sprogramming_practice/top_100_linkedin_companies_2026.csv";
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;
            while((line = br.readLine()) != null){
                String[] values = line.split(",");
                System.out.println("Rank: " + values[0] + ", Company: " + values[1] + ", Followers: " + values[2]);
            }
        } catch (IOException e) {
            
            e.printStackTrace();
        }
    }
}
