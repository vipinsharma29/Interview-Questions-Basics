package leetCodeQuestions;

public class LongestCommonSubstring {

    public static String findLongestCommonSubstring(String[] words) {
        if (words == null || words.length == 0) return "";

        String first = words[0].toLowerCase();
        int maxLength = 0;
        String longestSubstring = "";

        for (int len = 1; len <= first.length(); len++) {
            for (int start = 0; start <= first.length() - len; start++) {
                String sub = first.substring(start, start + len);

                boolean isCommon = true;
                for (int i = 1; i < words.length; i++) {
                    if (!words[i].toLowerCase().contains(sub)) {
                        isCommon = false;
                        break;
                    }
                }

                if (isCommon && sub.length() > maxLength) {
                    maxLength = sub.length();
                    longestSubstring = sub;
                }
            }
        }
        return longestSubstring;
    }

    public static void main(String[] args) {
        String[] str = {"MrVipin", "ShreeVipinSharma", "okvipin"};

        String result = findLongestCommonSubstring(str);
        System.out.println("Longest Common Prefix: " + result);
    }

}
