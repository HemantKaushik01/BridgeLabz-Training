package hospitalCare;

public class ICUPatient extends Patient{
	String condition;
	int nurseCount;
	public ICUPatient(String patientId, String name, int age, int days, String condition,int nurseCount) {
		super(patientId, name,age,days);
		this.condition= condition;
		this.nurseCount= nurseCount;
	}
	public double calculateBill() {
		return (days*3500) + (nurseCount*500);
	}
	public void printDetails() {
	    System.out.println(patientId + " " + name + " " + age + " " + days 
	                       + " " + condition + " " + nurseCount);
	}
}
