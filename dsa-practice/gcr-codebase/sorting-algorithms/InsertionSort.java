import java.util.*;
public class InsertionSort {

	public static void main(String[] args) {
		System.out.println("EmployeeId in unsorted order:");

		int employeeId[]= {21,43,2,4,20,55,44,80,69,38};
		System.out.print(Arrays.toString(employeeId));

		int n=employeeId.length;
		for(int i=0;i<n;i++) {
			int j=i;
			while(j>0 && employeeId[j-1]>employeeId[j]) {
				int temp =employeeId[j-1];
				employeeId[j-1] =employeeId[j];
				employeeId[j]=temp;
				j--;
			}
		}
		System.out.println("\nEmployeeId  in ascending order : ");

		System.out.print(Arrays.toString(employeeId));

	}

}
