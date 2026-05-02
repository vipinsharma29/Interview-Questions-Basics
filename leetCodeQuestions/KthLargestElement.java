package leetCodeQuestions;

import java.util.PriorityQueue;

public class KthLargestElement {

    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 2, 3};
        kthLargestElement(arr, 3);
    }

    private static void kthLargestElement(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : arr) {
            pq.add(i);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        System.out.println(pq.peek());
    }
}
