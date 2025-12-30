import java.util.*;
public class MergeSort {

	public static void main(String[] args) {
		System.out.println("Book Price in unsorted order:");

		int bookPrice[]= {21,43,2,4,20,55,44,80,69,38};
		System.out.print(Arrays.toString(bookPrice));
		recursive(bookPrice,0,bookPrice.length-1);
		System.out.println("\nBook Price in sorted order:");

		System.out.print(Arrays.toString(bookPrice));


	}
	public static void recursive(int[] arr, int st,int end) {
		if(st<end) {
			int mid = st+ (end-st)/2;
			recursive(arr,st,mid);
			recursive(arr,mid+1,end);
			
			merge(arr,st,mid,end);
		}
		
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

}
