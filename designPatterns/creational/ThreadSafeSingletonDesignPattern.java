package designPatterns.creational;

public class ThreadSafeSingletonDesignPattern {

    private static volatile ThreadSafeSingletonDesignPattern instance;

    private ThreadSafeSingletonDesignPattern() {
        // private constructor to prevent instantiation
    }

    public static ThreadSafeSingletonDesignPattern getInstance() {
        if (instance == null) {
            synchronized (ThreadSafeSingletonDesignPattern.class) {
                if (instance == null) {
                    instance = new ThreadSafeSingletonDesignPattern();
                }
            }
        }
        return instance;
    }
}