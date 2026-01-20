package io_Sprogramming_practice;
import java.io.*;

public class ValidateCSV {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("employees.csv"));

        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        String phoneRegex = "^[0-9]{10}$";

        br.readLine();

        String line;
        int rowNumber = 1;

        while ((line = br.readLine()) != null) {
            rowNumber++;
            String[] data = line.split(",");

            String email = data[3];
            String phone = data[4];

            boolean valid = true;
            String error = "";

            if (!email.matches(emailRegex)) {
                valid = false;
                error += "Invalid Email ";
            }

            if (!phone.matches(phoneRegex)) {
                valid = false;
                error += "Invalid Phone ";
            }

            if (!valid) {
                System.out.println(
                        "Row " + rowNumber + " Error: " + error + "-> " + line
                );
            }
        }

        br.close();
    }
}
