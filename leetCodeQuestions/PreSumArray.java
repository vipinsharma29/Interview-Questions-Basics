package leetCodeQuestions;

import java.util.Arrays;
import java.util.HashMap;

public class PreSumArray {

    public static void main(String[] args) {

//        int[] nums = {1,2,3,4,5};
//        int k = 5;
//
//        int count = 0;
//        int prefixSum = 0;
//
//        HashMap<Integer, Integer> map = new HashMap<>();
//        map.put(0, 1);
//
//        for (Integer n: nums) {
//            prefixSum += n;
//
//            if(map.containsKey(prefixSum - k)) {
//                count += map.get(prefixSum - k);
//            }
//            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
//        }
//
//        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
//        int max = Integer.MAX_VALUE;
//        int currSum = 0;
//
//        for(int i = 0; i < arr.length ;i++) {
//            currSum=currSum+arr[i];
//            if(currSum<max) {
//                max = currSum;
//            }
//            if (currSum>0) {
//                currSum = 0;
//                }
//        }

        int[] height = {1,8,6,2,5,4,8,3,7};
        int max1 = 0, left = 0, right = height.length - 1;

        while (left < right) {
            int minValue = height[left] < height[right] ? left : right;
            max1 = max1 < height[minValue] * (right-left) ? height[minValue] * (right-left): max1;
            if (height[left] < height[right]) {
                left++;
            } else if (height[left] > height[right]){
                right--;
            } else {
                left++;
                right--;
            }
        }

        
        System.out.println(max1);
    }
}
