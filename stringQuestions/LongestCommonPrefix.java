package stringQuestions;

import java.util.Arrays;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] arr = {"Vipin", "Vip", "Vim", "vit"};
        System.out.println(firstMethod(Arrays.stream(arr).map(String::toLowerCase).toArray(String[]::new)));
    }

    private static String firstMethod(String[] arr) {

        if (arr == null || arr.length == 0)
            return "-1";

        String firstWord = arr[0];
        String secondWord = arr[arr.length - 1];
        int minLength = Math.min(firstWord.length(), secondWord.length());

        int i = 0;
        while (i < minLength && firstWord.toLowerCase().charAt(i) == secondWord.toLowerCase().charAt(i))
            i++;

        if (i == 0)
            return "-1";

        return firstWord.substring(0, i);
    }
}
