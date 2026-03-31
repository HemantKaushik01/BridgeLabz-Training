import java.util.Arrays;
import java.util.List;

public class PatientVerification {
    public static void main(String[] args) {
        List<Integer> patientIds = Arrays.asList(101, 102, 103, 104);

        System.out.println("Verifying Patient IDs:");
        patientIds.forEach(System.out::println);
    }
}