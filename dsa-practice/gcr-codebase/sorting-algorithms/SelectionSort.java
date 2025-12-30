import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int arr[] = {2,5,1,8,3,5,0,4};
		System.out.println("Before Selection sort:-");
		System.out.println(Arrays.toString(arr));
		int n=arr.length;
		for(int i=0;i<n-1;i++) {
			int min =i;
			for(int j=i+1;j<n;j++) {
				if(arr[j]<arr[min]) {
					min =j;
				}
			}
			int temp = arr[i];
			arr[i]=arr[min];
			arr[min]=temp;
		}
		
		System.out.println("After Selection sort:-");
		System.out.print(Arrays.toString(arr));
	}

}
