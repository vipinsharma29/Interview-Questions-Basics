package designPatterns;

interface PrototypeShape {
    PrototypeShape getClone();

    void draw();
}

class PrototypeCircle implements PrototypeShape {
    private final int radius;
    private final String color;

    public PrototypeCircle(int radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    // Copy constructor for cloning
    private PrototypeCircle(PrototypeCircle circle) {
        this.radius = circle.radius;
        this.color = circle.color;
    }

    @Override
    public PrototypeShape getClone() {
        return new PrototypeCircle(this);
    }

    @Override
    public void draw() {
        System.out.println("Drawing a " + color + " circle with radius " + radius);
    }
}

class PrototypeRectangle implements PrototypeShape {
    private final int width;
    private final int height;
    private final String color;

    public PrototypeRectangle(int width, int height, String color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    // Copy constructor for cloning
    private PrototypeRectangle(PrototypeRectangle rectangle) {
        this.width = rectangle.width;
        this.height = rectangle.height;
        this.color = rectangle.color;
    }

    @Override
    public PrototypeShape getClone() {
        return new PrototypeRectangle(this);
    }

    @Override
    public void draw() {
        System.out.println("Drawing a " + color + " rectangle with width " + width + " and height " + height);
    }
}


public class PrototypeDesignPattern {

    public static void main(String[] args) {
        // Create initial shapes
        PrototypeShape circle1 = new PrototypeCircle(10, "Red");
        PrototypeShape rectangle1 = new PrototypeRectangle(20, 15, "Blue");

        // Clone shapes
        PrototypeShape circle2 = circle1.getClone();
        PrototypeShape rectangle2 = rectangle1.getClone();

        // Draw the original and cloned shapes
        circle1.draw();      // Original red circle
        circle2.draw();      // Cloned red circle
        rectangle1.draw();   // Original blue rectangle
        rectangle2.draw();   // Cloned blue rectangle
    }
}
