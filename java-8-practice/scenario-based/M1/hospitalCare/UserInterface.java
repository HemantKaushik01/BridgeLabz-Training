package hospitalCare;

import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HospitalManager obj = new HospitalManager();

        int n = Integer.parseInt(sc.nextLine().trim());

        while (n-- > 0) {
            String[] str = sc.nextLine().split(":");
            String type = str[0];
            String id = str[1];

            // ✅ Validate ID first, regardless of type
            if (!id.matches("^HC-\\d{4}[A-Z]$")) {
                System.out.println("Invalid ID");
                return;
            }

            if (type.equals("General")) {
                obj.addPatient(new GeneralPatient(id, str[2],
                        Integer.parseInt(str[3]),
                        Integer.parseInt(str[4]), str[5]));


            } else if (type.equals("ICU")) {
                obj.addPatient(new ICUPatient(id, str[2],
                        Integer.parseInt(str[3]),
                        Integer.parseInt(str[4]), str[5],
                        Integer.parseInt(str[6])));

            }
        }

        System.out.println();
        obj.printAllPatients();
        System.out.println();
        obj.printTotalBill();

        sc.close();
    }
}