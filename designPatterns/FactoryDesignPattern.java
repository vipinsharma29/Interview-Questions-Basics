package designPatterns;

import java.util.Objects;

interface Shape {
    String draw();

    double calculateArea(double... dimensions);
}

public class FactoryDesignPattern {
    public static void main(String[] args) {
        shapeFactory factory = new shapeFactory();

        try {
            Shape one = factory.getShape("Circle");
            System.out.println(one.draw() + " " + one.calculateArea(5));

            Shape two = factory.getShape("Square");
            System.out.println(two.draw() + " " + two.calculateArea(6));

            Shape three = factory.getShape("Rectangle");
            System.out.println(three.draw() + " " + three.calculateArea(6, 4));

            Shape four = factory.getShape("");
            four.draw();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class Circle implements Shape {

    @Override
    public String draw() {
        return "Circle";
    }

    @Override
    public double calculateArea(double... dimensions) {
        if (dimensions.length == 1)
            return Math.PI * dimensions[0] * dimensions[0];
        double radius = dimensions[0];
        return Math.PI * radius * radius;
    }

}

class Square implements Shape {

    @Override
    public String draw() {
        return "Square";
    }

    @Override
    public double calculateArea(double... dimensions) {
        if (dimensions.length != 1) {
            throw new IllegalArgumentException("Square requires 1 dimension (side length)");
        }
        double side = dimensions[0];
        return side * side;
    }
}

class Rectangle implements Shape {

    @Override
    public String draw() {
        return "Rectangle";
    }

    @Override
    public double calculateArea(double... dimensions) {
        if (dimensions.length != 2) {
            throw new IllegalArgumentException("Rectangle requires 2 dimension (side length, height)");
        }
        return (dimensions[0] * dimensions[1]);
    }
}

class shapeFactory {

    public Shape getShape(String name) {

        if (Objects.equals(name, "Circle"))
            return new Circle();
        else if (Objects.equals(name, "Square"))
            return new Square();
        else if (Objects.equals(name, "Rectangle"))
            return new Rectangle();
        else
            return null;
    }
}