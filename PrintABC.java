import java.io.BufferedReader;

public class PrintABC {
    private int turn = 0; // 1 for A, 2 for B, 3 for C

    public synchronized void printA() {
        while (turn % 3 != 0) { try { wait(); } catch (InterruptedException e) {} }
        System.out.print("A");
        turn++;
        notifyAll();
    }

    public synchronized void printB() {
        while (turn % 3 != 1) { try { wait(); } catch (InterruptedException e) {} }
        System.out.print("B");
        turn++;
        notifyAll();
    }

    public synchronized void printC() {
        while (turn % 3 != 2) { try { wait(); } catch (InterruptedException e) {} }
        System.out.print("C");
        turn++;
        notifyAll();
    }

    public static void main(String[] args) {
        PrintABC obj = new PrintABC();
        int repeat = 1;

        new Thread(obj::printA).start();
        new Thread(obj::printB).start();
        new Thread(obj::printC).start();
    }
}