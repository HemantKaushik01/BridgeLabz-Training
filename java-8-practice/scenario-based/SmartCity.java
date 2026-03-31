import java.util.*;
import java.util.stream.*;

interface EmergencyService {
}

interface TransportService {
	String getServiceName();

	String getRoute();

	double getFare();

	int getDepartureTime();

	default void printServiceDetails() {
		System.out.println(getServiceName() + " | Route: " + getRoute() + " | Fare: ₹" + getFare() + " | Time: "
				+ getDepartureTime() + ":00");
	}
}

interface GeoUtils {
	static double calculateDistance(double x1, double y1, double x2, double y2) {
		double dx = x2 - x1;
		double dy = y2 - y1;
		return Math.sqrt(dx * dx + dy * dy);
	}
}

@FunctionalInterface
interface FareCalculator {
	double calculateFare(double distance);
}

class BusService implements TransportService {
	public String getServiceName() {
		return "Bus";
	}

	public String getRoute() {
		return "A → B";
	}

	public double getFare() {
		return 30;
	}

	public int getDepartureTime() {
		return 9;
	}
}

class MetroService implements TransportService {
	public String getServiceName() {
		return "Metro";
	}

	public String getRoute() {
		return "B → C";
	}

	public double getFare() {
		return 50;
	}

	public int getDepartureTime() {
		return 8;
	}
}

class TaxiService implements TransportService {
	public String getServiceName() {
		return "Taxi";
	}

	public String getRoute() {
		return "A → C";
	}

	public double getFare() {
		return 120;
	}

	public int getDepartureTime() {
		return 7;
	}
}

class AmbulanceService implements TransportService, EmergencyService {
	public String getServiceName() {
		return "Ambulance";
	}

	public String getRoute() {
		return "Emergency Route";
	}

	public double getFare() {
		return 0;
	}

	public int getDepartureTime() {
		return 24;
	}
}

class Passenger {
	String route;
	double fare;
	boolean peak;

	Passenger(String route, double fare, boolean peak) {
		this.route = route;
		this.fare = fare;
		this.peak = peak;
	}

	String getRoute() {
		return route;
	}

	double getFare() {
		return fare;
	}

	boolean isPeak() {
		return peak;
	}
}

public class SmartCity {

	static List<TransportService> services = Arrays.asList(new BusService(), new MetroService(), new TaxiService(),
			new AmbulanceService());

	static List<Passenger> passengers = new ArrayList<>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("\n1. Book Trip");
			System.out.println("2. View Services");
			System.out.println("3. Emergency Services");
			System.out.println("4. Revenue Report");
			System.out.println("5. Exit");
			int choice = sc.nextInt();

			switch (choice) {

			case 1:
				sc.nextLine();
				System.out.print("Enter Route: ");
				String route = sc.nextLine();

				System.out.print("Peak Time (true/false): ");
				boolean peak = sc.nextBoolean();

				System.out.print("Enter Source Latitude Longitude: ");
				double x1 = sc.nextDouble();
				double y1 = sc.nextDouble();

				System.out.print("Enter Destination Latitude Longitude: ");
				double x2 = sc.nextDouble();
				double y2 = sc.nextDouble();

				double distance = GeoUtils.calculateDistance(x1, y1, x2, y2);

				FareCalculator calculator = d -> d * 10;
				double fare = calculator.calculateFare(distance);

				passengers.add(new Passenger(route, fare, peak));

				System.out.println("Distance: " + distance);
				System.out.println("Fare: " + fare);
				break;

			case 2:
				services.stream().sorted((a, b) -> a.getDepartureTime() - b.getDepartureTime())
						.forEach(TransportService::printServiceDetails);
				break;

			case 3:
				services.stream().filter(s -> s instanceof EmergencyService)
						.forEach(s -> System.out.println(s.getServiceName() + " PRIORITY"));
				break;

			case 4:
				Map<String, List<Passenger>> byRoute = passengers.stream()
						.collect(Collectors.groupingBy(Passenger::getRoute));

				byRoute.forEach((r, list) -> System.out.println(r + " : " + list.size()));

				Map<Boolean, List<Passenger>> peakMap = passengers.stream()
						.collect(Collectors.partitioningBy(Passenger::isPeak));

				DoubleSummaryStatistics stats = passengers.stream()
						.collect(Collectors.summarizingDouble(Passenger::getFare));

				System.out.println("Peak Trips: " + peakMap.get(true).size());
				System.out.println("Non-Peak Trips: " + peakMap.get(false).size());
				System.out.println("Total Revenue: " + stats.getSum());
				System.out.println("Average Fare: " + stats.getAverage());
				break;

			case 5:
				return;

			default:
				System.out.println("Invalid Choice");
			}
		}
	}
}
