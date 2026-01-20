package io_Sprogramming_practice;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteCSVFile {
	public static void main(String[] args) {
    	String path = "src/main/java/io_Sprogramming_practice/employee.csv";
    	try(BufferedWriter writer = new BufferedWriter(new FileWriter(path))){
    		writer.write("ID,Name,Department,Salary\n");
    		writer.write("001,Hemant,CS,1000000\n");
    		writer.write("002,Bhaskar,CS,200000\n");
    		writer.write("003,Rahul,EC,30000\n");
    		writer.write("004,Sparsh,Civil,400000\n");
    		writer.write("005,Khaniya,Civil,123435\n");
    		System.out.print("CSV file is scuccessflly written");

    		
    	}
    	catch(IOException e) {
    		e.printStackTrace();
    	}
	}
}
