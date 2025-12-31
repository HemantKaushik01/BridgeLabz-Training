import java.util.*;
public class DistinctCharacter {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter string with duplicates : ");
		String str = input.next();
		StringBuilder sb = new StringBuilder("");
		HashSet<Character> set = new HashSet<>();
		
		for(char ch : str.toCharArray()) {
			if(!set.contains(ch)) {
				sb.append(ch);
				set.add(ch);
			}
		}
		
		System.out.println(sb.toString());
	
	}
}