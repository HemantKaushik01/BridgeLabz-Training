import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Invoice {
    String transactionId;

    Invoice(String transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public String toString() {
        return "Invoice ID: " + transactionId;
    }
}

public class FinanceSystem {
    public static void main(String[] args) {
        List<String> transIds = Arrays.asList("Id1", "Id2", "Id3");

        List<Invoice> invoices = transIds.stream()
                .map(Invoice::new)
                .collect(Collectors.toList());

        invoices.forEach(System.out::println);
    }
}