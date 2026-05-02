package leetCodeQuestions;

public class SecondLargestElementInAraay {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
//        int[] arr = {35, 43, 23, 8, 0};
//        int[] arr = {1, 2};

        findSecondLargestElement(arr);
    }

    private static void findSecondLargestElement(int[] arr) {
        if (arr.length == 1) {
            System.out.println("Not Possible");
            return;
        }

        int largest = -1, secondLargest = -1;

//        for (int j : arr) {
//            if (j > largest)
//                largest = j;
//        }
//
//        for (int j : arr) {
//            if (j > secondLargest && j != largest)
//                secondLargest = j;
//        }

        for (int i : arr) {
            if (i > largest) {
                secondLargest = largest;
                largest = i;
            } else if (i < largest && i > secondLargest) {
                secondLargest = i;
            }
        }

        System.out.println(secondLargest);
    }

}

// time = O(2n) = O(n)
// space = O(1)