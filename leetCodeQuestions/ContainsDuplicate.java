package leetCodeQuestions;

import java.util.HashMap;
import java.util.Map;

/*
Given an integer array nums,
return true if any value appears at least twice in the array,
and return false if every element is distinct.
 */
public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 4};

        System.out.println(approach1(arr));
        System.out.println(approach2(arr));

    }

    // using map - time = O(n), space = O(n)
    private static boolean approach1(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int j : arr) {
            if (map.containsKey(j)) {
                if (map.get(j) >= 1)
                    return true;
                else
                    map.put(j, map.getOrDefault(j, 1) + 1);
            } else {
                map.put(j, 1);
            }
        }
        return false;
    }

    // finding first matching element - time = O(n)2, space = O(1)
    private static boolean approach2(int[] arr) {

        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return true;
                }
            }
        }

        return false;
    }
}
