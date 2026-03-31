package annotations;


import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

class SecureService {
    @RoleAllowed("ADMIN")
    public void deleteData() {
        System.out.println("Data deleted!");
    }
}


public class RoleAllowedAnnotation {

	public static void main(String[] args) throws Exception {
		String currUserRole = "ADMIN";
		SecureService service = new SecureService();
		Method m = SecureService.class.getMethod("deleteData");
		
		if(m.isAnnotationPresent(RoleAllowed.class)) {
			RoleAllowed role = m.getAnnotation(RoleAllowed.class);
			if(role.value().equals(currUserRole)) {
				m.invoke(service);
			}
			else {
				System.out.println("Access Denied");
			}
		}
		
	}

}
