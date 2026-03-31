package hospitalCare;

import java.util.ArrayList;
import java.util.List;

public class HospitalManager {
	List<Patient> patientList = new ArrayList<>();
	public void  addPatient(Patient p) {
		patientList.add(p);
		System.out.println(p.name+" admitted");
	}
	public void printAllPatients() {
		System.out.println("Patients: ");
		for(Patient patient: patientList) {
			patient.printDetails();
		}
	}
	public void printTotalBill() {
		double sum =0;
		for(Patient patient: patientList) {
			sum+=patient.calculateBill();
		}
		System.out.printf("Total Bill: %.2f\n", sum);
	}
}
