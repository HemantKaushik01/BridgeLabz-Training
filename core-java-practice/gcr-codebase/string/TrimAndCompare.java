package string;

import java.util.Scanner;

class TrimAndCompare {
	static int[] trimIndexPoint(String str) {
		int startPoint = 0;
		int endpoint = str.length() - 1;
		for (int i = 0; i < str.length(); i++) {
			if ((str.charAt(i)) == ' ') {
				startPoint++;
				continue;
			} else {
				break;
			}
		}
		for (int i = str.length() - 1; i >= 0; i--) {
			if ((str.charAt(i)) == ' ') {
				endpoint--;
				continue;
			} else {
				break;
			}
		}
		int[] indexPoint = new int[2];
		indexPoint[0] = startPoint;
		indexPoint[1] = endpoint;
		return indexPoint;
	}

	static String subStringAfterTrim(String str) {
		int[] indexPoint = trimIndexPoint(str);
		int startPoint = indexPoint[0];
		int endpoint = indexPoint[1];
		String resultStr = "";
		for (int i = startPoint; i <= endpoint; i++) {
			resultStr += str.charAt(i);
		}
		return resultStr;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter String :");
		String str = input.nextLine();
		String userTrimmedStr = subStringAfterTrim(str);
		str = str.trim();
		if (str.equals(userTrimmedStr)) {
			System.out.println(
					"Both User method and Built-in method gives same String after trimming leading and trailing spaces and is "
							+ userTrimmedStr);
		} else {
			System.out.println("Invalid");
		}
	}
}