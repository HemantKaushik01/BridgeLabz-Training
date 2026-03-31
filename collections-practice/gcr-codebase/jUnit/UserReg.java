package jUnit;

public class UserReg {
	public void registerUser(String username, String email, String password) {
		if (username == null || username.isEmpty()) 
			throw new IllegalArgumentException("Invalid username");
		if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"))
			throw new IllegalArgumentException("Invalid email");
		if (password.length() < 6)
			throw new IllegalArgumentException("Password too short");
	}
}
