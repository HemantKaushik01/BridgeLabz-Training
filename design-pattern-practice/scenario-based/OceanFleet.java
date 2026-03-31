import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Vessel {
	private String vesselId;
	private String vesselName;
	private double averageSpeed;
	private String vesselType;

	public Vessel(String vesselId, String vesselName, double averageSpeed, String vesselType) {

		this.vesselId = vesselId;
		this.vesselName = vesselName;
		this.averageSpeed = averageSpeed;
		this.vesselType = vesselType;
	}

	public String getVesselId() {
		return vesselId;
	}

	public void setVesselId(String vesselId) {
		this.vesselId = vesselId;
	}

	public String getVesselName() {
		return vesselName;
	}

	public void setVesselName(String vesselName) {
		this.vesselName = vesselName;
	}

	public double getAverageSpeed() {
		return averageSpeed;
	}

	public void setAverageSpeed(double averageSpeed) {
		this.averageSpeed = averageSpeed;
	}

	public String getVesselType() {
		return vesselType;
	}

	public void setVesselType(String vesselType) {
		this.vesselType = vesselType;
	}

}

class VesselUtil {
	private List<Vessel> vesselList = new ArrayList<>();

	public void addVesselPerformance(Vessel vessel) {
		vesselList.add(vessel);
	}

	public Vessel getVesselById(String vesselId) {
		for (int i = 0; i < vesselList.size(); i++) {
			if (vesselList.get(i).getVesselId().equals(vesselId)) {
				return vesselList.get(i);
			}
		}
		return null;
	}

	public List<Vessel> getHighPerformanceVessels() {
		double maxAverageSpeed = 0;
		for (Vessel vessel : vesselList) {
			maxAverageSpeed = Math.max(vessel.getAverageSpeed(), maxAverageSpeed);
		}
		List<Vessel> highestAverageSpeed = new ArrayList<>();
		for (Vessel vessel : vesselList) {
			if (vessel.getAverageSpeed() == maxAverageSpeed) {

				highestAverageSpeed.add(vessel);
			}
		}
		return highestAverageSpeed;
	}
}

public class OceanFleet {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		VesselUtil vesselUtil = new VesselUtil();

		while (true) {

			System.out.println("\nOcean Fleet Menu   ");
			System.out.println("1. Add Vessel");
			System.out.println("2. Get Vessel by ID");
			System.out.println("3. Show High Performance Vessels");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");

			int choice = sc.nextInt();
			sc.nextLine(); 

			switch (choice) {

			case 1:
				System.out.print("Enter number of vessels to be added: ");
				int numVessels = sc.nextInt();
				sc.nextLine();

				System.out.println("Enter vessels pattern (vesselId:vesselName:averageSpeed:vesselType)");

				for (int i = 0; i < numVessels; i++) {
					String input = sc.nextLine();
					String[] details = input.split(":");

					Vessel vessel = new Vessel(details[0], details[1], Double.parseDouble(details[2]), details[3]);

					vesselUtil.addVesselPerformance(vessel);
				}
				System.out.println("Vessel(s) added successfully.");
				break;

			case 2:
				System.out.print("Enter Vessel ID to check speed: ");
				String id = sc.nextLine();

				Vessel vessel = vesselUtil.getVesselById(id);
				if (vessel != null) {
					System.out.println(vessel.getVesselId() + "|" + vessel.getVesselName() + "|"
							+ vessel.getVesselType() + "|" + vessel.getAverageSpeed() + " knots");
				} else {
					System.out.println("Vessel not found.");
				}
				break;

			case 3:
				System.out.println("High performance vessels are:");
				List<Vessel> highPer = vesselUtil.getHighPerformanceVessels();

				if (highPer.isEmpty()) {
					System.out.println("No vessels available.");
				} else {
					for (Vessel v : highPer) {
						System.out.println(v.getVesselId() + "|" + v.getVesselName() + "|" + v.getVesselType() + "|"
								+ v.getAverageSpeed() + " knots");
					}
				}
				break;

			case 4:
				System.out.println("Exiting...");
				
				System.exit(0);

			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}

}
