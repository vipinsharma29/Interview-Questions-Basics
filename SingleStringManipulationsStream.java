import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SingleStringManipulationsStream {

    public static void main(String[] args) {

        String input = "Java Hungry Blog Alive is Awesome";

        {
            // find out frequency of each character
            Map<Character, Long> map = input.chars().mapToObj(s -> Character.toLowerCase((char) s)).filter(s -> s != ' ')
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            System.out.println(map);
            System.out.println("---------");
        }

        {
            // find out frequency of each character preserve order
            LinkedHashMap<Character, Long> map = input.chars().mapToObj(s -> Character.toLowerCase((char) s)).filter(s -> s != ' ')
                    .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
            System.out.println(map);
            System.out.println("---------");

        }

        // find out repeating characters
        System.out.println(input.chars().mapToObj(s -> Character.toLowerCase((char) s)).filter(s -> s != ' ')
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(s -> s.getValue() > 1L).map(Map.Entry::getKey).collect(Collectors.toList()));
        System.out.println("---------");

        // filter out words that start with a
        System.out.println(Arrays.stream(input.toLowerCase().split(" ")).filter(s -> s.startsWith("a")).toList());
        System.out.println("---------");

        // reverse each word of the string and collect in list
        System.out.println(Arrays.stream(input.split(" ")).map(s -> new StringBuilder(s).reverse()).toList());
        System.out.println("---------");

        // reverse each word of the string
        System.out.println(Arrays.stream(input.split(" ")).map(s -> new StringBuilder(s).reverse()).collect(Collectors.joining(" ")));
        System.out.println("---------");

        // print words that have occurrence more than 1
        System.out.println(Arrays.stream(input.split(" ")).filter(s -> s.toLowerCase().chars().filter(ch -> ch == 'a').count() > 1).toList());
        System.out.println("---------");

    }
}
