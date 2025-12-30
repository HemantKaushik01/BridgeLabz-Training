import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int marks[]= {12,3,45,9,0,-8,3,-6,29};
		int n=marks.length;
		System.out.println("Students marks in unsorted order:");
		System.out.println(Arrays.toString(marks));
		System.out.println("\n");
		for(int i=0;i<n;i++) {
			boolean swapped = false;
			for(int j=0;j<n-1-i;j++) {
				if(marks[j]>marks[j+1]) {
					int temp=marks[j];
					marks[j]=marks[j+1];
					marks[j+1]=temp;
					swapped=true;
				}
				
			}
			if(!swapped) 
				break;
		}
		System.out.println("Students marks in ascending order : ");
		System.out.println(Arrays.toString(marks));


	}

}
