package streamsQuestions;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SingleManipulationsStreamBasic {

    public static void main(String[] args) {

        stringManipulation();
        listManipulation();
        arrayManipulation();

    }

    private static void arrayManipulation() {
        String[] arr = {"Vipin", null, "sharma", null, "Test"};

        System.out.println("9. Return non-null array of String");
        String[] anw = Arrays.stream(arr).filter(Objects::nonNull).toArray(String[]::new);
        System.out.println("---------");

        System.out.println("10. Find frequency of each character in arr and ignore null");
        System.out.println(Arrays.stream(arr).filter(Objects::nonNull).collect(Collectors.joining()).chars()
                .mapToObj(ch -> Character.toLowerCase((char) ch)).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
        System.out.println("---------");

        {
            char value = 'a';
            System.out.println("10. Find frequency of specific character across all String in arr and ignore null: " + value);
            System.out.println((Long) Arrays.stream(arr).filter(Objects::nonNull).collect(Collectors.joining()).chars()
                    .mapToObj(ch -> Character.toLowerCase((char) ch)).filter(ch -> ch.equals(value)).count());
            System.out.println("---------");
        }

    }

    private static void listManipulation() {

    }

    private static void stringManipulation() {

        String input = "Java Hungry Blog Alive is Awesome";

        {
            System.out.println("1. Find out frequency of each character");
            Map<Character, Long> map = input.chars().mapToObj(s -> Character.toLowerCase((char) s)).filter(s -> s != ' ')
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            System.out.println(map);
            System.out.println("---------");
        }

        {
            System.out.println("2. Find out frequency of each character preserve order");
            LinkedHashMap<Character, Long> map = input.chars().mapToObj(s -> Character.toLowerCase((char) s)).filter(s -> s != ' ')
                    .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
            System.out.println(map);
            System.out.println("---------");

        }

        System.out.println("3. Find out repeating characters");
        System.out.println(input.chars().mapToObj(s -> Character.toLowerCase((char) s)).filter(s -> s != ' ')
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(s -> s.getValue() > 1L).map(Map.Entry::getKey).collect(Collectors.toList()));
        System.out.println("---------");

        System.out.println("4. Filter out words that start with a");
        System.out.println(Arrays.stream(input.toLowerCase().split(" ")).filter(s -> s.startsWith("a")).toList());
        System.out.println("---------");

        System.out.println("5. Reverse each word of the string and collect in list");
        System.out.println(Arrays.stream(input.split(" ")).map(s -> new StringBuilder(s).reverse()).toList());
        System.out.println("---------");

        System.out.println("6. Reverse each word of the string");
        System.out.println(Arrays.stream(input.split(" ")).map(s -> new StringBuilder(s).reverse()).collect(Collectors.joining(" ")));
        System.out.println("---------");

        System.out.println("7. Print each word in which frequency of 'a' is more than 1");
        System.out.println(Arrays.stream(input.split(" ")).filter(s -> s.toLowerCase().chars().filter(ch -> ch == 'a').count() > 1).toList());
        System.out.println("---------");

        System.out.println("8. Find the longest character in the string");
        System.out.println(Arrays.stream(input.split(" ")).max((w1, w2) -> Integer.compare(w1.length(), w2.length())).orElse(null));
        System.out.println("---------");

    }
}
