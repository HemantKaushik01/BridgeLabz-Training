package hospitalCare;

public abstract class Patient {
	protected String patientId;
	protected String name;
	protected int age;
	protected int days;
	public Patient(String patientId, String name, int age, int days) {
		this.patientId= patientId;
		this.name= name;
		this.age=age;
		this.days=days;
	}
	
	
	abstract double calculateBill();
	abstract void printDetails();
	
}
