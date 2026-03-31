package methods;

import java.util.Scanner;

public class SpringSeason {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter month (1-12): ");
		int month = scanner.nextInt();
		System.out.print("Enter day (1-31): ");
		int day = scanner.nextInt();
		SpringSeason spring = new SpringSeason();
		System.out.print("Is spring season " + spring.meth(month, day));

	}

	public boolean meth(int month, int day) {
		boolean isSpring = (month == 3 && day >= 20 && day <= 31) || (month == 4 && day >= 1 && day <= 30)
				|| (month == 5 && day >= 1 && day <= 31) || (month == 6 && day >= 1 && day <= 20);

		if (isSpring) {
			return true;
		} else {
			return false;
		}
	}
}
