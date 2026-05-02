public class EvenOddPrintingTwoThread {

    public static void main(String[] args) {
        EvenOdd e = new EvenOdd(9);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    e.even();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    e.odd();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        t1.start();
        t2.start();
    }
}

class EvenOdd {

    private int count = 1;

    private int limit;

    EvenOdd(int limit) {
        this.limit = limit;
    }

    public synchronized void even() throws Exception {
        while (count <= limit) {
            if (count % 2 == 0) {
                System.out.println("EVEN: " + count);
                count++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public synchronized void odd() throws Exception {
        while (count <= limit) {
            if (count % 2 == 1) {
                System.out.println("ODD: " + count);
                count++;
                notifyAll();
            } else {
                wait();
            }
        }
    }
}