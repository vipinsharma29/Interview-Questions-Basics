package leetCodeQuestions;

public class FindSecondMaxElement {

    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 2, 3};
 		findSecondMaxElement(arr);
    }

    private static void findSecondMaxElement(int[] arr) {
        int max = -1, min = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                min = max;
                max = arr[i];
            } else if (arr[i] > min && arr[i] < max) {
                min = arr[i];
            }
        }

        System.out.println(min);
    }
}
