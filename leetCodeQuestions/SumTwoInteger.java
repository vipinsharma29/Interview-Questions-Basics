package leetCodeQuestions;

import java.util.Arrays;
import java.util.stream.Stream;

public class SumTwoInteger {

    public static void main(String[] args) {
        System.out.println(getSumOfIntegers(1300, 1500));
        System.out.println(hammingWeight(128));
        System.out.println(hammingWeight(11));
        System.out.println(hammingWeight2(1300));
    }

    private static int hammingWeight2(int n) {
        String binaryNumber = Integer.toBinaryString(n);
        int count = 0;
        for (char ch : binaryNumber.toCharArray())
            if (ch == '1')
                count++;
        return count;
    }

    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            if (n % 2 != 0) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    public static int getSumOfIntegers(int a, int b) {
        while (b != 0) {
            int sum = a ^ b;
            int carry = (a & b) << 1;
            a = sum;
            b = carry;
        }
        return a;
    }
}
