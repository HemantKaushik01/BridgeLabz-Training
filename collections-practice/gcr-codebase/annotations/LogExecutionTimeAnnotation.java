package annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.reflect.Method;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {}

class Calculator{
	@LogExecutionTime
	public void compute() {
		for(int i=0;i<500000;i++) {
			
		}
	}
}
public class LogExecutionTimeAnnotation {

	public static void main(String[] args) throws Exception {
		Calculator cal = new Calculator();
		Method m = Calculator.class.getMethod("compute");		
		if(m.isAnnotationPresent(LogExecutionTime.class)) {
			long start = System.nanoTime();
			m.invoke(cal);
			long end = System.nanoTime();
			System.out.print("Execution time: "+(end -start)+" ns");
		}

	}

}
