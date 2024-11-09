package streamsQuestions;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumberManipulationStreamBasic {

    public static void main(String[] args) {

        arrayManipulation();
        listManipulation();
        intStreamManupulation();

    }

    private static void intStreamManupulation() {

        System.out.println("14. Print number within the given range");
        IntStream.rangeClosed(0, 6).forEach(System.out::print);
        System.out.println();
        System.out.println("--------");

        System.out.println("15. Print all number stats from 0 and under 6");
        IntStream.range(0, 6).forEach(System.out::print);
        System.out.println();
        System.out.println("--------");

        System.out.println("16. Print all number under 6 and skip first 2");
        IntStream.range(0, 6).skip(2).forEach(System.out::print);
        System.out.println();
        System.out.println("--------");

        System.out.println("15. Print all number under 6 and limit to 2");
        IntStream.range(0, 6).limit(2).forEach(System.out::print);
        System.out.println();
        System.out.println("--------");

        System.out.println("16. Count number between 1 and 4");
        System.out.println(IntStream.range(1, 4).count());
        System.out.println("--------");

        System.out.println("17. Print all number under 6 and skip first 2 and limit to 3");
        IntStream.range(0, 6).skip(2).limit(3).forEach(System.out::print);
        System.out.println();
        System.out.println("--------");
    }

    private static void listManipulation() {
        List<Integer> numbers = List.of(1, 21, 13, 51, 61, 7, 12, 12, 10, 11, 19, 19);
        Integer operationValue = 0;

        System.out.println("3. Filter list of even number");
        numbers.stream().filter(no -> no % 2 == 0).distinct().forEach(System.out::println);
        System.out.println("--------");

        System.out.println("4. Find out largest even number");
        {
            var maxOfOddNumber = numbers.stream().filter(n -> n % 2 == 0).max(Integer::compareTo).orElse(null);
            System.out.println(maxOfOddNumber);

        }
        // or - less efficient reduce travel whole list comparing each element during maximum reduction steps.
        {
            var maxOfOddNumber = numbers.stream().filter(n -> n % 2 == 0).reduce(Integer.MIN_VALUE, Integer::max);
            System.out.println(maxOfOddNumber);
        }
        System.out.println("--------");

        System.out.println("5. Calculate the sum of odd numbers");
        {
            System.out.println(numbers.stream().mapToInt(Integer::intValue).filter(n -> n % 2 != 0).sum());
        }
        // or - less efficient as in this autoboxing and unboxing will be performed multiple times hence reducing the efficiency
        {
            System.out.println(numbers.stream().filter(n -> n % 2 != 0).reduce(0, Integer::sum));
        }
        System.out.println("--------");


        System.out.println("6. Find out max value");
        {
            System.out.println(numbers.stream().max(Integer::compare).get());
        }
        // or - less efficient reduce travel whole list comparing each element during maximum reduction steps.
        {
            System.out.println(numbers.stream().reduce(Integer.MIN_VALUE, Integer::max));
        }
        System.out.println("--------");


        System.out.println("7. Filter numbers that start with 1 and print each element");
        {
            numbers.stream().map(String::valueOf).filter(s -> s.startsWith("1")).forEach(System.out::println);
        }
        // or  - less efficient as flatMap will create new single string stream for each number
        {
            numbers.stream().flatMap(n -> Stream.of(String.valueOf(n))).filter(s -> s.startsWith("1")).forEach(System.out::println);
        }
        System.out.println("--------");

        System.out.println("8. Filter distinct records");
        System.out.println(numbers.stream().distinct().toList());
        System.out.println("--------");

        System.out.println("9. Find out duplicate numbers");
        Set<Integer> singleNo = new HashSet<>();
        numbers.stream().filter(no -> !singleNo.add(no)).forEach(System.out::println);
        System.out.println("--------");

        System.out.println("10. Find the second-highest numbers in list");
        System.out.println(numbers.stream().sorted(Comparator.reverseOrder()).distinct().skip(1).findFirst().orElse(null));
        System.out.println("--------");

        System.out.println("11. Find top 3 highest numbers");
        System.out.println(numbers.stream().sorted(Comparator.reverseOrder()).distinct().limit(3).toList());
        System.out.println("--------");

        System.out.println("12. Fail case");
        System.out.println(numbers.stream().sorted(Comparator.reverseOrder()).distinct().limit(3).skip(4).findAny().orElse(null));
        System.out.println("--------");

        System.out.println("13. Sort list and print them by separating commas");
        System.out.println(numbers.stream().sorted(Comparator.reverseOrder()).map(String::valueOf).collect(Collectors.joining(", ")));
//        numbers.stream().sorted().forEach(s -> System.out.print(s + " ,"));
        System.out.println("--------");
    }

    private static void arrayManipulation() {
        int[] a = {2, 2, 4, 3, 6, 6, 7, 1, 2, 9, 11};

        System.out.println("1. Sort array using stream");
        System.out.println(Arrays.stream(a).boxed().sorted().toList());
        System.out.println("--------");

        System.out.println("2. Find out max element in array");
        System.out.println(Arrays.stream(a).boxed().max(Comparator.naturalOrder()));
        System.out.println("--------");

    }
}
