package leetCodeQuestions;

public class ClosestElementInASortedArray {

    public static void main(String[] args) {
        int[] arr = {2, 5, 6, 7, 8, 8, 9, 15, 18, 22, 32};

        int k = 17;

        System.out.println(findCloset(arr, k));
    }

    private static int findCloset(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) return arr[mid];
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }

        return Math.abs(arr[left] - target) < Math.abs(arr[right] - target) ? arr[left] : arr[right];
    }

}
