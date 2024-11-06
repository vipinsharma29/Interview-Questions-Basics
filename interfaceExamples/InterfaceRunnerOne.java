package interfaceExamples;

interface DemoInterfaceOne {

    int a = 2;

    static void example4(int a) {
        System.out.println("Static method in interface - cannot be overridden. Passed value: " + a);
    }

    void example2();

    void example2(int a);

    default void example3(int a, int b) {
        System.out.println("Default method in interface (two parameters): " + (a + b));
    }

    default void example3(int x, int b, int c) {
        System.out.println("Overloaded default method in interface (three parameters): " + (x + b + c));
    }

}

public class InterfaceRunnerOne implements DemoInterfaceOne {

    public static void main(String[] args) {
        InterfaceRunnerOne t = new InterfaceRunnerOne();
        t.example1();
        t.example2();
        t.example2(5);
        t.example3(3, 2);
        t.example3(3, 2, 2);
        DemoInterfaceOne.example4(4); // Calling static method in interface
    }

    public void example1() {
        System.out.println("Accessing constant value from interface: " + a);
    }

    @Override
    public void example2() {
        int localA = 3;
        int b = localA++;
        System.out.println("Local variable in example2 method: " + localA + ", " + b);
    }

    @Override
    public void example2(int a) {
        System.out.println("Method parameter and interface constant: " + a + ", " + DemoInterfaceOne.a);
    }

    @Override
    public void example3(int a, int b) {
        // Calling the default method of the interface directly
        DemoInterfaceOne.super.example3(a, b);
    }

    @Override
    public void example3(int a, int b, int c) {
        System.out.println("Overriding overloaded default method in interface: " + (a * b * c));
    }
}
