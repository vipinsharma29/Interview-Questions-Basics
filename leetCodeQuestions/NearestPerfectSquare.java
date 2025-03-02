package leetCodeQuestions;

//Find the nearest perfect square of the given number :
//    i/p : 51
//    o/p : 49
//
//    i/p : 33
//    o/p : 36

//O(1) → We perform a constant number of mathematical operations.
//O(1) → We use only a few integer variables.

public class NearestPerfectSquare {

    public static void main(String[] args) {
//        System.out.println(nearestPerfectSquare(30));
//        System.out.println(nearestPerfectSquare(33));
//        System.out.println(nearestPerfectSquare(51));
//        System.out.println();
        System.out.println(nearestPerfectSquare2(30));
        System.out.println(nearestPerfectSquare2(33));
        System.out.println(nearestPerfectSquare2(51));
    }

    public static int nearestPerfectSquare(int n) {
        int sqrt = (int) Math.sqrt(n);
        int lowerSquare = sqrt * sqrt;
        int higherSquare = (sqrt + 1) * (sqrt + 1);

        return (Math.abs(lowerSquare - n) < Math.abs(higherSquare - n)) ? lowerSquare : higherSquare;
    }

    public static int nearestPerfectSquare2(int n) {
        int lowerSquare = 0, higherSquare = 0;
        int x = 0;

        while (x * x <= n) {
            lowerSquare = x * x;
            x++;
        }
        higherSquare = x * x;

        return (Math.abs(lowerSquare - n) < Math.abs(higherSquare - n)) ? lowerSquare : higherSquare;
    }
}
