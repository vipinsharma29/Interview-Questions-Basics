package stringQuestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TwoStringAnagram {

    public static void main(String[] args) {
        String s1 = "vipin sharmA";
        String s2 = "nipvi Hsmaar";

        System.out.println(firstMethod(s1.replace(" ", "").toLowerCase(), s2.replace(" ", "").toLowerCase()));
        System.out.println(secondMethod(s1.replace(" ", "").toLowerCase(), s2.replace(" ", "").toLowerCase()));
    }

    private static boolean secondMethod(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        char[] ch1 = s1.toLowerCase().toCharArray();
        char[] ch2 = s2.toLowerCase().toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);

        return Arrays.equals(ch1, ch2);
    }

    private static boolean firstMethod(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        Map<Character, Long> characterMap = new HashMap<>();
        characterMap = s1.chars().filter(ch -> ch != ' ').mapToObj(ch -> Character.toLowerCase((char) ch)).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            if (characterMap.containsKey(ch) && characterMap.get(ch) < 0) {
                characterMap.put(ch, characterMap.getOrDefault(ch, 0L) - 1);
            } else
                return false;
        }

        for (Map.Entry<Character, Long> map : characterMap.entrySet()) {
            if (map.getValue() != 0)
                return false;
        }

        return true;
    }
}
