package interfaceExamples;


interface DemoInterfaceFour {

    int x = 3;

    void m1(DemoInterfaceFour a);
}

abstract class DemoInterfaceFive implements DemoInterfaceFour {

    int x = 20;

    void m1(DemoInterfaceFive c) {
        System.out.println("One");
    }
}

public class InterfaceRunnerThree extends DemoInterfaceFive {

    public static void main(String[] args) {
        DemoInterfaceFour a = new InterfaceRunnerThree();
        a.m1(null);

        DemoInterfaceFive b = new InterfaceRunnerThree();
        b.m1(null);
    }

    public void m1(DemoInterfaceFour a) {
        System.out.println("Two");
        super.m1(null);
    }

    public void m1(DemoInterfaceFive b) {
        System.out.println("Three");
    }
}
