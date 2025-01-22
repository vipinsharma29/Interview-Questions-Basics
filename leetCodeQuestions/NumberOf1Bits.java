package leetCodeQuestions;

public class NumberOf1Bits {
    public static void main(String[] args) {
        System.out.println(hammingWeight(11));
        System.out.println(hammingWeight(128));
    }

    public static int hammingWeight(int n) {
        // String binaryNumber = Integer.toBinaryString(n);
        int count = 0;
        // for(char ch: binaryNumber.toCharArray())
        //     if(ch == '1')
        //         count++;

        while (n != 0) {
            if (n % 2 != 0) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }
}
