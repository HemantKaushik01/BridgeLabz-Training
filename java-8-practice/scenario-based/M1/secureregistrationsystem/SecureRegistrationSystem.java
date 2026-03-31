package secureregistrationsystem;

import java.util.Scanner;

class InvalidRegistration extends Exception{
	public InvalidRegistration(String message) {
		super(message);
	}
}
class SecureUtil{
	public boolean nameValidation(String name) throws InvalidRegistration {
		boolean isValid = name.matches("^[A-Za-z][A-Za-z0-9]{5,11}$");
		if(!isValid) {
			throw new InvalidRegistration("Invalid UserName");
		}
		return isValid;
	}
	public boolean emailValidation(String email) throws InvalidRegistration{
		boolean isValid = email.matches("^[a-z]{3,10}@techcorp\\.com$");
		if(!isValid) {
			throw new InvalidRegistration("Invalid Email");
			
		}
		return isValid;
	}
	public boolean phoneValidation(String phone) throws InvalidRegistration {
		boolean isValid = phone.matches("^\\+91[6-9][0-9]{9}$");
		if(!isValid) {
			throw new InvalidRegistration("Invalid phone");
		}
		return isValid;
	}
	public boolean employeeIdValidation(String employeeId) throws InvalidRegistration {
		boolean isValid = employeeId.matches("^EMP-[1-9][0-9]{3}$");
		if(!isValid) {
			throw new InvalidRegistration("Invalid EmployeeId");
		}
		return isValid;
	}
	public boolean accessCodeValidation(String accessCode) throws InvalidRegistration{
		boolean isValid = accessCode.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[@#$%]).{8}$");
		if(!isValid) {
			throw new InvalidRegistration("Invalid Access Code");
		}
		return isValid;
	}
}

public class SecureRegistrationSystem {
	public static void main(String[] args) {
		SecureUtil obj = new SecureUtil();
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		sc.nextLine();
		while(n-->0) {
			try {
				
				String str[] = sc.nextLine().split("\\|");
				obj.nameValidation(str[0]);
				obj.emailValidation(str[1]);
				obj.phoneValidation(str[2]);
				obj.employeeIdValidation(str[3]);
				obj.accessCodeValidation(str[4]);
				System.out.println("Valid Registration");
			}
			catch(InvalidRegistration e) {
				System.out.println(e.getMessage());
			}			
		}
	}
	
	
}
