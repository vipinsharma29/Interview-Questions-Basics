package leetCodeQuestions;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacter {

    static final int MAX_CHAR = 26;

    static int method1(String s) {
        int n = s.length();
        int res = 0;

        for (int left = 0; left < n; left++) {

            // Initializing all characters as not visited
            boolean[] vis = new boolean[MAX_CHAR];

            for (int right = left; right < n; right++) {

                // If current character is visited
                // Break the loop
                if (vis[s.charAt(right) - 'a'])
                    break;

                    // Else update the result if this window is larger,
                    // and mark current character as visited.
                else {
                    res = Math.max(res, right - left + 1);
                    vis[s.charAt(right) - 'a'] = true;
                }
            }
        }
        return res;
    }

    static int method2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, max = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // If duplicate found, move left pointer
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }

            map.put(c, right); // store latest index
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "geeksforgeeks";
        System.out.println(method1(s));
        System.out.println(method2(s));
    }

}
