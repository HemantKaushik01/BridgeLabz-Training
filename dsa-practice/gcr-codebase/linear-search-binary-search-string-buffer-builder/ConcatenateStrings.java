import java.util.*;
public class ConcatenateStrings {

	public static void main(String[] args) {
		String arr[] = {"Anuj", "is","not", "a","Student","of","GLA","University"};
		StringBuffer str =new StringBuffer();
		for(int i=0;i<arr.length;i++) {
			
			str.append(arr[i]);
			 if (i < arr.length - 1) { 
	                str.append(" ");
	            }
		}
		System.out.print(str);
 
	}

}
