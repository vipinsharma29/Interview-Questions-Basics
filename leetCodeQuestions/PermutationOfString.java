package leetCodeQuestions;

import java.util.LinkedHashSet;
import java.util.Set;

public class PermutationOfString {

    public static void main(String[] args) {
        String str = "ABC";
        LinkedHashSet<String> s = new LinkedHashSet<>();
        permute(str.toCharArray(), 0, s);

        System.out.println(s + ": " + s.size());
    }

    private static void permute(char[] arr, int index, Set<String> s) {
        if (index == arr.length - 1) {
            s.add(String.valueOf(arr));
            return;
        }

        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            permute(arr, index + 1, s);
            swap(arr, index, i);
        }
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
