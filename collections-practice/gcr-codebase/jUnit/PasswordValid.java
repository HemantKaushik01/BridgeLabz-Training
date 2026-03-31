package jUnit;

public class PasswordValid {
	public boolean isValid(String password) {
		return password.matches("^(?=.*[A-Z])(?=.*\\d).{8,}$");
	}
}
