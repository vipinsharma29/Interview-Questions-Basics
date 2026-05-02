package leetCodeQuestions;

public class PeakElementInArray {

    public static void main(String[] args) {

//        int[] arr = {1, 2, 4, 5, 7, 8, 3, 10, 9};
        int[] arr = {10, 20, 15, 2, 23, 90, 80};

        peakElement(arr);
    }

    private static void peakElement(int[] arr) {
        if (arr.length == 0 || arr.length == 1)
            System.out.println("Not Possible");

        for (int i = 0; i < arr.length; i++) {
            boolean left = true, right = true;
            if (i > 0 && arr[i] <= arr[i - 1])
                left = false;

            if (i < arr.length - 1 && arr[i] <= arr[i + 1])
                right = false;

            if (left & right)
                System.out.println(arr[i]);
        }
    }
}
