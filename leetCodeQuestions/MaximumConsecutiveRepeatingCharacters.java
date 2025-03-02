package leetCodeQuestions;

public class MaximumConsecutiveRepeatingCharacters {

    static char maxRepeating(String s) {
        int n = s.length();
        int maxCnt = 0;
        char res = s.charAt(0);

        // Find the maximum repeating character
        // starting from s[i]
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            while (i + 1 < n && s.charAt(i) == s.charAt(i + 1)) {
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
        String s = "aaaabbaaccde";
        System.out.println(maxRepeating(s));
    }
}
