
import java.util.*;
import java.util.stream.*;

interface EmergencyService {

}
interface TransportService {
    String getServiceName();
    default void printServiceDetails() {
        System.out.println("Service: " + getServiceName());
    }
}
interface GeoUtils {
    static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        
        final int R = 6371; 
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c; 
    }
}
class BusService implements TransportService {
    public String getServiceName() { 
        return "City Bus"; 
    }
}
class MetroService implements TransportService {
    public String getServiceName() { 
        return "City Metro"; }
}
class TaxiService implements TransportService {
    public String getServiceName() { return "City Taxi"; }
}
public class SmartCity {
    public static void main(String[] args) {
 
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Smart City Transport System, !");
        while(true) {
            System.out.println("1. Book a Trip");
            System.out.println("2. View Active Services");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    System.out.println("Booking a trip...");
                    System.out.println("Enter  the user Name: ");
                    String userName = scanner.nextLine();
                    System.out.println("Enter your current location (latitude and longitude): ");
        double latitude = scanner.nextDouble();
        double longitude = scanner.nextDouble();
        System.out.println("Enter your destination (latitude and longitude): ");
        double destLatitude = scanner.nextDouble();
        double destLongitude = scanner.nextDouble();
            double distance = GeoUtils.calculateDistance(latitude, longitude, destLatitude, destLongitude);
        System.out.println("Distance between points: " + distance + " km");
                    break;
                case 2:
                    viewActiveServices();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        

    }

    private static void viewActiveServices() {
        System.out.println("Active Transport Services:");
        List<TransportService> services = Arrays.asList(
            new BusService(),
            new MetroService(),
            new TaxiService()
        );
        services.forEach(TransportService::printServiceDetails);

    }
}

