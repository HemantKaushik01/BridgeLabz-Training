import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HRSystem {
    public static void main(String[] args) {
        List<String> employees = Arrays.asList("hemant", "Kaushik boy", "Harshit");

        List<String> upperCaseNames = employees.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(upperCaseNames);
    }
}