import java.util.*;


public class NumberListManipulationStream {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 21, 13, 51, 61, 7, 12, 12, 10, 11, 19, 19);

        // filter out even numbers
        numbers.stream().filter(no -> no % 2 == 0).distinct().forEach(System.out::println);
        System.out.println("--------");

        // filter number starting with 1
        numbers.stream().map(s -> s + "").filter(s -> s.startsWith("1")).forEach(System.out::println);
        System.out.println("--------");

        // find out duplicate numbers
        Set<Integer> singleNo = new HashSet<>();
        numbers.stream().filter(no -> !singleNo.add(no)).forEach(System.out::println);
        System.out.println("--------");

        // count total numbers in array
        System.out.println((long) numbers.size());
        System.out.println("--------");

        // find out max value
        System.out.println(numbers.stream().max(Integer::compare).get());
        System.out.println("--------");

        // sort list and print them by separating commas
//        numbers.stream().sorted().forEach(s -> System.out.print(s + " ,"));
//        System.out.println("--------");

        // filter distinct records
        System.out.println(numbers.stream().distinct().toList());
        System.out.println("--------");

        // find the second-highest numbers in list
        System.out.println(numbers.stream().sorted(Comparator.reverseOrder()).distinct().skip(1).findFirst().orElse(null));
        System.out.println("--------");

        // find top 3 highest numbers
        System.out.println(numbers.stream().sorted(Comparator.reverseOrder()).distinct().limit(3).toList());
        System.out.println("--------");

        // fail case
        System.out.println(numbers.stream().sorted(Comparator.reverseOrder()).distinct().limit(3).skip(4).findAny().orElse(null));
        System.out.println("--------");
    }
}
