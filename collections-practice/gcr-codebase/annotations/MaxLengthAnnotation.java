package annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Field;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class User{
	@MaxLength(10)
	String userName;
	public User(String userName) throws Exception{
		this.userName = userName;
		
		Field fl = User.class.getDeclaredField("userName");
		MaxLength maxLen = fl.getAnnotation(MaxLength.class);
		if(userName.length()>maxLen.value()) {
			throw new IllegalArgumentException("UserName too long!");
		}
		System.out.println("Name length is less then: "+userName);
	}
	
	
}
public class MaxLengthAnnotation {

	public static void main(String[] args) throws Exception {
		 User u1 = new User("Hemant");   
	    User u2 = new User("VeryLongUsername"); 

	}

}
