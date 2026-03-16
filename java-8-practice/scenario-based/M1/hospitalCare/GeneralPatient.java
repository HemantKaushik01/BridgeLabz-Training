package hospitalCare;

public class GeneralPatient extends Patient {
	String ward;
	public GeneralPatient(String patientId, String name, int age, int days, String ward) {
		super(patientId, name,age,days);
		this.ward= ward;
	}
	public double calculateBill() {
		return days*800;
	}
	public void printDetails() {
	    System.out.println(patientId + " " + name + " " + age + " " + days + " " + ward);
	}
}
