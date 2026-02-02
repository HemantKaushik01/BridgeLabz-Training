import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class CreatorStats {
	String creatorName;
	double[] weeklyLikes;

	public CreatorStats(String creatorName, double[] weeklyLikes) {
		this.creatorName = creatorName;
		this.weeklyLikes = weeklyLikes;
	}

}

public class Program {
	public static List<CreatorStats> engagementBoard = new ArrayList<>();

	public void registerCreator(CreatorStats record) {
		if (record != null)
			engagementBoard.add(record);
	}

	public Map<String, Integer> getTopPostCounts(List<CreatorStats> records, double threshold) {
		Map<String, Integer> result = new HashMap<>();
		if (records == null || records.isEmpty()) {
			return result;
		}
		for (CreatorStats creator : records) {
			int count = 0;

			for (double likes : creator.weeklyLikes) {
				if (likes >= threshold) {
					count++;
				}
			}

			if (count > 0) {
				result.put(creator.creatorName, count);
			}
		}

		return result;
	}

	public double CalculateAverageLikes() {
		double totalLikes = 0;
		int totalWeeks = 0;

		for (CreatorStats creator : engagementBoard) {
			for (double likes : creator.weeklyLikes) {
				totalLikes += likes;
				totalWeeks++;
			}
		}
		return totalWeeks == 0 ? 0 : totalLikes / totalWeeks;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Program program = new Program();
		int choice;

		do {
			System.out.println("\n1. Register Creator");
			System.out.println("2. Get Top Performing Posts");
			System.out.println("3. Calculate Average Likes");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");

			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {

			case 1:
				System.out.print("Enter Creator Name: ");
				String name = sc.nextLine();

				double[] likes = new double[4];
				for (int i = 0; i < 4; i++) {
					System.out.print("Enter likes for Week " + (i + 1) + ": ");
					likes[i] = sc.nextDouble();
				}

				CreatorStats creator = new CreatorStats(name, likes);
				program.registerCreator(creator);

				System.out.println("Creator registered successfully");
				break;

			case 2:
				System.out.print("Enter like threshold: ");
				double threshold = sc.nextDouble();

				Map<String, Integer> topPosts = program.getTopPostCounts(engagementBoard, threshold);

				if (topPosts.isEmpty()) {
					System.out.println("No top-performing posts this week");
				} else {
					for (Map.Entry<String, Integer> entry : topPosts.entrySet()) {
						System.out.println(entry.getKey() + " : " + entry.getValue());
					}
				}
				break;

			case 3:
				double average = program.CalculateAverageLikes();
				System.out.println("Overall average weekly likes: " + average);
				break;

			case 4:
				System.out.println("Logging off ");
				break;

			default:
				System.out.println("Invalid choice. Try again.");
			}

		} while (choice != 4);

	}

}
