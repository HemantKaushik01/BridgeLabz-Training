//package documentredactionengine;
//
//import java.util.Scanner;
//
//public class DocumentRedactionEngine {
//
//    public String processLine(String input) {
//
//        // Rule 1: Mask National ID
//        input = input.replaceAll("ID:[A-Z]{3}\\d{6}", "ID:XXX******");
//
//        // Rule 2: Mask Bank Account (keep last 4 digits)
//        input = input.replaceAll("ACCT-\\d{4}-\\d{4}-(\\d{4})", "ACCT---$1");
//
//        // Rule 3: Normalize repeated words
//        input = input.replaceAll("(?i)\\b(\\w+)\\b(\\s+\\1\\b)+", "$1");
//
//        // Rule 4: Fix trailing special symbols
//        input = input.replaceAll("([!?.]){3,}$", "$1");
//
//        return input;
//    }
//
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//        DocumentRedactionEngine obj = new DocumentRedactionEngine();
//
//        int n = Integer.parseInt(sc.nextLine());
//
//        while(n-- > 0) {
//            String line = sc.nextLine();
//            System.out.println(obj.processLine(line));
//        }
//
//        sc.close();
//    }
//}
package documentredactionengine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DocumentRedactionEngine {
	public String engine(String input) {
		String str[] = input.split(" ");
		List<String> finalresult = new ArrayList<>();
		String result="";
		for(int i=0;i<str.length;i++) {
			//Natinal ID
			if(str[i].matches("ID:[A-Z]{3}[0-9]{6}")) {
				finalresult.add("ID:XXX******");
			}
			else if(str[i].matches("ACCT-\\d{4}-\\d{4}-\\d{4}")) {
				finalresult.add("ACCT---"+str[i].substring(str[i].length()-4,str[i].length()));
			}
			else if (i!=0 && str[i-1].equalsIgnoreCase(str[i])) {
				continue;
			}
			else if(str[i].matches("[a-zA-Z]+[!?.]+")) {
				String mark="";
				for(int j=0;j<str[i].length();j++) {
					if(str[i].charAt(j)=='.' || str[i].charAt(j)=='?' || str[i].charAt(j)=='!') {
						mark+=str[i].charAt(j);
						break;
					}
					mark+=str[i].charAt(j);

				}
				str[i]=mark;
				
				finalresult.add(str[i]);
			}
			else {
				finalresult.add(str[i]);

			}
		}
		for(int i=0;i<finalresult.size();i++) {
			result+=finalresult.get(i);
			if(i<finalresult.size()-1) {
				result+=" ";
			}
		}
			
		return result;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DocumentRedactionEngine obj = new DocumentRedactionEngine();
		int n= Integer.parseInt(sc.nextLine());
		while(n-->0) {
			String input = sc.nextLine();
			String output= obj.engine(input);
			System.out.println(output);
		}

	}

}
