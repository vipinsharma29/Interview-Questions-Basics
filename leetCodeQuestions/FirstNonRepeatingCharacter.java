package leetCodeQuestions;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {
        String s = "geeksforgeeks";

        System.out.println(solution(s));
    }

    private static char solution(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();

        char value = 0;
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            if (e.getValue() == 1) {
                value = e.getKey();
                break;
            }
        }
        return value;
    }
}
