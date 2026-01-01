import java.util.ArrayList;
import java.util.List;

public class SortingLargeData {
	public static void main(String[] args) {
		int arr[]= {73, 12, 45, 33, 90, 2, 88, 27, 59, 61,
                6, 99, 38, 25, 77, 46, 1, 84, 53, 14,
                67, 19, 36, 82, 7, 48, 66, 97, 35, 100,
                23, 17, 60, 5, 79, 94, 20, 70, 11, 41,
                43, 10, 32, 4, 96, 24, 30, 21, 56, 9};
		
		System.out.println("Bubble sort time: "+ bubbleSort(arr));
		System.out.println("Merge sort time: "+ mergeSort(arr,0,arr.length-1));

		System.out.println("Quick sort time: "+ quickSort(arr,0,arr.length-1));


	}
	public static long bubbleSort(int[] arr) {
		long startTime = System.nanoTime();
		for(int i=0;i<arr.length;i++) {
			boolean swapped = false;
			for(int j=0;j<arr.length-1-i;j++) {
				if(arr[j]>arr[j+1]) {
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					swapped=true;
				}
				
			}
			if(!swapped) 
				break;
		}
		long endTime = System.nanoTime();
	     return endTime - startTime;
	}
	public static long mergeSort(int[] arr,int st,int end) {
		long startTime = System.nanoTime();
		if(st<end) {
			int mid = st+ (end-st)/2;
			mergeSort(arr,st,mid);
			mergeSort(arr,mid+1,end);
			
			merge(arr,st,mid,end);
		}
		long endTime = System.nanoTime();
	     return endTime - startTime;
	}
	public static void merge(int[] arr, int st,int mid,int end) {
		List<Integer> ll = new ArrayList<>();
		int i=st,j=mid+1;
		while(i<=mid && j<=end) {
			if(arr[i]<=arr[j]) {
				ll.add(arr[i]);
				i++;
			}
			else {
				ll.add(arr[j]);
				j++;
			}
		}
		while(i<=mid) {
			ll.add(arr[i]);
			i++;
		}
		while(j<=end) {
			ll.add(arr[j]);
			j++;
		}
		
		for(int idx=0;idx<ll.size();idx++) {
			arr[idx+st]=ll.get(idx);
		}
	}
	public static long quickSort(int[] arr, int low, int high) {
		long startTime = System.nanoTime();
		if(low<high) {
			int pi = partition(arr,low,high);
			quickSort(arr,low,pi-1);
			quickSort(arr,pi+1,high);
		}
		long endTime = System.nanoTime();
	     return endTime - startTime;
	}
	public static int partition(int[] arr,int low,int high) {
		int pivot =arr[high];
		int i=low-1;
		for(int j=low;j<high;j++) {
			if(arr[j]<pivot) {
				i++;
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
		int temp = arr[i+1];
		arr[i+1]=arr[high];
		arr[high]=temp;
		return i+1;
	}
}
