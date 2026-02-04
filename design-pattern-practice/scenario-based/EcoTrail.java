import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Trail {
	private String trailId;
	private String name;
	private String region;
	private String difficulty;
	private int hikeCount;

	public Trail(String trailId, String name, String region, String difficulty, int hikeCount) {
		this.trailId = trailId;
		this.name = name;
		this.region = region;
		this.difficulty = difficulty;
		this.hikeCount = hikeCount;
	}

	public String getTrailId() {
		return trailId;
	}

	public void setTrailId(String trailId) {
		this.trailId = trailId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public int getHikeCount() {
		return hikeCount;
	}

	public void setHikeCount(int hikeCount) {
		this.hikeCount = hikeCount;
	}
}

class TrailUtil {
	private List<Trail> trailList = new ArrayList<>();

	public List<Trail> getTrailList() {
		return trailList;
	}

	public void setTrailList(List<Trail> trailList) {
		this.trailList = trailList;
	}

	public void addTrailRecord(Trail trail) {
		trailList.add(trail);
	}

	public Trail getTrailById(String trailId) {
		for (Trail trail : trailList) {
			if (trail.getTrailId().equals(trailId)) {
				return trail;
			}
		}
		return null;
	}

	public HashSet<Trail> getMostHikedTrails() {
		HashSet<Trail> set = new HashSet<>();
		int max = 0;
		for (Trail trail : trailList) {
			max = Math.max(max, trail.getHikeCount());
		}
		for (Trail trail : trailList) {
			if (trail.getHikeCount() == max) {
				set.add(trail);
			}
		}
		return set;

	}

	public Map<String, Integer> groupHikeCountsByRegion() {
		Map<String, Integer> map = new HashMap<>();
		for (Trail trail : trailList) {

			map.put(trail.getRegion(), map.getOrDefault(map, 0) + trail.getHikeCount());
		}
		return map;
	}

	public Map<String, List<Trail>> groupTrailsByDifficulty() {
		Map<String, List<Trail>> map = new HashMap<>();
		List<Trail> hard = new ArrayList<>();
		List<Trail> medium = new ArrayList<>();
		List<Trail> easy = new ArrayList<>();

		for (Trail trail : trailList) {
			if (trail.getDifficulty().equals("Hard")) {

				hard.add(trail);
			} else if (trail.getDifficulty().equals("Medium")) {
				medium.add(trail);
			} else {
				easy.add(trail);
			}
		}
		map.put("Hard", hard);
		map.put("Medium", medium);
		map.put("Easy", easy);
		return map;
	}

	public boolean updateHikeCount(String trailId, int additionalHikes) {
		for (Trail trail : trailList) {
			if (trail.getTrailId().equals(trailId)) {
				trail.setHikeCount(trail.getHikeCount() + additionalHikes);
				return true;
			}

		}
		return false;
	}

	public List<Trail> filterTrails(String region, String difficulty) {
		List<Trail> ll = new ArrayList<>();
		for (Trail trail : trailList) {
			if (trail.getRegion().equals(region) && trail.getDifficulty().equals(difficulty)) {
				ll.add(trail);
			}
		}

		return ll;
	}

	public Map<String, List<Trail>> getTopTrailsByRegion(int n) {

		Map<String, List<Trail>> regionMap = new HashMap<>();

		// Step 1: Group trails by region
		for (Trail trail : trailList) {
			regionMap.computeIfAbsent(trail.getRegion(), k -> new ArrayList<>()).add(trail);
		}

		// Step 2: Sort each region & pick top N
		for (Map.Entry<String, List<Trail>> entry : regionMap.entrySet()) {

			List<Trail> list = entry.getValue();

			// Sort by hikeCount desc, then difficulty
			Collections.sort(list, new Comparator<Trail>() {
				@Override
				public int compare(Trail t1, Trail t2) {

					int cmp = Integer.compare(t2.getHikeCount(), t1.getHikeCount());

					if (cmp != 0) {
						return cmp;
					}

					return t1.getDifficulty().compareTo(t2.getDifficulty());
				}
			});

			// Keep only top N
			if (list.size() > n) {
				entry.setValue(new ArrayList<>(list.subList(0, n)));
			}
		}

		return regionMap;
	}

	public Map<String, String> getDifficultyStats() {
		Map<String, String> map = new HashMap<>();
		int cntEasy = 0;
		int cntMedium = 0;
		int cntHard = 0;
		int hikeEasy = 0;
		int hikeMedium = 0;
		int hikeHard = 0;
		for (Trail trail : trailList) {
			if (trail.getDifficulty().equals("Easy")) {
				cntEasy++;
				hikeEasy += trail.getHikeCount();

			} else if (trail.getDifficulty().equals("Medium")) {
				cntMedium++;
				hikeMedium += trail.getHikeCount();
			} else {
				cntHard++;
				hikeHard += trail.getHikeCount();
			}
		}
		String easy = ("count=" + cntEasy + ", totalHikes=" + hikeEasy + ", averageHike=" +( cntEasy==0?0:hikeEasy / cntEasy));
		String medium = ("count=" + cntMedium + ", totalHikes=" + hikeMedium + ", averageHike="
				+(cntMedium==0?0: hikeMedium / cntMedium));
		String hard = ("count=" + cntHard + ", totalHikes=" + hikeHard + ", averageHike=" + (cntHard==0?0: hikeHard / cntHard));
		map.put("Easy", easy);
		map.put("Medium", medium);
		map.put("Hard", hard);
		return map;

	}

	public void display(Trail trail) {
		System.out.println(trail.getTrailId() + " | " + trail.getName() + " | " + trail.getRegion() + " | "
				+ trail.getDifficulty() + " | " + trail.getHikeCount() + " hikes");

	}
}

public class EcoTrail {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("=====Welcome to EcoTrail=====");
		TrailUtil trailUtil = new TrailUtil();
		while (true) {
			System.out.println("\nAvailable region:\n"
					+ "Himalayas\n"
					+ "Sahyadri\n"
					+ "RockyMountains");
			System.out.println("Difficulty: Easy,Medium,Hard");
			System.out.println("\n  1: Add Trail Record\n" + " 2: Retrieve Trail Detail by ID\n"
					+ " 3: Retrieve Most-Hiked Trails\n" + " 4: Region-wise Hike Counts\n"
					+ " 5: Group Trails by Difficulty\n" + " 6: Update Hike Count by Trail ID\n"
					+ " 7: Filter Trails by Region and Difficulty\n" + " 8: Top-N Trails per Region\n"
					+ " 9: Difficulty Statistics\n" + " 10: Exit\n");
			switch (sc.nextInt()) {
			case 1:
				System.out.print("Enter number of trails: ");
				int n = sc.nextInt();
				sc.nextLine();
				System.out.println("Input each trail as 'trailId:name:region:difficulty:hikeCount'");
				for (int i = 0; i < n; i++) {
					String t = sc.nextLine();
					String[] str = t.split(":");
					Trail trail = new Trail(str[0], str[1], str[2], str[3], Integer.parseInt(str[4]));
					trailUtil.addTrailRecord(trail);
				}
				break;
			case 2:
				System.out.print("Enter the id of trail: ");
				Trail trail = trailUtil.getTrailById(sc.next());
				if (trail != null) {

					trailUtil.display(trail);
				} else {
					System.out.println("Not found this id");
				}
				break;
			case 3:
				System.out.println("Most hiked trails are: ");
				HashSet<Trail> set = trailUtil.getMostHikedTrails();

				for (Trail t : set) {
					trailUtil.display(t);
				}
				break;
			case 4:
				System.out.println("Region-wise hike counts");
				Map<String, Integer> map = trailUtil.groupHikeCountsByRegion();

				for (Map.Entry<String, Integer> entry : map.entrySet()) {
					System.out.println(entry.getKey() + " : " + entry.getValue() + " hikes");
				}
				break;
			case 5:
				System.out.println("Trails grouped by difficulty");
				Map<String, List<Trail>> groupDiff = trailUtil.groupTrailsByDifficulty();
				for (Map.Entry<String, List<Trail>> entry : groupDiff.entrySet()) {
					System.out.println(entry.getKey());
					for (Trail tr : entry.getValue())
						trailUtil.display(tr);

					System.out.println();
				}
				break;
			case 6:
				System.out.println("Enter Trail Id to update hikes and additional hikes");
				String id = sc.next();
				int add = sc.nextInt();
				boolean flag = trailUtil.updateHikeCount(id, add);
				if (flag) {
					System.out.println("Updated " + id + " by " + add + " hikes");
					trailUtil.display(trailUtil.getTrailById(id));
				} else {
					System.out.println("Id not found");
				}
				break;
			case 7:
				System.out.println("Filter trails, Enter region and difficulty");
				String region = sc.next();
				String difficulty = sc.next();
				List<Trail> ll = trailUtil.filterTrails(region, difficulty);
				for (Trail tra : ll) {
					trailUtil.display(tra);
				}
				break;
			case 8:
				System.out.print("Enter the top n number trails: ");
				int num = sc.nextInt();
				System.out.println("Top " + num + " trails per region");
				Map<String, List<Trail>> topN = trailUtil.getTopTrailsByRegion(num);
				for (Map.Entry<String, List<Trail>> entry : topN.entrySet()) {
					System.out.println(entry.getKey());
					for (Trail tr : entry.getValue())
						trailUtil.display(tr);

					System.out.println();
				}
				break;
			case 9:
				Map<String, String> difficultyStats = trailUtil.getDifficultyStats();
				for (Map.Entry<String, String> entry : difficultyStats.entrySet()) {
					System.out.println(entry.getKey() + " : " + entry.getValue() + " hikes");
				}
				break;
			case 10:
				System.out.print("Exiting.....");
				System.exit(0);
			default:
				System.out.println("Invalid choice. Please try again.");

			}
		}
	}
}
