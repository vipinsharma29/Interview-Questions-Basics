package interfaceExamples;

interface DemoInterfaceSix {
    void m1();

    interface DemoInterfaceSeven {
        void m1();
    }
}

class DemoInterfaceEight implements DemoInterfaceSix.DemoInterfaceSeven {

    @Override
    public void m1() {
        System.out.println("one");
    }
}

public class InterfaceRunnerFour {

    public static void main(String[] args) {
        DemoInterfaceSix.DemoInterfaceSeven a = new DemoInterfaceEight();
        a.m1();
    }
}
