package streamsQuestions;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class TransactionManagementStreamBasic {

    public static void main(String[] args) {

        List<Transaction> transactions = Arrays.asList(
                new Transaction("T001", "C001", "Credit", 1000.0, LocalDate.of(2025, 1, 1), "New York"),
                new Transaction("T002", "C002", "Debit", 500.0, LocalDate.of(2025, 1, 2), "Los Angeles"),
                new Transaction("T003", "C003", "Credit", 1200.0, LocalDate.of(2025, 1, 3), "Chicago"),
                new Transaction("T004", "C001", "Debit", 800.0, LocalDate.of(2025, 1, 4), "Houston"),
                new Transaction("T005", "C004", "Credit", 700.0, LocalDate.of(2025, 1, 5), "Phoenix")
        );

        System.out.println("1. Find total debit amount");
        System.out.println(transactions.stream().filter(t -> t.getType().equals("Debit")).mapToDouble(Transaction::getAmount).sum());
        System.out.println("---------");

        System.out.println("2. Find all transaction with amount more than 900");
        transactions.stream().filter(t -> t.getAmount() > 900).forEach(System.out::println);
        System.out.println("---------");

        System.out.println("3. Group Transactions by Customer");
        transactions.stream().collect(Collectors.groupingBy(Transaction::getCustomerId)).forEach((key, value) -> {
            System.out.println(key);
            value.forEach(System.out::println);
            System.out.println();
        });
        System.out.println("---------");

        System.out.println("4. Calculate net balance for each customer");
        transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getCustomerId, LinkedHashMap::new, Collectors.summingDouble(t -> t.getType().equals("Credit") ? t.getAmount() : -t.getAmount())))
                .forEach((key, value) -> {
                    System.out.println(key + " -> " + value);
                });
        System.out.println("---------");

        System.out.println("5. Which is the Most frequent transaction type");
        System.out.println(transactions.stream().collect(Collectors.groupingBy(Transaction::getType, Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse("None"));
        System.out.println("---------");

        System.out.println("6. Find all transaction done after 2025-01-03");
        transactions.stream().filter(t -> t.getDate().isAfter(LocalDate.of(2025, 1, 3))).forEach(System.out::println);
        System.out.println("---------");

        System.out.println("7. Find the transaction amount on basics of location");
        transactions.stream().collect(Collectors.groupingBy(Transaction::getLocation, LinkedHashMap::new, Collectors.summingDouble(Transaction::getAmount)))
                .forEach((key, value) -> {
                    System.out.println(key + " -> " + value);
                });
        System.out.println("---------");

        System.out.println("8. Find location with max transaction");
        System.out.println(transactions.stream().collect(Collectors.groupingBy(Transaction::getLocation, Collectors.summingDouble(Transaction::getAmount))).entrySet()
                .stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse("None"));
        System.out.println("---------");

        System.out.println("9. Find transaction with least amount");
        System.out.println(transactions.stream().min(Comparator.comparingDouble(Transaction::getAmount)).get());
        System.out.println("---------");

        System.out.println("10. Find transaction with least amount for each customer");
        transactions.stream().collect(Collectors.groupingBy(Transaction::getCustomerId, Collectors.minBy(Comparator.comparingDouble(Transaction::getAmount)))).forEach((key, value) -> {
            System.out.println(key + " -> " + value.orElse(null));
        });
        System.out.println("---------");

        System.out.println("11. Find average transaction amount by location");
        transactions.stream().collect(Collectors.groupingBy(Transaction::getLocation, Collectors.averagingDouble(Transaction::getAmount)))
                        .forEach((key, value) -> System.out.println(key + " -> " + value));
        System.out.println("---------");

        System.out.println("12. Find average transaction amount by User");
        transactions.stream().collect(Collectors.groupingBy(Transaction::getCustomerId, Collectors.averagingDouble(Transaction::getAmount)))
                .forEach((key, value) -> System.out.println(key + " -> " + value));
        System.out.println("---------");

        System.out.println("13. Find average transaction amount by transaction type");
        transactions.stream().collect(Collectors.groupingBy(Transaction::getType, Collectors.averagingDouble(Transaction::getAmount)))
                .forEach((key, value) -> System.out.println(key + " -> " + value));
        System.out.println("---------");
    }

}

class Transaction {

    private String transactionId;
    private String customerId;
    private String type;
    private Double amount;
    private LocalDate date;
    private String location;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Transaction(String transactionId, String customerId, String type, Double amount, LocalDate date, String location) {
        this.transactionId = transactionId;
        this.customerId = customerId;
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.location = location;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId='" + transactionId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                ", location='" + location + '\'' +
                '}';
    }
}