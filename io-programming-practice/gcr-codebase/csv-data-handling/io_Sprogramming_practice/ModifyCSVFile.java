package io_Sprogramming_practice;
import java.io.*;

public class ModifyCSVFile {
    public static void main(String[] args) throws IOException {
    	String path = "src/main/java/io_Sprogramming_practice/employee.csv";

        BufferedReader br = new BufferedReader(new FileReader(path));
        FileWriter writer = new FileWriter("updated_employees.csv");
        String line = br.readLine();
        writer.write(line + "\n");
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");

            if (data[2].equals("IT")) {
                double salary = Double.parseDouble(data[3]);
                salary = salary + (salary * 0.10);
                writer.write(data[0] + "," + data[1] + "," + data[2] + "," + salary + "\n");
            } else {
                writer.write(line + "\n");
            }
        }
      
    }
}
