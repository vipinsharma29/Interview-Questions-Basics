package functionalPrograming;

import models.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FunctionalInterface {

    public static void main(String[] args) throws Exception {

        functionInterfaceExample();

        biFuntionaInterfaceExample();
    }

    private static void biFuntionaInterfaceExample() {
        BiFunction<List<String>, List<Integer>, String> printCombo = (list, list2) -> {
            return IntStream.range(0, Math.max(list.size(), list2.size())).mapToObj(i -> (i < list.size() ? list.get(i) : "null") + (i < list2.size() ? list2.get(i) : "0")).collect(Collectors.joining(" "));
        };

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "bob");
        List<Integer> numbers = Arrays.asList(1, 2, 3);

        List<String> names2 = Arrays.asList("Alice", "Bob", "Charlie");
        List<Integer> number2 = Arrays.asList(1, 2, 3, 4);

        System.out.println(printCombo.apply(names, numbers));
        System.out.println(printCombo.apply(names2, number2));

        BiFunction<Double, Integer, Long> calculateSum = (a, b) -> a.longValue() + b.longValue();

        System.out.println(calculateSum.apply(120.0, 12));
    }

    private static void functionInterfaceExample() {
        Function<String, Integer> checkStringLength = String::length;
        System.out.println(checkStringLength.apply("Vipin"));
        System.out.println(checkStringLength.apply("Sharma"));

        List<String> names = Arrays.asList("Vipin", "Sharma");
        List<Integer> numbers = Arrays.asList(1, 2, 3);


        Function<List<?>, String> concatInput = list -> list.stream().map(String::valueOf).collect(Collectors.joining(" "));
        Function<List<String>, String> concatString = list -> String.join(" ", list);
        Function<List<Integer>, String> concatInteger = list -> list.stream().map(String::valueOf).collect(Collectors.joining(" "));

        System.out.println(concatInput.apply(names));
        System.out.println(concatInput.apply(numbers));
        System.out.println(concatString.apply(names));
        System.out.println(concatInteger.apply(numbers));

        Function<List<Integer>, Integer> sumAll = list -> list.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sumAll.apply(numbers));
        System.out.println(sumAll.apply(List.of(1, 2, 3, 4, 5)));

        Function<List<Integer>, Integer> sumAllByReduce = list -> list.stream().reduce(0, Integer::sum);
        System.out.println(sumAllByReduce.apply(numbers));
        System.out.println(sumAllByReduce.apply(List.of(1, 2, 3, 4, 5)));

        Function<List<Integer>, Integer> mulAllByReduce = list -> list.stream().reduce(1, (a, b) -> a * b);
        System.out.println(mulAllByReduce.apply(numbers));

        List<Employee> employees = Employee.getEmployeeList();

        Function<List<Employee>, Double> sumSalary = list -> list.stream().map(Employee::getSalary).mapToDouble(Double::doubleValue).sum();
        Function<List<Employee>, Double> sumSalaryByReduce = list -> list.stream().map(Employee::getSalary).reduce(0.0, Double::sum);

        Function<List<Employee>, String> concatEmpName = list -> list.stream().map(Employee::getName).collect(Collectors.joining());
        Function<List<Employee>, String> concatEmpNameByReduce = list -> list.stream().map(Employee::getName).reduce("", String::concat);

        System.out.println(sumSalary.apply(employees));
        System.out.println(sumSalaryByReduce.apply(employees));
        System.out.println(concatEmpName.apply(employees));
        System.out.println(concatEmpNameByReduce.apply(employees));

        Function<List<Employee>, String> empWithSalary = list -> list.stream().map(emp -> emp.getName() + " -> " + emp.getSalary()).collect(Collectors.joining(", "));
        System.out.println(empWithSalary.apply(employees));

    }

}
