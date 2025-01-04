package leetCodeQuestions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RemoveDuplicatesFromArray {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 4, 4, 5, 6};
        System.out.println(removeDuplicates(nums));
    }

    private static List<Integer> removeDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = i + 1;
        while (j <= nums.length) {
            if (nums[i] != nums[j])
                result.add(nums[i]);
            if (j <= nums.length - 1) {
                j++;
            }
            i++;
        }
        return result;
    }
}
