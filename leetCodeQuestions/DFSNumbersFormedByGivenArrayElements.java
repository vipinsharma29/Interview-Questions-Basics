package leetCodeQuestions;

import java.util.ArrayList;
import java.util.List;

/*
Given an array and a number N:
1. Find all numbers that can be formed using array elements such that they are ≤ N.
2. Print the count of numbers ≤ N that can be formed using these digits.
 */
public class DFSNumbersFormedByGivenArrayElements {

    static int count = 0;

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int n = 100;
        int startingPoint = 0;

        // 1st point print all numbers;
        List<Integer> resultList = new ArrayList<>();
        dfs(arr, n, startingPoint, resultList);
        System.out.println(resultList);

        dfs(arr, n, startingPoint);
        System.out.println(count);
    }

    private static void dfs(int[] arr, int n, int current, List<Integer> resultList) {
        if (current > n) return;

        if (current != 0)
            resultList.add(current);

        for (int i : arr) {
            int next = current * 10 + i;
            dfs(arr, n, next, resultList);
        }
    }

    private static void dfs(int[] arr, int n, int current) {
        if (current > n) return;

        if (current != 0)
            count++;

        for (int i : arr) {
            int next = current * 10 + i;
            dfs(arr, n, next);
        }
    }
}
