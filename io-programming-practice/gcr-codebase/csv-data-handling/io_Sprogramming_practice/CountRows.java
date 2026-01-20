package io_Sprogramming_practice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountRows {
	public static void main(String[] args) {
    	String path = "src/main/java/io_Sprogramming_practice/top_100_linkedin_companies_2026.csv";
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;
            int count=0;
            while((line = br.readLine()) != null){
                count++;
            }
            System.out.print("The number of records is: "+count);
        } catch (IOException e) {
            
            e.printStackTrace();
        }
    }
}
