package stringQuestionM1;
import java.util.*;
public class StringManipulationM1 {
	public String operations(String str) {
		if(!str.contains("$")) {
			return str;
		}
		
		String result = "";
		String array[] =str.split(" ");
		for(int i=0;i<array.length;i++) {
			String add ="";
			if(array[i].startsWith("$")) {
				if(array[i].contains("UPPER")) {
					add= array[i].substring(8,array[i].length()-1);
	 				result+=add.toUpperCase();
				}
				else if(array[i].contains("LOWER")) {
					add= array[i].substring(8,array[i].length()-1);
					result+=add.toLowerCase();
				}
				else if(array[i].contains("DATE")) {
					add= array[i].substring(7,array[i].length()-1);
					add= add.substring(8,10)+"/"+add.substring(5,7)+"/"+add.substring(0,4);
					result+=add;
				}
				else if(array[i].contains("REPEAT")) {
					int num = Integer.parseInt(array[i].substring(array[i].length()-2,array[i].length()-1));
					add = array[i].substring(9,array[i].length()-3);
					for(int j=0;j<num;j++) {
						result+=add;
					}
					
				}
				else {
					result+="Invalid";
				}
			}
			else {
				result+=array[i];
			}
			if(i<array.length-1) {
				result+=" ";
			}
		}
		return result;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringManipulationM1 obj = new StringManipulationM1();
		int n=sc.nextInt();
		sc.nextLine();
		while(n-->0) {
			String str = obj.operations(sc.nextLine());
			System.out.println(str);
		}
	}
}
