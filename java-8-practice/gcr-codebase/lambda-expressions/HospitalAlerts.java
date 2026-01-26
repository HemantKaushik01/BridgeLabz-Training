import java.util.*;
import java.util.function.Predicate;

public class HospitalAlerts {
    public static void main(String[] args) {
        List<String> alerts = Arrays.asList("URGENT: Heart Rate High", "INFO: Checkup scheduled", "URGENT: BP Spike", "INFO: Lunch delivered");
        Predicate<String> urgentFilter = (alert) -> alert.startsWith("URGENT");

        System.out.println("Filtered Notifications:");
        alerts.stream()
              .filter(urgentFilter)
              .forEach(System.out::println);
    }
}