package string;

import java.util.*;
class CharactersUsingToCharArray{
	public static void main(String[] args){
		Scanner input =new Scanner(System.in);
		System.out.print("Enter the value of String  : ");  
		String str = input.next();
		char stringArray[] = StrArray(str);
		// compare sub string
		System.out.println("compare both character string array: " );
		char stringToCharArray[] =usingToCharArray(str);
		Boolean flag =true;
		for(int i=0;i<str.length();i++){
			if(stringArray[i] != stringToCharArray[i]){
				flag =false;
				break;		
			}
			
		}
		System.out.print(flag);
	}
	public static char[] StrArray(String str){
		char[] array = new char[str.length()];
		for(int i=0;i<str.length();i++){
			array[i]=str.charAt(i);
		}
		return array ;
	}
	public static char[]  usingToCharArray(String str){	
		return str.toCharArray();
		
	}
}