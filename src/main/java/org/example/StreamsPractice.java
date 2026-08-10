package org.example;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsPractice {
    static void main() {
        printAllNumbersInList(List.of(12, 23, 34, 23, 45, 67, 43, 3, 1));
        System.out.println("---");
        evenNumbers(List.of(12, 23, 34, 23, 45, 67, 43, 3, 1));

        List<Integer> ar = List.of(4, 5, 6, 5, 9, 2);
        System.out.println(solve(ar, 3));

        List<User> users = List.of(
                new User("Alice", "ALICE@EXAMPLE.COM", 25, true),
                new User("Bob", "bob@example.com", 17, true),
                new User("Charlie", "CHARLIE@EXAMPLE.COM", 30, false),
                new User("David", "david@example.com", 22, true),
                new User("Eve", "ALICE@EXAMPLE.COM", 25, true) // Duplicate email scenario
        );

        users.stream()
                .filter(user -> user.isActive() && user.getAge() >= 18)
                .map(user -> user.getEmail().toLowerCase())
                .distinct().sorted().forEach(System.out::println);

        List<TestResult> results = List.of(
                new TestResult("Auth", "loginTest", 120.0, Status.PASSED),
                new TestResult("Auth", "logoutTest", 80.0, Status.PASSED),
                new TestResult("Auth", "failedLogin", 200.0, Status.FAILED),
                new TestResult("Checkout", "paymentTest", 450.0, Status.PASSED),
                new TestResult("Checkout", "cartTest", 350.0, Status.PASSED),
                new TestResult("Checkout", "applyCoupon", 150.0, Status.SKIPPED)
        );

        Map<String, Double> output = results.stream()
                .filter(result -> result.getStatus() == Status.PASSED)
                .collect(Collectors.groupingBy(TestResult::getSuite,
                        Collectors.averagingDouble(TestResult::getDurationMs)));
        System.out.println(output);

        List<TestRun> runs = List.of(
                new TestRun("RUN_1", List.of(
                        List.of("INFO: Test started", "ERROR: Connection timeout "),
                        List.of("INFO: Retrying connection", "ERROR: DB connection failed ")
                )),
                new TestRun("RUN_2", List.of(
                        List.of("INFO: Setup complete", "ERROR: Element not clickable ")
                ))
        );

        System.out.println(runs.stream()
                .flatMap(run -> run.getStepLogs().stream())
                .flatMap(List::stream)
                .filter(step -> step.startsWith("ERROR:"))
                .map(step -> step.replace("ERROR:", "").trim())
                .collect(Collectors.joining(", ")));
    }

    private static List<Integer> solve(List<Integer> arr, int p) {
        List<Integer> firstHalf = arr.subList(0, p);
        List<Integer> secondHalf = arr.subList(p, arr.size());

        List<Integer> nonPrimesList = firstHalf.stream()
                .filter(n -> !isPrime(n)).toList();
        return Stream.concat(secondHalf.stream(), nonPrimesList.stream()).toList();
    }

    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static void printAllNumbersInList(List<Integer> integers) {
        integers.forEach(System.out::println);
    }

    private static void evenNumbers(List<Integer> integers) {
        integers.stream().filter(i -> i % 2 == 0).forEach(System.out::println);
    }
}

enum Status { PASSED, FAILED, SKIPPED }

class User {
    private String name;
    private String email;
    private int age;
    private boolean active;

    public User(String name, String email, int age, boolean active) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.active = active;
    }

    public String getEmail() { return email; }
    public int getAge() { return age; }
    public boolean isActive() { return active; }
}

class TestResult {
    private String suite;
    private String testName;
    private double durationMs;
    private Status status;

    public TestResult(String suite, String testName, double durationMs, Status status) {
        this.suite = suite;
        this.testName = testName;
        this.durationMs = durationMs;
        this.status = status;
    }

    public String getSuite() { return suite; }
    public double getDurationMs() { return durationMs; }
    public Status getStatus() { return status; }
}

class TestRun {
    private String runId;
    private List<List<String>> stepLogs;

    public TestRun(String runId, List<List<String>> stepLogs) {
        this.runId = runId;
        this.stepLogs = stepLogs;
    }

    public List<List<String>> getStepLogs() { return stepLogs; }
}
