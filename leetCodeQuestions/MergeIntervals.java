package leetCodeQuestions;

import java.util.*;

public class MergeIntervals {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        while (i < n) {
            result.add(intervals[i]);
            i++;
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] a = {{-3, -1}, {1, 3}, {4, 6}, {16, 92}};
        int[] newInterval = {2, 10};

        int[][] res = insert(a, newInterval);

        for (int[] r : res) {
            System.out.println(Arrays.toString(r));
        }
    }
}