package leetCodeQuestions;

public class MaxProfitOnStock {

    public static void main(String[] args) {
        int[] arr = {7, 6, 4, 3, 1};
        maxProfit(arr);

        int[] arr2 = {7,1,5,3,6,4};
        maxProfit(arr2);
    }

    private static void maxProfit(int[] arr) {
        int buyPrice = arr[0];
        int maxProfit = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= buyPrice) {
                buyPrice = arr[i];
                continue;
            }
            if (arr[i] - buyPrice > maxProfit)
                maxProfit = arr[i] - buyPrice;
        }
        System.out.println(maxProfit);
    }
}
