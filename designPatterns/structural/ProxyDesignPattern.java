package designPatterns.structural;

interface Image {
    void display();
}

class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    private void loadFromDisk(String fileName) {
        System.out.println("1 " + fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying 1 " + fileName);
    }
}

class ProxyImage implements Image {
    private RealImage realImage;
    private final String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage != null) {
            realImage.display();
        } else {
            realImage = new RealImage(fileName);
            realImage.display();
        }
    }
}

public class ProxyDesignPattern {

    public static void main(String[] args) {
        Image image = new ProxyImage("example.jpg");

        // Image will be loaded from disk
        image.display();
        System.out.println();

        Image image2 = new ProxyImage("test.jpg");
        image2.display();
    }
}
