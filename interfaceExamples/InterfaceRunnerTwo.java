package interfaceExamples;

interface DemoInterfaceTwo {

    int x = 3;

    void m1();

    default void m2() {
        System.out.println("A: m2");
    }

    default void m3() {
        System.out.println("A: m3");
    }
}

class DemoInterfaceThree implements DemoInterfaceTwo {

    int x = 20;

    @Override
    public void m1() {
        System.out.println(x + " " + DemoInterfaceTwo.x);
    }

    @Override
    public void m2() {
        System.out.println("B: m2");
    }
}

public class InterfaceRunnerTwo extends DemoInterfaceThree {

    public static void main(String[] args) {


        DemoInterfaceThree b = new DemoInterfaceThree();
        b.m1();
        b.m2();
        b.m3();
        System.out.println("b.x: " + b.x);

        DemoInterfaceTwo a = new DemoInterfaceThree();
        a.m1();
        a.m2();
        a.m3();
        System.out.println("a.x: " + DemoInterfaceTwo.x);
    }
}
