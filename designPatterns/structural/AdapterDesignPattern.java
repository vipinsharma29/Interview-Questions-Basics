package designPatterns.structural;

// Target interface
interface MobileCharger {
    int get5Volt();
}// Adaptee class

class Socket {
    public int get120Volt() {
        return 120;
    }
}// Adapter class

class SocketAdapter implements MobileCharger {
    private final Socket socket;

    public SocketAdapter(Socket socket) {
        this.socket = socket;
    }

    @Override
    public int get5Volt() {
        int volts = socket.get120Volt();
        // Convert 120V to 5V
        return convert120To5(volts);
    }

    private int convert120To5(int volts) {
        return volts / 24;
    }
}

public class AdapterDesignPattern {
    public static void main(String[] args) {
        Socket socket = new Socket();
        MobileCharger charger = new SocketAdapter(socket);

        System.out.println("Mobile Charger Output: " + charger.get5Volt() + "V");
    }
}