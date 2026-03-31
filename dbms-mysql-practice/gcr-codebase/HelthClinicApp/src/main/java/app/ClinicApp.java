package app;

import dao.*;
import model.Patient;

public class ClinicApp {

    public static void main(String[] args) throws Exception {

        Patient p = new Patient(
            "hemant","1999-06-11",
            "9876543220","hemant@gmail.com",
            "Delhi","A+"
        );
        PatientDAO.register(p);

        PatientDAO.update(2,"Noida","AB+");

        PatientDAO.searchByName("hemant");

        AppointmentDAO.book(2,3,"2024-02-10","10:30:00");

        VisitDAO.recordVisit(1,"Fever","Rest advised");

        BillingDAO.generateBill(1,500);

        BillingDAO.recordPayment(1,"CASH");
    }
}
