package arrayQuestions;

/*
You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.

Find and return the maximum profit you can achieve.
 */
public class MaxProfitProblem {

    public static void main(String[] args) {
        int[] arr = {7,6,4,3,1};
        int profit = 0;

        for (int i = 1; i < arr.length; i++) {
            System.out.println(arr[i] + ":" + arr[i - 1]);
            if (arr[i] > arr[i - 1]) {
                profit += arr[i] - arr[i - 1];
            }
        }
        System.out.println(profit);
    }
}
