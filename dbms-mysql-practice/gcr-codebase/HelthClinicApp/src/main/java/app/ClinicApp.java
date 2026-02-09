package app;

import dao.*;
import model.Patient;

public class ClinicApp {

    public static void main(String[] args) throws Exception {

        // 1. Register Patient
        Patient p = new Patient(
            "hemant","1999-06-11",
            "9876543220","hemant@gmail.com",
            "Delhi","A+"
        );
        PatientDAO.register(p);

        // 2. Update Patient (use correct patient_id from DB)
        PatientDAO.update(2,"Noida","AB+");

        // 3. Search Patient
        PatientDAO.searchByName("hemant");

        // 4. Book Appointment (USE REAL doctor_id)
        AppointmentDAO.book(2,3,"2024-02-10","10:30:00");

        // 5. Record Visit (appointment_id from DB)
        VisitDAO.recordVisit(1,"Fever","Rest advised");

        // 6. Generate Bill
        BillingDAO.generateBill(1,500);

        // 7. Record Payment
        BillingDAO.recordPayment(1,"CASH");
    }
}
