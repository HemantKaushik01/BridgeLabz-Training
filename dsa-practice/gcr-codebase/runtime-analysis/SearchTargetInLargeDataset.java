import java.util.*;
public class SearchTargetInLargeDataset {
		public static void main(String[] args) {
			int arr[]= {73, 12, 45, 33, 90, 2, 88, 27, 59, 61,
                    6, 99, 38, 25, 77, 46, 1, 84, 53, 14,
                    67, 19, 36, 82, 7, 48, 66, 97, 35, 100,
                    23, 17, 60, 5, 79, 94, 20, 70, 11, 41,
                    43, 10, 32, 4, 96, 24, 30, 21, 56, 9};;
			int target=99;
			System.out.println("Linear Search time: "+ linearSearch(arr,target));
			System.out.println("Binary Search time: "+ binarySearch(arr,target));
		}
		public static long linearSearch(int[] arr,int target) {
			long startTime = System.nanoTime();
			for(int i=0;i<arr.length;i++ ) {
				if(target==arr[i]) {
					break;
				}
			}
			long endTime = System.nanoTime();
		     return endTime - startTime;
		}
		public static long binarySearch(int[] arr,int target) {
			Arrays.sort(arr);
			  int left = 0, right = arr.length - 1;
		        int first = -1;
		        long startTime = System.nanoTime();
		        while (left <= right) {
		            int mid = left + (right - left) / 2;

		            if (arr[mid] == target) {
		                break; 
		            } else if (arr[mid] < target) {
		                left = mid + 1;
		            } else {
		                right = mid - 1;
		            }
		        }
		        long endTime = System.nanoTime();
			     return endTime - startTime;

		      
		}
}
