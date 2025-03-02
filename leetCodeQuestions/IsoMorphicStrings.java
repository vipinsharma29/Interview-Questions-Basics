package leetCodeQuestions;

//How to check if two strings are iso-morphic ?
//    I/P : aab , xxy
//    O/P : true
//reason : ‘a’ is mapped to ‘x’ and ‘b’ is mapped to ‘y’. and the count remains same.
//    I/P  : aab, xyz
//    O/p : False

//O(1) Space Complexity (since there are at most 26 characters in the map).
//O(n) → We iterate through the string once.

import java.util.HashMap;

public class IsoMorphicStrings {

    public static void main(String[] args) {
        System.out.println(isoMorphicStrings("aab", "xxy"));
        System.out.println(isoMorphicStrings("abb", "xyy"));
        System.out.println(isoMorphicStrings("abb", "xxy"));
        System.out.println(isoMorphicStrings("abc", "xyx"));
        System.out.println();
        System.out.println(isoMorphicStrings2("aab", "xxy"));
        System.out.println(isoMorphicStrings2("abb", "xyy"));
        System.out.println(isoMorphicStrings2("abb", "xxy"));
        System.out.println(isoMorphicStrings2("abc", "xyx"));
    }

    private static boolean isoMorphicStrings(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        HashMap<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            if (map.containsKey(s1.charAt(i))) {
                if (map.get(s1.charAt(i)).equals(s2.charAt(i)))
                    continue;
                return false;
            } else
                map.put(s1.charAt(i), s2.charAt(i));
        }
        return true;
    }

    private static boolean isoMorphicStrings2(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        HashMap<Character, Character> mapS1 = new HashMap<>();
        HashMap<Character, Character> mapS2 = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            if (mapS1.containsKey(c1) && mapS1.get(c1) != c2)
                return false;

            if (mapS2.containsKey(c2) && mapS2.get(c2) != c1)
                return false;

            mapS1.put(c1, c2);
            mapS2.put(c2, c1);
        }
        return true;
    }
}
