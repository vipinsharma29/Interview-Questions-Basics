package leetCodeQuestions;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        int result = 49;

        System.out.println(result == maxArea1(arr));
        System.out.println(result == maxArea2(arr));
    }

    // Note = max = Math.max(max, height[left] * (right - left));

    public static int maxArea2(int[] height) {
        int max = 0, left = 0, right = height.length - 1;

        while (left < right) {
            if (height[left] < height[right]) {
                max = max < height[left] * (right-left) ? height[left] * (right-left): max;
                left++;
            } else {
                max = max < height[right] * (right-left) ? height[right] * (right-left): max;
                right--;
            }
        }
        return max;
    }

    public static int maxArea1(int[] height) {
        int max = 0, left = 0, right = height.length - 1;

        while (left < right) {
            int minValue = height[left] < height[right] ? left : right;
            max = max < height[minValue] * (right-left) ? height[minValue] * (right-left): max;
            if (height[left] < height[right]) {
                left++;
            } else if (height[left] > height[right]){
                right--;
            } else {
                left++;
                right--;
            }
        }
        return max;
    }
}
