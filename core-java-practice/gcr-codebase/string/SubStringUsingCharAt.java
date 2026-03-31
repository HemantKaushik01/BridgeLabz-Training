package string;

import java.util.*;
class SubStringUsingCharAt{
	public static void main(String[] args){
		Scanner input =new Scanner(System.in);
		System.out.print("Enter the value of String  : ");  
		String str = input.next();
		System.out.println("Enter the start and ending value of substring: ");
		int start =input.nextInt();
		int end = input.nextInt();
		String strCharAt = substring(str, start, end);
		
		System.out.println("compare both sub string: " );
		displayFinal(str,strCharAt, start, end);
	}
	public static String substring(String str, int start, int end){
		 String newStr = "";
		for(int i=start;i<end;i++){
			newStr+=str.charAt(i);
		}
		return newStr;
	}
	public static void displayFinal (String str, String newStr, int  start , int end){	
		str = str.substring(start,end);
		System.out.println( "Both subString is  using charAt " + newStr + " and using substring() method " + str);
		if(str.equals(newStr)){
			System.out.print("true");
		}
		else{
			System.out.print("false");
		}
	}
}