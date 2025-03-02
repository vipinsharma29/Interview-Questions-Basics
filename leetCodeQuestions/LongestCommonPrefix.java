package leetCodeQuestions;

import java.util.Arrays;

public class LongestCommonPrefix {

    public static void main(String[] args) {
//        String[] arr = {"Vipin", "Vip", "Vim", "vit"};
        String[] arr = {"MrVipinSharma", "ShreeVipin", "Vim", "vit"};
        System.out.println(firstMethod(Arrays.stream(arr).map(String::toLowerCase).toArray(String[]::new)));
    }

    private static String firstMethod(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) minLen = Math.min(minLen, str.length());
        int low = 1;
        int high = minLen;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle)) low = middle + 1;
            else high = middle - 1;
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private static boolean isCommonPrefix(String[] strs, int len) {
        String str1 = strs[0].substring(0, len);
        for (int i = 1; i < strs.length; i++)
            if (
                    !strs[i].startsWith(str1)
            ) return false;
        return true;
    }

    private static String secondMethod(String[] strs) {
        StringBuilder ans = new StringBuilder();
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return ans.toString();
            }
            ans.append(first.charAt(i));
        }
        return ans.toString();
    }
}
