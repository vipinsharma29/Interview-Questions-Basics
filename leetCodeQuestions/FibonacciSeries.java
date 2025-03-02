package leetCodeQuestions;

public class FibonacciSeries {

    public static void main(String[] args) {

        System.out.println(method1(16));
        System.out.println(method2(16));
    }

    private static int method1(int n) {
        if (n <= 1)
            return n;
        return method1(n - 1) + method1(n - 2);
    }

    private static int method2(int N) {
        int num1 = 0, num2 = 1;

        for (int i = 0; i < N; i++) {
            // Swap
            int num3 = num2 + num1;
            num1 = num2;
            num2 = num3;
        }
        return num1;
    }

}
