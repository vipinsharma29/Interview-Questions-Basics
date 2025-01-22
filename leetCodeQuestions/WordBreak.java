package leetCodeQuestions;

import java.util.*;

public class WordBreak {

    static Map<String, Boolean> words = new HashMap<>();

    public static void main(String[] args) {
        wordBreak("leetcode", Arrays.asList("leet", "code"));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0) return false;

        Set<String> wordSet = new HashSet<>(wordDict);
        return check(s, wordSet);
    }

    public static boolean check(String s, Set<String> wordDict) {
        if (words.containsKey(s)) {
            return words.get(s);
        }

        if (s.length() == 0) return true;

        for (int i = 0; i <= s.length(); i++) {
            String subString = s.substring(0, i);
            if(wordDict.contains(subString)) {
                words.put(subString, true);
                String recursiveSubString = s.substring(i);
                if(check(recursiveSubString, wordDict)) {
                    return true;
                }
            }
        }
        words.put(s, false);
        return false;
    }

}
