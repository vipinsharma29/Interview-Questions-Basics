package leetCodeQuestions;

public class MaximumConsecutiveRepeatingCharacters {

    public static char maxRepeating(String s) {
        int maxCnt = 0;
        char res = s.charAt(0);

        // Find the maximum repeating character
        // starting from s[i]
        for (int i = 0; i < s.length(); i++) {
            int cnt = 1;
            while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                i++;
                cnt++;
            }

            // Update result if required
            if (cnt > maxCnt) {
                maxCnt = cnt;
                res = s.charAt(i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "aabbbbaaccde";
        method2(s);
//        System.out.println(maxRepeating(s));
    }

    public static void method2(String s) {
        char currentCharacter = s.charAt(0), characterResult = s.charAt(0);
        int maxOccurrence = 1, currentCount = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == currentCharacter) {
                currentCount++;
                if (currentCount > maxOccurrence) {
                    characterResult = currentCharacter;
                    maxOccurrence = currentCount;
                }
            } else {
                currentCharacter = s.charAt(i);
                currentCount = 1;
            }
        }
        System.out.println(characterResult);
        System.out.println(maxOccurrence);
    }
}
