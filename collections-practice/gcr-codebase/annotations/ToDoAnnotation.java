package annotations;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo{
	String task();
	String assignedTo();
	String priority() default "MEDIUM";
}
class Project{
	@Todo(task="Implement login", assignedTo="Kaushik", priority="HIGH")
	public void login() {}
	
	@Todo (task="Fix logout bug", assignedTo ="hemant")
	public void logout() {}
	
}

public class ToDoAnnotation {
	public static void main(String[] args) throws Exception{
		for(Method m : Project.class.getDeclaredMethods()) {
			if(m.isAnnotationPresent(Todo.class)) {
				Todo todo = m.getAnnotation(Todo.class);
				System.out.println("Name of method: "+m.getName());
				System.out.println("Task: "+ todo.task());
				System.out.println("Assigned to: "+ todo.assignedTo());
				System.out.println("Priority: "+todo.priority());
				System.out.println("------------------------------");
			}
		}
	}
}
